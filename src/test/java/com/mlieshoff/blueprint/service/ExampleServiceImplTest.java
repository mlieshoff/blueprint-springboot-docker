package com.mlieshoff.blueprint.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.mlieshoff.blueprint.dao.ExampleDao;
import com.mlieshoff.blueprint.dao.ExampleDaoDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplTest {

    @InjectMocks private ExampleServiceImpl unitUnderTest;

    @Mock private ExampleDao exampleDao;

    @Test
    void list_whenCalled_thenReturnResults() {
        List<ExampleServiceDto> expected =
                List.of(
                        new ExampleServiceDto(1L, "example1"),
                        new ExampleServiceDto(2L, "example2"));
        when(exampleDao.list())
                .thenReturn(
                        List.of(
                                new ExampleDaoDto(1L, "example1"),
                                new ExampleDaoDto(2L, "example2")));

        List<ExampleServiceDto> actual = unitUnderTest.list();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
