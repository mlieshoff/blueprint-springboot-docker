package com.mlieshoff.blueprint;

import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

@ExtendWith(MockitoExtension.class)
class BlueprintApplicationTest {

    private static final String[] ARGS = {"a", "b"};

    @Test
    void main_whenWithValidParameters_thenStartSpringApplication() {
        try (MockedStatic<SpringApplication> springApplicationMockedStatic =
                Mockito.mockStatic(SpringApplication.class)) {

            BlueprintApplication.main(ARGS);

            springApplicationMockedStatic.verify(
                    () -> SpringApplication.run(eq(BlueprintApplication.class), eq(ARGS)));
        }
    }
}
