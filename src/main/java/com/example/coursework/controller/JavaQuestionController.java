package com.example.coursework.controller;


import com.example.coursework.model.Question;
import com.example.coursework.service.JavaQustionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQustionService javaQustionService;

    public JavaQuestionController(JavaQustionService javaQustionService) {
        this.javaQustionService = javaQustionService;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return this.javaQustionService.getAll();
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer){
        return this.javaQustionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer){
        Question q = new Question(question,answer);
        return this.javaQustionService.remove(q);
    }

}
