package SchLibTrackingSystem;

public class Student extends LibraryMember{
	
	private int studentNo;
	private double avgMark;

	public Student() {
		
	}
	
	public Student(int studentNo, double avgMark) {
		this.setStudentNo(studentNo);
		this.setAvgMark(avgMark);
	}
	
	
	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
	
	public static boolean isEligibleToEnroll(double avgMark) {
		if (avgMark >= 80)
			return true;
		else
			return false;
	}
	
	
	//public void isEligibleToEnroll();
	
	public String toString() {
		return "Student No. " + studentNo + " Average mark of: " + avgMark;
	}

}
