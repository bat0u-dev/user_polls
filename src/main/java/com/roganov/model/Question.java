package com.roganov.model;

import com.roganov.model.enums.QuestionType;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Question implements BusinessModel{

    private Long id;
    private String text;
    private QuestionType questionType;
    private List<Poll> pollsList;
    private String textAnswer;
    private Answer answer;
    private List<Answer> answers;
}
