package com.telusko.controller;

import com.telusko.model.Question;
import com.telusko.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
public class QuestionController
   {
       @Autowired
       QuestionService questionService;

       @GetMapping("allquestions")
       public ResponseEntity<List<Question>> getAllQuetions()
       {
           return questionService.getAllQuestions();
       }

       @GetMapping("category/{category}")
       public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
       {
           return questionService.getQuestionsByCategory(category);
       }

       @PostMapping("add")
       public ResponseEntity<String> addQuestion(@RequestBody Question question)
       {
           return questionService.addQuestion(question);
       }


   }
