package com.mlieshoff.blueprint.base.integration.cdc;

import com.mlieshoff.blueprint.BlueprintApplication;
import com.mlieshoff.blueprint.base.integration.ContainerizedIntegrationTestBase;
import com.mlieshoff.blueprint.rest.ExampleRestController;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BlueprintApplication.class)
public abstract class CdcBaseClass extends ContainerizedIntegrationTestBase {

    @Autowired private ExampleRestController unitUnderTest;

    @BeforeEach
    void setUp() {
        EncoderConfig encoderConfig =
                new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().encoderConfig(encoderConfig);
        RestAssuredMockMvc.standaloneSetup(unitUnderTest);
    }
}
