package com.example.coursework.service;

import com.example.coursework.model.Question;

import java.util.*;

public class JavaQustionService implements QuestionService {

    private final static Random RANDOM = new Random();
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question,String answer){
        Question q = new Question(question,answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question){
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question){
        questions.remove(question);
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(RANDOM.nextInt(0, questions.size()))
                .findFirst()
                .orElseThrow();
    }


}
