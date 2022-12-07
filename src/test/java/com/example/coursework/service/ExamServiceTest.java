package com.example.coursework.service;

import com.example.coursework.exception.UnsufficentQuestionException;
import com.example.coursework.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExamServiceImpl examService;
    @Test
    void whenAmountOfQuestionsIsSufficentThenGetQuestionReturnExactAmount(){
        List<Question> questionsList = List.of(
                new Question("q1","a1"),
                new Question("q2","a2"),
                new Question("q3","a3")
        );
        when(questionService.getAll()).thenReturn(questionsList);
        when(questionService.getRandomQuestion())
                .thenReturn(
                        questionsList.get(0),
                        questionsList.get(1));

        assertThat(examService.getQuestions(2))
                .hasSize(2)
                .containsOnly(questionsList.get(0),questionsList.get(1));
    }

    @Test
    void whenAmountOfQuestionsIsSufficentThenMethodThrowsExeption(){

        when(questionService.getAll()).thenReturn(Collections.emptyList());
        assertThatThrownBy(() -> examService.getQuestions(100))
                .isInstanceOf(UnsufficentQuestionException.class);
    }

}
