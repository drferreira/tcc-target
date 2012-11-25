package br.org.circle.extractor.business.util;

import java.util.Date;

public class DateUtil {

	/**
	 * Returns the current date as a long. The calculation is performed from the
	 * date 1 January 1970 in milliseconds.
	 * 
	 * @return
	 */
	public static Long getCurrentDate() {
		Date date = new Date();
		return date.getTime();
	}
}
