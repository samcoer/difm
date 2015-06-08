package com.cerebsoft.fw.aspects;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cerebsoft.fw.logger.CommonLogger;
import com.cerebsoft.fw.spring.annotation.Loggable;
import com.cerebsoft.fw.utils.MessageUtil;



/**
 * Associated with @Loggable annotation, this class logs both entry and exit
 * points of a class method execution. It logs following events 1. Method input
 * parameters. 2. Method entry point. 3. Method exit point. 4. Any uncaught
 * exceptions that are thrown during method execution.
 */

@Component
@Aspect
public class LoggingAspect {

	private static String BEFORE_STRING = "[ entering < {0} > ]";

	private static String BEFORE_WITH_PARAMS_STRING = "[ entering < {0} > with params {1} ]";

	private static String AFTER_THROWING = "[ exception thrown < {0} > exception message {1} with params {2} ]";

	@Resource
	private CommonLogger logger;

	/**
	 * This method will be executed before calling class methods annotated with
	 * 
	 * @Loggable. Will log all arguments that were passed to the method.
	 * 
	 * @param joinPoint
	 * @param loggable
	 *            - linked to the @Loggable annotation.
	 */
	@Before(value = "@annotation(loggable)", argNames = "joinPoint, loggable")
	public void before(JoinPoint joinPoint, Loggable loggable) {

		Class<? extends Object> clazz = joinPoint.getTarget().getClass();

		String name = joinPoint.getSignature().getName();

		if (ArrayUtils.isEmpty(joinPoint.getArgs()))
		{
			logger.log(loggable.value(), clazz, null, BEFORE_STRING, name,
					MessageUtil.constructArgumentsString(clazz, joinPoint.getArgs()));
		} else
		{
			logger.log(loggable.value(), clazz, null, BEFORE_WITH_PARAMS_STRING, name,
					MessageUtil.constructArgumentsString(clazz, joinPoint.getArgs()));
		}
	}

}
