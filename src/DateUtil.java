import java.util.Date;

public class DateUtil {
	public static Date toMergedDateTime(Date date, String time) {
		return new Date(date.getMonth() + 1 + "/" + date.getDate() + "/" + ((int) date.getYear() + 1900) + " " + time);
	}
}
