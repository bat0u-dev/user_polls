package com.roganov.entity;

import com.roganov.model.Poll;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity implements DatabaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fio;
    private String login;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "users_polls",joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "poll_title"))
    private List<PollEntity> takenPolls;
}
