package com.roganov.entity;

import com.roganov.model.Answer;
import com.roganov.model.Poll;
import com.roganov.model.enums.QuestionType;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class QuestionEntity implements DatabaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private QuestionType questionType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "pools_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "poll_title"))
    private List<PollEntity> polls;

    private String textAnswer;
    private Answer answer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AnswerEntity> answers;
}
