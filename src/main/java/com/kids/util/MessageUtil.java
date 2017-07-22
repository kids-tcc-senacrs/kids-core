package com.kids.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
public class MessageUtil {

    private static ResourceBundle resource = ResourceBundle.getBundle("messages");





    public static String getMessage(final String message) {
	return resource.getString(message);
    }





    public static String getMessage(final String message, final Object... params) {
	return MessageFormat.format(getMessage(message), params);
    }

}