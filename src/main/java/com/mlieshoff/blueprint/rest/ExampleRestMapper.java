package com.mlieshoff.blueprint.rest;

import com.mlieshoff.blueprint.service.ExampleServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface ExampleRestMapper {

    ExampleRestMapper INSTANCE = Mappers.getMapper(ExampleRestMapper.class);

    ExampleRestDto exampleServiceDtoToExampleRestDto(ExampleServiceDto exampleServiceDto);
}
