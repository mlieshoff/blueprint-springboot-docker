package com.mlieshoff.blueprint.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** This class job is to provide an application configuration. */
@Configuration
@ComponentScan("com.mlieshoff.blueprint")
@EnableAutoConfiguration
public class ApplicationConfiguration {}
