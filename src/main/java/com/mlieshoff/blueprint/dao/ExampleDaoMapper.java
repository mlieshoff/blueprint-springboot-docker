package com.mlieshoff.blueprint.dao;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/** This class represents a mapper to map entities to DAO DTOs. */
@Mapper
interface ExampleDaoMapper {

    ExampleDaoMapper INSTANCE = Mappers.getMapper(ExampleDaoMapper.class);

    /**
     * Maps an example entity to a DAO DTO.
     *
     * @param exampleEntity the entity to map
     * @return a new created example DAO DTO instance.
     */
    ExampleDaoDto exampleEntityToExampleDaoDto(ExampleEntity exampleEntity);
}
