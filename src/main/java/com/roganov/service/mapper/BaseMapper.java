package com.roganov.service.mapper;


import com.roganov.entity.DatabaseModel;
import com.roganov.model.BusinessModel;

import java.util.List;

public interface BaseMapper< E extends DatabaseModel, W extends BusinessModel> {

    W toBusinessModel(E entity);
    E toDatabaseModel(W model);

    List<W> toDatabaseModel(List<E> pollEntities);
    List<E> toBusinessModel(List<W> pollModels);

}
