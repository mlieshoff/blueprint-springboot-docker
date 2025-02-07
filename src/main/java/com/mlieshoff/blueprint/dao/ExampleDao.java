package com.mlieshoff.blueprint.dao;

import java.util.List;

/** This interface provides access to the examples of the underlying data storage. */
public interface ExampleDao {

    /**
     * Lists all available examples.
     *
     * @return a list with all available examples
     */
    List<ExampleDaoDto> list();
}
