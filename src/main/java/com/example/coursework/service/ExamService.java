package com.example.coursework.service;

import com.example.coursework.model.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getQuestions(int amount);
}

