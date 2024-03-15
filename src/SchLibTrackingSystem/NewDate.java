package SchLibTrackingSystem;

public class NewDate {
	
	private String day, month, year;
	
	public NewDate() {
		
	}
	
	public NewDate(String day, String month, String year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
