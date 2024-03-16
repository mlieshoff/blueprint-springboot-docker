package com.mlieshoff.blueprint.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.mlieshoff.blueprint.service.ExampleService;
import com.mlieshoff.blueprint.service.ExampleServiceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExampleRestControllerTest {

    @InjectMocks private ExampleRestController unitUnderTest;

    @Mock private ExampleService exampleService;

    @Test
    void listExamples_whenCalled_thenReturnResults() {
        List<ExampleRestDto> expected =
                List.of(new ExampleRestDto(1L, "example1"), new ExampleRestDto(2L, "example2"));
        when(exampleService.list())
                .thenReturn(
                        List.of(
                                new ExampleServiceDto(1L, "example1"),
                                new ExampleServiceDto(2L, "example2")));

        List<ExampleRestDto> actual = unitUnderTest.listExamples();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
