package com.mlieshoff.blueprint.rest;

import com.mlieshoff.blueprint.base.integration.ContainerizedIntegrationTestBase;
import com.mlieshoff.blueprint.config.ApplicationConfiguration;
import io.restassured.RestAssured;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
@WebAppConfiguration
class ExampleRestControllerIntegrationTest extends ContainerizedIntegrationTestBase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void givenWebApplicationContext_whenServletContext_thenProvideExampleRestController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertThat(servletContext).isNotNull();
        assertThat(servletContext).isInstanceOf(MockServletContext.class);
        assertThat(webApplicationContext.getBean("exampleRestController")).isNotNull();
    }

    @Test
    void listPageURI_whenCalled_thenReturnResults() throws Exception {

        mockMvc.perform(get("/api/examples/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"value\":\"example1\"},{\"id\":2,\"value\":\"example2\"}]")));
    }

}
