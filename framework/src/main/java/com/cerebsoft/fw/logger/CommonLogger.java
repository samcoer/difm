package com.cerebsoft.fw.logger;

import org.apache.log4j.Logger;

public interface CommonLogger {

	boolean isLogLevel(LogLevel logLevel, Logger logger);

	void log(LogLevel logLevel, Class<?> clazz, Throwable throwable, String pattern, Object... arguments);

	void log(LogLevel logLevel, Class<?> clazz, String message);
}
