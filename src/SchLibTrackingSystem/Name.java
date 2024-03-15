package SchLibTrackingSystem;

public class Name {
	
	private String firstName, middleName, lastName;
	
	public Name() {
		
	}
	
	public Name (String firstName, String middleName, String lastName) {
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
	}
	
	public Name (String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public Name (String firstname) {
		this.setFirstName(firstname);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public String toString() {
		if (middleName != null)
		    return firstName + " " + middleName + " " + lastName;
		else if (middleName == null && lastName == null)
			return firstName;
		else
			return firstName + " " + lastName;
			
	}

}
