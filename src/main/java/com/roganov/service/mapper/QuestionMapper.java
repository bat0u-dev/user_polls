package com.roganov.service.mapper;

import com.roganov.entity.QuestionEntity;
import com.roganov.model.Question;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<QuestionEntity, Question>{
}
