package com.mlieshoff.blueprint.dao;

import org.springframework.data.repository.CrudRepository;

/** This interface represents a CRUD repository to access examples. */
interface ExampleRepository extends CrudRepository<ExampleEntity, Long> {}
