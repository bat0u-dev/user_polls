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

//  аннотации lombok не отрабатывают корректно, прищлось создать геттеры и сетерры явно
    public List<Question> getQuestions() {
        return questions;
    }

    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Long> getRespondentsId() {
        return respondentsId;
    }

    public void setRespondentsId(List<Long> respondentsId) {
        this.respondentsId = respondentsId;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
