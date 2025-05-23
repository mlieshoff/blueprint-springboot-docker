package com.mlieshoff.blueprint.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** This class represents an entity object in the underlying data storage. */
@Data
@Entity(name = "example")
@NoArgsConstructor
@AllArgsConstructor
public class ExampleEntity {

    @Id private Long id;

    private String value;
}
