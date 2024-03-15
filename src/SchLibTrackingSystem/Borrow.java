package SchLibTrackingSystem;

public class Borrow {
	
	private NewDate acquisitionDate;
	private NewDate dueDate;
	private LibraryMember who;
	
	
	public Borrow() {
		
	}
	
	public Borrow(NewDate acquisitionDate, NewDate dueDate, LibraryMember who) {
		this.setAcquisitionDate(acquisitionDate);
		this.setDueDate(dueDate);
		this.setWho(who);
	}
	
	
	public NewDate getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(NewDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public NewDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(NewDate dueDate) {
		this.dueDate = dueDate;
	}

	public LibraryMember getWho() {
		return who;
	}

	public void setWho(LibraryMember who) {
		this.who = who;
	}
	
	
	public String toString() {
		return "Acquisition Date: " + acquisitionDate + ",  Due Date: " + dueDate;
	}

}
