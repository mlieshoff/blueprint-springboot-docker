package com.mlieshoff.blueprint.service;

import com.mlieshoff.blueprint.dao.ExampleDaoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface ExampleServiceMapper {

    ExampleServiceMapper INSTANCE = Mappers.getMapper(ExampleServiceMapper.class);

    ExampleServiceDto exampleDaoDtoToExampleServiceDto(ExampleDaoDto exampleDaoDto);
}
