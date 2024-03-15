package SchLibTrackingSystem;

public class Professor extends LibraryMember{
	
	private double Salary;
	
	public Professor() {
		
	}
	
	public Professor(double Salary) {
		this.setSalary(Salary);
	}
	

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
	
	public String toString() {
		return "Salary: " + Salary;
	}

}
