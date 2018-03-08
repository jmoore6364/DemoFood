
public class StringUtil {
	public static String padRightWithSpaces(String s, int padding) {
		return String.format("%1$-" + padding + "s", s);
	}
	
	public static String maxLength(String s, int length) {
		if (s.length() > length)
			return (s.substring(0, length));
		return s;
					
	}
}
