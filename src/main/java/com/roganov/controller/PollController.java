package com.roganov.controller;

import com.roganov.model.Poll;
import com.roganov.model.Question;
import com.roganov.service.PollService;
import com.roganov.service.mapper.PollMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Primary
@Controller
@RequestMapping("/api/v1/")
//@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/admin/createPoll/")
    public void createPoll(@RequestBody Poll newPollInWm) {
        pollService.savePoll(newPollInWm);
    }

    @PutMapping("/admin/updatePoll/")
    public void updatePoll(@RequestBody Poll pollUpdatesInWm) {
        pollService.updatePoll(pollUpdatesInWm);
    }

    @DeleteMapping("/admin/deletePoll/{name}")
    public void deletePoll(@PathVariable String pollName) {
        pollService.deletePoll(pollName);
    }

    //    TODO в дальнейшем нужно сделать поиск по id опроса?!
    @PostMapping("/admin/addQuestion/{pollTitle}")
    public ResponseEntity<Poll> addQuestion(@RequestBody Question newQuestion
            , @PathVariable String pollTitle) {

        if (pollService.findPollByTitle(pollTitle) != null) {
            if (!(pollService.findPollByTitle(pollTitle).getQuestions()).isEmpty()) {
                {
                    pollService.findPollByTitle(pollTitle).getQuestions().add(newQuestion);
                    return ResponseEntity.ok().build();
                }
            }
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/getAllActivePolls/")
    public ResponseEntity<List<Poll>> getAllActivePolls() {
        List<Poll> activePolls = pollService.getAllActivePolls();
        if (!activePolls.isEmpty()) {
            return ResponseEntity.ok(activePolls);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/takePoll/{title}")
    public ResponseEntity<Poll> takePoll(String title) {
        Poll poll = pollService.findPollByTitle(title);
        if (poll != null && !poll.getQuestions().isEmpty()) {
            return ResponseEntity.ok(poll);
        }

        return ResponseEntity.noContent().build();
    }

//    не успел продумать работу прохождения запросов,
//    не уверен, что данный функционал имплементирован корректно
    @PostMapping("/user/saveTakenPoll/")
    public ResponseEntity<Poll> saveTakenPoll(@RequestBody Poll takenPollInWm){
        pollService.savePoll(takenPollInWm);
        return ResponseEntity.ok().build();
    }

}

