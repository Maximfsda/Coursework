package com.example.coursework.service;

import com.example.coursework.exception.UnsufficentQuestionException;
import com.example.coursework.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExamServiceImpl implements ExamService {

    public final QuestionService questionService;

    public ExamServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if(questionService.getAll().size() < amount){
            throw new UnsufficentQuestionException();
        }
        while(questions.size() <amount){
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
