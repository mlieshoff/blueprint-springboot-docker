package com.mlieshoff.blueprint.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.mlieshoff.blueprint.base.integration.dbunit.DatabaseExpectation;
import com.mlieshoff.blueprint.base.integration.dbunit.DatabaseIntegrationTestBase;
import com.mlieshoff.blueprint.base.integration.dbunit.DatabaseSetUp;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
class ExampleDaoDatabaseIntegrationTest extends DatabaseIntegrationTestBase {

    @Autowired private ExampleDaoImpl unitUnderTest;

    @Test
    @DatabaseSetUp
    @DatabaseExpectation
    void list() {
        List<ExampleDaoDto> expected =
                List.of(new ExampleDaoDto(1L, "example1"), new ExampleDaoDto(2L, "example2"));

        List<ExampleDaoDto> actual = unitUnderTest.list();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
