package com.roganov.repository;

import com.roganov.entity.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PollRepository extends JpaRepository<PollEntity,Long> {

    PollEntity findByTitle (String pollTitle);

    List<PollEntity> findByIsActive(Boolean isActive);
}
