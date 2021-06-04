package com.roganov.model;

import com.roganov.entity.QuestionEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Component
@RequiredArgsConstructor
public class Answer implements BusinessModel{

    private Long id;
    private String description;
    private Long respondentId;
    private Question question;
}
