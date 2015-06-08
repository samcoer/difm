package com.cerebsoft.fw.logger;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("logger")
public class Log4jLogger implements CommonLogger {

	public boolean isLogLevel(LogLevel logLevel, Logger logger) {

		boolean result = false;

		switch (logLevel)
		{

		case DEBUG:
			result = logger.isDebugEnabled();
			break;
		case ERROR:
			result = logger.isEnabledFor(Priority.ERROR);
			break;
		case INFO:
			result = logger.isInfoEnabled();
			break;
		case TRACE:
			result = logger.isTraceEnabled();
			break;
		case WARN:
			result = logger.isEnabledFor(Priority.WARN);
			break;
		default:
			result = false;
		}
		return result;
	}

	public void log(LogLevel logLevel, Class<?> clazz, Throwable throwable, String pattern,
			Object... arguments) {

		Logger logger = getLogger(clazz);

		if (isLogLevel(logLevel, logger))
		{

			switch (logLevel)
			{

			case DEBUG:
				debug(logger, throwable, pattern, arguments);
				break;

			case ERROR:
				error(logger, throwable, pattern, arguments);
				break;

			case INFO:
				info(logger, throwable, pattern, arguments);
				break;

			case TRACE:
				trace(logger, throwable, pattern, arguments);
				break;

			case WARN:
				warn(logger, throwable, pattern, arguments);
				break;

			default:
				info(logger, throwable, pattern, arguments);
			}

		}
	}

	public void log(LogLevel logLevel, Class<?> clazz, String message) {

		Logger logger = getLogger(clazz);

		if (isLogLevel(logLevel, logger))
		{

			switch (logLevel)
			{

			case DEBUG:
				logger.log(Priority.DEBUG, message);
				break;

			case ERROR:
				logger.log(Priority.ERROR, message);
				break;

			case INFO:
				logger.log(Priority.INFO, message);
				break;

			case TRACE:
				logger.log(Priority.INFO, message);
				break;

			case WARN:
				logger.log(Priority.WARN, message);
				break;

			default:
				logger.log(Priority.DEBUG, message);
			}

		}
	}

	private void debug(Logger logger, Throwable throwable, String pattern, Object... arguments) {

		if (throwable != null)
		{
			logger.debug(format(pattern, arguments), throwable);
		} else
		{
			logger.debug(format(pattern, arguments));
		}
	}

	private void error(Logger logger, Throwable throwable, String pattern, Object... arguments) {

		if (throwable != null)
		{
			logger.error(format(pattern, arguments), throwable);
		} else
		{
			logger.error(format(pattern, arguments));
		}
	}

	private void info(Logger logger, Throwable throwable, String pattern, Object... arguments) {

		if (throwable != null)
		{
			logger.info(format(pattern, arguments), throwable);
		} else
		{
			logger.info(format(pattern, arguments));
		}
	}

	private void trace(Logger logger, Throwable throwable, String pattern, Object... arguments) {

		if (throwable != null)
		{
			logger.trace(format(pattern, arguments), throwable);
		} else
		{
			logger.trace(format(pattern, arguments));
		}
	}

	private void warn(Logger logger, Throwable throwable, String pattern, Object... arguments) {

		if (throwable != null)
		{
			logger.warn(format(pattern, arguments), throwable);
		} else
		{
			logger.warn(format(pattern, arguments));
		}
	}

	private String format(String pattern, Object... arguments) {

		return MessageFormat.format(pattern, arguments);
	}

	private Logger getLogger(Class<?> clazz) {

		return Logger.getLogger(clazz);
	}
}
