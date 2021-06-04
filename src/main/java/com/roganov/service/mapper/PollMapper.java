package com.roganov.service.mapper;


import com.roganov.entity.PollEntity;
import com.roganov.model.Poll;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PollMapper extends BaseMapper<PollEntity,Poll> {
}
