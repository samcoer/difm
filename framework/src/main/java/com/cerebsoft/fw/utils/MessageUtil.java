package com.cerebsoft.fw.utils;

public class MessageUtil {

	public static String constructArgumentsString(Class<?> clazz, Object... arguments) {

		StringBuffer buffer = new StringBuffer();
		for (Object object : arguments)
		{

			buffer.append(object);
		}

		return buffer.toString();
	}
}
