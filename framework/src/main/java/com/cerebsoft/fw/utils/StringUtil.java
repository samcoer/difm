package com.cerebsoft.fw.utils;

public class StringUtil {

	/**
	 * If the given String is either null or empty, returns false, else, returns
	 * true.
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isNotEmpty(String inputString) {

		if (null == inputString || inputString.trim().length() <= 0)
		{

			return false;
		} else
		{

			return true;
		}
	}

	/**
	 * If the given LONG object is either null or empty, returns false, else,
	 * returns true.
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isNotEmpty(Long inputValue) {

		if (null == inputValue || inputValue <= 0)
		{

			return false;
		} else
		{

			return true;
		}
	}
}
