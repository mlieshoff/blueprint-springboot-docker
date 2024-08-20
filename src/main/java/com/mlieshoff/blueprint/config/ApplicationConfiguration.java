package com.mlieshoff.blueprint.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mlieshoff.blueprint")
@EnableAutoConfiguration
public class ApplicationConfiguration {}
