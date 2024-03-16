package com.mlieshoff.blueprint.dao;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class ExampleDaoImpl implements ExampleDao {

    private final ExampleRepository exampleRepository;

    @Override
    public List<ExampleDaoDto> list() {
        List<ExampleDaoDto> result = new ArrayList<>();
        for (ExampleEntity exampleEntity : exampleRepository.findAll()) {
            result.add(ExampleDaoMapper.INSTANCE.exampleEntityToExampleDaoDto(exampleEntity));
        }
        return result;
    }
}
