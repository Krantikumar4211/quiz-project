package com.telusko.service;


import com.telusko.Dao.QuestionDao;
import com.telusko.Dao.QuizDao;
import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

     public ResponseEntity<String> createQuiz(String category, int numQ, String title)
     {
         List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

         Quiz quiz = new Quiz();
         quiz.setTitle(title);
         quiz.setQuestions(questions);
         quizDao.save(quiz);

         return new ResponseEntity<>("Success", HttpStatus.CREATED);
     }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);

        if (quiz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Question> questionsFromDB = quiz.get().getQuestions();

        List<QuestionWrapper> questionFromUser = new ArrayList<>();

        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );
            questionFromUser.add(qw);
        }

        return new ResponseEntity<>(questionFromUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer quizId, List<Response> responses) {
        Optional<Quiz> optQuiz = quizDao.findById(quizId);
        if (optQuiz.isEmpty()) {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }

        List<Question> questions = optQuiz.get().getQuestions();
        // build map for O(1) lookup by question id
        Map<Integer, Question> qMap = new HashMap<>();
        for (Question q : questions) qMap.put(q.getId(), q);

        int score = 0;
        if (responses != null) {
            for (Response r : responses) {
                if (r == null || r.getId() == null || r.getResponse() == null) continue;
                Question q = qMap.get(r.getId());
                if (q == null) continue;
                String correct = q.getRightAnswer();
                if (correct != null && correct.equalsIgnoreCase(r.getResponse().trim())) {
                    score++;
                }
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }

}
