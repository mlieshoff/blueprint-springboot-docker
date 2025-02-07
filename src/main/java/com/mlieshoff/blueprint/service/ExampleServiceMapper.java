package com.mlieshoff.blueprint.service;

import com.mlieshoff.blueprint.dao.ExampleDaoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/** This class represents a mapper to map DA DTOs to service DTOs. */
@Mapper
interface ExampleServiceMapper {

    ExampleServiceMapper INSTANCE = Mappers.getMapper(ExampleServiceMapper.class);

    /**
     * Maps an example DAO DTO to an example service DTO.
     *
     * @param exampleDaoDto the DAO DTO to map
     * @return a new created example service DTO instance.
     */
    ExampleServiceDto exampleDaoDtoToExampleServiceDto(ExampleDaoDto exampleDaoDto);
}
