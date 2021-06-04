package com.roganov.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "poll")
public class PollEntity implements DatabaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private Boolean isActive;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "users_polls",joinColumns = @JoinColumn(name = "poll_title"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> respondents;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "pools_questions",
            joinColumns = @JoinColumn(name = "poll_title"),
            inverseJoinColumns =@JoinColumn(name = "question_id"))
    private List<QuestionEntity> questions;
}
