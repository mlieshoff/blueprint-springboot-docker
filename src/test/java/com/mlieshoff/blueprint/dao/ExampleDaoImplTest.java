package com.mlieshoff.blueprint.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExampleDaoImplTest {

    @InjectMocks private ExampleDaoImpl unitUnderTest;

    @Mock private ExampleRepository exampleRepository;

    @Test
    void list_whenCalled_thenReturnResults() {
        List<ExampleDaoDto> expected =
                List.of(new ExampleDaoDto(1L, "example1"), new ExampleDaoDto(2L, "example2"));
        when(exampleRepository.findAll())
                .thenReturn(
                        List.of(
                                new ExampleEntity(1L, "example1"),
                                new ExampleEntity(2L, "example2")));

        List<ExampleDaoDto> actual = unitUnderTest.list();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
