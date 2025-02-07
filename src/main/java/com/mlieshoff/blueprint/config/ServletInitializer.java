package com.mlieshoff.blueprint.config;

import com.mlieshoff.blueprint.BlueprintApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** This class provides a possibility to configure the application servlet. */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BlueprintApplication.class);
    }
}
