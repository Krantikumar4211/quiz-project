package com.telusko.controller;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.telusko.service.QuizService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("quiz")
public class QuizController
    {
        @Autowired
        QuizService quizService;

        @PostMapping("create")
        public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title)
        {
            return quizService.createQuiz(category,numQ,title);
        }

        @GetMapping("get/{id}")
        public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
        {
            return quizService.getQuizQuestions(id);
        }

        @PostMapping("submit/{id}")
        public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
            return quizService.calculateResult(id, responses);
        }


    }
