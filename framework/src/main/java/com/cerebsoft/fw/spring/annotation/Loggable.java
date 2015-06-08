package com.cerebsoft.fw.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cerebsoft.fw.logger.LogLevel;



/**
 * Annotation for logging both entry and exit points of a method call. Also logs
 * params passed to method call.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {

	LogLevel value();
}
