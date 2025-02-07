package com.mlieshoff.blueprint.service;

import java.util.List;

/** This interface provides methods for accessing examples. */
public interface ExampleService {

    /**
     * Lists all available examples as service DTOs.
     *
     * @return a list with all available examples as service DTOs
     */
    List<ExampleServiceDto> list();
}
