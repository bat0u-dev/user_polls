package com.roganov.service;

import com.roganov.entity.PollEntity;
import com.roganov.model.Poll;
import com.roganov.repository.PollRepository;
import com.roganov.service.mapper.PollMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class PollServiceImpl implements PollService {

    private final PollMapper pollMapper;
    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository, PollMapper pollMapper) {
        this.pollRepository = pollRepository;
        this.pollMapper = pollMapper;
    }

    @Override
    public void savePoll(Poll newPoll) {
        pollRepository.save(pollMapper.toDatabaseModel(newPoll));
    }

    @Override
    public void updatePoll(Poll pollUpdates) {
        pollRepository.save(pollMapper.toDatabaseModel(pollUpdates));
    }

    @Override
    public void deletePoll(String pollTitle) {
        pollRepository.delete(pollRepository.findByTitle(pollTitle));
    }

    @Override
    public Poll findPollByTitle(String pollTitle) {
        PollEntity curPollEntity = pollRepository.findByTitle(pollTitle);
        if (curPollEntity != null) {
            return pollMapper.toBusinessModel(pollRepository.findByTitle(pollTitle));
        }
        //обработано в контроллере!
        return null;
    }

    @Override
    public List<Poll> getAllActivePolls() {
        return pollMapper.toDatabaseModel(pollRepository.findByIsActive(true));
    }
}
