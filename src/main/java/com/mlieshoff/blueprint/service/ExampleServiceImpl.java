package com.mlieshoff.blueprint.service;

import com.mlieshoff.blueprint.dao.ExampleDao;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** This class represents an implementation of an example service. */
@Service
@RequiredArgsConstructor
class ExampleServiceImpl implements ExampleService {

    private final ExampleDao exampleDao;

    /**
     * Lists all available examples.
     *
     * @return a list with example service DTOs
     */
    @Override
    public List<ExampleServiceDto> list() {
        return exampleDao.list().stream()
                .map(ExampleServiceMapper.INSTANCE::exampleDaoDtoToExampleServiceDto)
                .toList();
    }
}
