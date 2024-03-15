package SchLibTrackingSystem;

public class LibraryMember extends Library{
	
	private Name name;
	private Student student;
	private Professor professor;
	private Address address;
	private String phoneNumber;
	private String emailAddress;
	private NewDate dateOfBirth;
	private LibraryItem[] listOFLibraryItems;
	private int numberOfBorrowedItems;
	
	
	public LibraryMember() {
		
	}
	
	public LibraryMember(Name name, Student student, Address address, 
			String phoneNumber, String emailAddress, NewDate dateOfBirth) {
		this.setName(name);
		this.setStudent(student);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
		this.setDateOfBirth(dateOfBirth);
		listOFLibraryItems = new LibraryItem[5];
	}
	
	public LibraryMember(Name name, Professor professor, Address address,   
			String phoneNumber, String emailAddress, NewDate dateOfBirth) {
		this.setName(name);
		this.setProfessor(professor);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
		this.setDateOfBirth(dateOfBirth);
		listOFLibraryItems = new LibraryItem[10];
	}
	
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public NewDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(NewDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LibraryItem[] getListOFLibraryItems() {
		return listOFLibraryItems;
	}

	public void setListOFLibraryItems(LibraryItem[] listOFLibraryItems) {
		this.listOFLibraryItems = listOFLibraryItems;
	}
	
	public int getNumberOfBorrowedItems() {
		return numberOfBorrowedItems;
	}

	public void setNumberOfBorrowedItems(int numberOfBorrowedItems) {
		this.numberOfBorrowedItems = numberOfBorrowedItems;
	}
	
	
	public String toString() {
		if (student != null) {   // if the member's information being called is a student
			return name + " No. " + student.getStudentNo() + ", Average mark: " + student.getAvgMark() + ", Phone No. " + phoneNumber + ", Address: " + address + ", Date of birth: " + dateOfBirth;
		} else {    // if it's a professor
			return name + ", Annual Salary: " + professor.getSalary() + ", Phone No. " + phoneNumber + ", Address: " + address + ", Date of birth: " + dateOfBirth;
		}
	}
	
	
	
}
