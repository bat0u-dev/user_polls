package com.roganov.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class Poll implements BusinessModel{

    private Long id;
//  Название - предположительно уникальный параметр опроса
    private String title;
    @Setter(AccessLevel.NONE)
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private Boolean isActive;
    private List<Long> respondentsId;

    public List<Question> getQuestions() {
        return questions;
    }

    private List<Question> questions;
}
