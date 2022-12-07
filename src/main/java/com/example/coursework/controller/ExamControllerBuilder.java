package com.example.coursework.controller;

import com.example.coursework.service.ExamService;

public class ExamControllerBuilder {
    private ExamService examService;

    public ExamControllerBuilder setExamService(ExamService examService) {
        this.examService = examService;
        return this;
    }

    public ExamController createExamController() {
        return new ExamController(examService);
    }
}