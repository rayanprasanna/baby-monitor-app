package ammaibabai.universl.com.ammaibabai.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {


	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String dateToString(Date date) {
		return dateToString(date, DATE_FORMAT);
	}

	public static String dateToString(Date date, String format) {
		if (date != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		}
		return null;
	}

	public static Date stringToDate(String dateString) {
		return stringToDate(dateString, DATE_FORMAT);
	}

	public static Date stringToDate(String dateString, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;//new Date();
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
		}
		return date;
	}

	public static String getTimeStr() {
		Date date = new Date();
		return String.valueOf(date.getTime());
	}


	public static boolean isNullOrEmpty(String value){
		return value == null || value.isEmpty() || "null".equals(value);
	}
}
