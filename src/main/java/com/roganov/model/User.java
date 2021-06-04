package com.roganov.model;


import com.roganov.entity.PollEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.List;

@Component
public class User implements BusinessModel{

    private Long id;
    private String fio;
    private String login;
    private String password;
    private List<Poll> takenPolls;
}
