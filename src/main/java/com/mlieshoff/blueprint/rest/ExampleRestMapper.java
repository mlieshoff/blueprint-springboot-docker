package com.mlieshoff.blueprint.rest;

import com.mlieshoff.blueprint.service.ExampleServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/** This interface represents a mapper to map an example service DTO to a REST DTO. */
@Mapper
interface ExampleRestMapper {

    ExampleRestMapper INSTANCE = Mappers.getMapper(ExampleRestMapper.class);

    /**
     * Maps an example service DTO to an example REST DTO.
     *
     * @param exampleServiceDto the service DTO to map
     * @return a new created example REST DTO instance
     */
    ExampleRestDto exampleServiceDtoToExampleRestDto(ExampleServiceDto exampleServiceDto);
}
