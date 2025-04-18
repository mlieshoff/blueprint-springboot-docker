package com.mlieshoff.blueprint.base.integration.dbunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DatabaseSetUp {

    String value() default "";

    String[] dependsOn() default {};
}
