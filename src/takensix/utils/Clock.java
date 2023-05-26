package takensix.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The Class Constants.
 */
public abstract class Clock {
	static SimpleDateFormat dateFormatter;

	private final static String H_DELIMITER = "***";
	private final static String M_DELIMITER = "+++";
	private final static String S_DELIMITER = "---";

	static {
		dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH" + H_DELIMITER + "mm" + M_DELIMITER + "ss" + S_DELIMITER);
	}

	public static String getFormattedDateNow() {
		return arrange(dateFormatter.format(Calendar.getInstance().getTime()));
	}

	public static String formatDate(Date date) {
		return arrange(dateFormatter.format(date));
	}

	public static Date getDateNow() {
		return Calendar.getInstance().getTime();
	}

	private static String arrange(String s) {
		return s.replace(H_DELIMITER, "h").replace(M_DELIMITER, "m").replace(S_DELIMITER, "s");
	}
	
	public static long getDateDiff(Date date1, Date date2) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return TimeUnit.MILLISECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
}
