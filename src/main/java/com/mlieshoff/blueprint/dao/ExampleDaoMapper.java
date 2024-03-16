package com.mlieshoff.blueprint.dao;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface ExampleDaoMapper {

    ExampleDaoMapper INSTANCE = Mappers.getMapper(ExampleDaoMapper.class);

    ExampleDaoDto exampleEntityToExampleDaoDto(ExampleEntity exampleEntity);
}
