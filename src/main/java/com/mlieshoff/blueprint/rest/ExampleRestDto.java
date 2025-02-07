package com.mlieshoff.blueprint.rest;

/**
 * This record represents a REST DTO containing the values of an example.
 *
 * @param id ID of the example
 * @param value value of the example
 */
public record ExampleRestDto(Long id, String value) {}
