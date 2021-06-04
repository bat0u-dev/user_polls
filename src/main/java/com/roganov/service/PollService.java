package com.roganov.service;

import com.roganov.entity.PollEntity;
import com.roganov.model.Poll;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PollService {

    void savePoll(Poll newPoll);

    void updatePoll(Poll pollUpdates);

    void deletePoll(String pollName);

    Poll findPollByTitle(String pollTitle);

    List<Poll> getAllActivePolls();
}
