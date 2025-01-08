package com.mlieshoff.blueprint.rest;

import com.mlieshoff.blueprint.service.ExampleService;
import com.mlieshoff.blueprint.service.ExampleServiceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ExampleRestControllerMockMvcTest {

    private MockMvc mockMvc;

    @Mock
    private ExampleService exampleService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ExampleRestController(exampleService)).build();
    }

    @Test
    void listExamples_whenEmpty_thenReturnResults() throws Exception {

        mockMvc.perform(get("/api/examples/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    void listExamples_whenWithExamples_thenReturnResults() throws Exception {
        when(exampleService.list()).thenReturn(List.of(new ExampleServiceDto(4711L, "value")));

        mockMvc.perform(get("/api/examples/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":4711,\"value\":\"value\"}]")));
    }
}
