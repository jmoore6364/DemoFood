import java.util.Date;

public class FoodTruck {
	
	private String location;
	private int dayorder;
	private String applicant;
	private String start24;
	private String end24;
	
	public String getLocation() {
		return location;
	}
	
	public String getName() {
		return applicant;
	}
	
	public void setDayOrder(int value) {
		dayorder = value;
	}
	
	public void setStartTime(String value) {
		start24 = value;
	}
	
	public void setEndTime(String value) {
		end24 = value;
	}
	
	public boolean isOpen(Date date) {
		if (date.getDay() != dayorder)
			return false;
		Date start = DateUtil.toMergedDateTime(date, start24);
		Date end = DateUtil.toMergedDateTime(date, end24);
		return (date.after(start) && date.before(end));
	}
}