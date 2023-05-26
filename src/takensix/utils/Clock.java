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
	}//Cette méthode retourne une String représentant la date et l'heure actuelles, formatées selon un certain format. Le format semble être "dd-MM-yyyy_HHhmmmsss", où dd est le jour, MM est le mois, yyyy est l'année, HH est l'heure, mm est les minutes et ss sont les secondes.

	public static String formatDate(Date date) {
		return arrange(dateFormatter.format(date));
	}// Cette méthode prend un objet Date en argument et le transforme en une String selon le même format que la méthode getFormattedDateNow().

	public static Date getDateNow() {
		return Calendar.getInstance().getTime();
	}//getDateNow() : Cette méthode retourne un objet Date représentant la date et l'heure actuelles.

	private static String arrange(String s) {
		return s.replace(H_DELIMITER, "h").replace(M_DELIMITER, "m").replace(S_DELIMITER, "s");
	}//: Cette méthode privée prend une String en argument, qui est censée être une date formatée, et la réarrange en remplaçant certains délimiteurs par des caractères plus couramment utilisés pour représenter les heures, les minutes et les secondes (par exemple, H_DELIMITER est remplacé par 'h').
	
	public static long getDateDiff(Date date1, Date date2) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return TimeUnit.MILLISECONDS.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}// Cette méthode prend deux objets Date en arguments et retourne la différence entre ces deux dates en millisecondes.
}
