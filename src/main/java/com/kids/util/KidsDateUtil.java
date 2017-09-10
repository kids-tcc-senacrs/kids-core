package com.kids.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class KidsDateUtil {

    public static LocalDate converterToLocalDate(final String date) {
	return LocalDate.parse(date);
    }





    public static LocalDateTime converterToLocalDateTime(final String date) {
	return LocalDateTime.parse(date);
    }





    public static LocalDateTime converterZoneDatetimeToLocalDateTime(final String date) {
	ZonedDateTime zdt = ZonedDateTime.parse(date);
	return zdt.toLocalDateTime();
    }





    public static String formater(final Date date, final String style) {
	if (date == null) {
	    return null;
	} else {
	    return new SimpleDateFormat(style).format(date);
	}
    }

}
