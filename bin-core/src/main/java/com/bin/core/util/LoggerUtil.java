package com.bin.core.util;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Description: 日志工具
 * Author: jiawen.huang
 * Date: 16/9/19
 * Time: 15:27
 * Version: 1.0
 * Copyright © 2016 YeePay.com All rights reserved.
 */
public class LoggerUtil {

	public static <T> String argsToString(T object) {
		if (object == null) {
			return null;
		}
		if (object.getClass().isArray()) {
			return arrayToString((Object[]) object);
		} else {
			return ToStringBuilder.reflectionToString(object);
		}

	}

	public static String arrayToString(Object[] object) {
		StringBuffer sb = new StringBuffer();
		Object[] arguments = object;
		int i = 1;
		if (null != arguments) {
			for (Object arg : arguments) {
				sb.append("[arg" + i + ":" + ToStringBuilder.reflectionToString(object) + "] ");
				i++;
			}
			return sb.toString();
		} else {
			return "";
		}
	}
}
