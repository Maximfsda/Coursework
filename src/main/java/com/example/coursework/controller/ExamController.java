package com.example.coursework.controller;

import com.example.coursework.exception.UnsufficentQuestionException;
import com.example.coursework.model.Question;
import com.example.coursework.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExamService examService;

    @ExceptionHandler(UnsufficentQuestionException.class)
    public ResponseEntity<String> handleException(){
        return ResponseEntity
                .badRequest()
                .body("Нетостаточно вопросов");
    }

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") int amount){
        return examService.getQuestions(amount);
    }

}
