package com.cerebsoft.fw.aspects;

import java.util.Calendar;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cerebsoft.fw.logger.CommonLogger;
import com.cerebsoft.fw.logger.LogLevel;
import com.cerebsoft.fw.spring.annotation.Instrumentable;
import com.cerebsoft.fw.utils.MessageUtil;




/**
 * Associated with @Instrumentable, this class offers an AOP based approach for
 * instrumenting critical path of an execution cycle. Also logs method execution
 * time.
 */
@Component
@Aspect
public class InstrumentationAspect {

	private static String BEFORE_WITH_PARAMS_STRING = "[ entering < {0} > with params {1} ]";

	private static String AFTER_THROWING = "[ exception thrown < {0} > exception message {1} with params {2} ]";

	private static String AFTER_RETURNING = "[ Total execution time (in seconds) for method < {0} > is {1} ]";

	@Resource
	private CommonLogger logger;

	/**
	 * Profiling method for logging method params and execution time.
	 * 
	 * @param joinPoint
	 * @param instrument
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@annotation(instrument)", argNames = "joinPoint,instrument")
	public Object basicProfiling(ProceedingJoinPoint joinPoint, Instrumentable instrument) throws Throwable {

		Class<? extends Object> clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();

		logger.log(LogLevel.INFO, clazz, null, BEFORE_WITH_PARAMS_STRING, name,
				MessageUtil.constructArgumentsString(clazz, joinPoint.getArgs()));

		long initialTime = Calendar.getInstance().getTime().getTime();

		Object valueToReturn = joinPoint.proceed();

		logger.log(LogLevel.INFO, clazz, null, AFTER_RETURNING, name, ((Calendar.getInstance().getTime()
				.getTime() - initialTime) / 1000));

		return valueToReturn;
	}

}
