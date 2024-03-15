package SchLibTrackingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Library {
	
	private ArrayList<LibraryItem> libraryItems = new ArrayList<>();
	private ArrayList<LibraryMember> libraryMembers = new ArrayList<>();
	private ArrayList<LibraryItem> books = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);	
	private String libraryName;
	
    public Library() {
		this("BZU");
	}
    
	public Library (String libraryName) {
		this.setLibraryName(libraryName);
	}
	
	
	public ArrayList<LibraryItem> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<LibraryItem> books) {
		this.books = books;
	}
	
	public ArrayList<LibraryItem> getLibraryItems() {
		return libraryItems;
	}
	
	public void setLibraryItems(ArrayList<LibraryItem> libraryItems) {
		this.libraryItems = libraryItems;
	}
	
	public ArrayList<LibraryMember> getLibraryMembers() {
		return libraryMembers;
	}

	public void setLibraryMembers(ArrayList<LibraryMember> libraryMembers) {
		this.libraryMembers = libraryMembers;
	}
	
	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	public String getLibraryName() {
		return libraryName;
	}
	
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	
	
	public void listItems() {       // Lists the the title of the items in the library
		System.out.println();
		for (int i = 0; i < libraryItems.size(); i++) {
			System.out.println(libraryItems.get(i).toString());
		}
	}
	
	public String listBookItems() {
		System.out.println();
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < libraryItems.size(); i++) {
			if (libraryItems.get(i).getBook() != null) {
				content.append(libraryItems.get(i).getTitle() + libraryItems.get(i).getBook().toString()).append("\n");
			}
		}
		return content.toString();
	}
	
	public ArrayList<LibraryItem> Books() {
		for (int i = 0; i < libraryItems.size(); i++) {
			if (libraryItems.get(i).getBook() != null) {
			    books.add(libraryItems.get(i));
			}
		}
		return books;
	}
	
	public void listMembers() {     // lists the name of the members in the library
        System.out.println();
		for (int i = 0; i < libraryMembers.size(); i++) {
			System.out.println(libraryMembers.get(i).getName().toString());
		}
	}
	
	public void addLibraryItem(String title, String author, String ISBN, int copies, int borrowedTimes) {     // this is the method that adds the book kind of items
		String[] nameParts = author.split(" ");
		String firstName, middleName, lastName;
		
		if (nameParts.length == 2) {
		    firstName = nameParts[0];
		    lastName = nameParts[1];
		libraryItems.add(new LibraryItem(title, new Book(new Name(firstName, lastName), ISBN), copies, borrowedTimes));   // in case the name didn't contain a middle name
		} else if (nameParts.length == 3) {
			firstName = nameParts[0];
			middleName = nameParts[1];
			lastName = nameParts[2];
		libraryItems.add(new LibraryItem(title, new Book(new Name(firstName, middleName, lastName), ISBN), copies, borrowedTimes));   // in case it did have a middle name
		} else {
			firstName = nameParts[0];
			libraryItems.add(new LibraryItem(title, new Book(new Name(firstName), ISBN), copies, borrowedTimes));
		}
	}
	
	public void addLibraryItem(String title, String composer, int track, int copies, int borrowedTimes) {   // this is for adding the cd type of items
		String[] nameParts = composer.split(" ");
		String firstName, middleName, lastName;
		
		if (nameParts.length == 2) {
		    firstName = nameParts[0];
		    lastName = nameParts[1];
		libraryItems.add(new LibraryItem(title, new CD(track, new Name(firstName, lastName)), copies, borrowedTimes));
		} else if (nameParts.length == 3) {
			firstName = nameParts[0];
			middleName = nameParts[1];
			lastName = nameParts[2];
			libraryItems.add(new LibraryItem(title, new CD(track, new Name(firstName, middleName, lastName)), copies, borrowedTimes));
		}
	}
	
	public void addLibraryMember(String name, int stNum, double avgMark, String building, String street, String city, String country, int POBox,
			                     String phone, String email, String day, String month, String year) {    // adding the student memebers
		
		String[] nameParts = name.split(" ");
		String firstName, middleName, lastName;
		
		if (nameParts.length == 2) {
			firstName = nameParts[0];
		    lastName = nameParts[1];
		    libraryMembers.add(new LibraryMember(new Name(firstName, lastName), new Student(stNum, avgMark), new Address(building, street, city, country, POBox), phone, email, new NewDate(day, month, year)));
		} else if (nameParts.length == 3) {
			firstName = nameParts[0];
			middleName = nameParts[1];
			lastName = nameParts[2];
			libraryMembers.add(new LibraryMember(new Name(firstName, middleName, lastName), new Student(stNum, avgMark), new Address(building, street, city, country, POBox), phone, email, new NewDate(day, month, year)));
		}

	}
	
	public void addLibraryMember(String name, double salary, String building, String street, String city, String country, int POBox,
                                 String phone, String email, String day, String month, String year) {     //adding the professor members
		
		String[] nameParts = name.split(" ");
		String firstName, middleName, lastName;
		
		if (nameParts.length == 2) {
			firstName = nameParts[0];
		    lastName = nameParts[1];
		    libraryMembers.add(new LibraryMember(new Name(firstName, lastName), new Professor(salary), new Address(building, street, city, country, POBox), phone, email, new NewDate(day, month, year)));
		} else if (nameParts.length == 3) {
			firstName = nameParts[0];
			middleName = nameParts[1];
			lastName = nameParts[2];
			libraryMembers.add(new LibraryMember(new Name(firstName, middleName, lastName), new Professor(salary), new Address(building, street, city, country, POBox), phone, email, new NewDate(day, month, year)));
		}
		
	}
	
	public void removeItem(String itemTitle) throws CustomIllegalArgumentException{

		for (int i = 0; i < libraryItems.size(); i++) {
			if (itemTitle.equals(libraryItems.get(i).getTitle())) {
				libraryItems.remove(i);				
				break;
			} else if (i == libraryItems.size() - 1 && !itemTitle.equals(libraryItems.get(i).getTitle())) {
				throw new CustomIllegalArgumentException();
			}			
		}
    }
	
	public void removeMember(String name) throws CustomIllegalArgumentException{
		
		for (int i = 0; i < libraryMembers.size(); i++) {
			if(name.equals(libraryMembers.get(i).getName().toString())){
				libraryMembers.remove(i);
				break;
			} else if (i == libraryMembers.size() - 1 && !name.equals(libraryMembers.get(i).getName().toString())) {
				throw new CustomIllegalArgumentException("Invalid input. Please choose one of the following names:");
			}
		}
	}
	
	public LibraryItem searchForItem(String title) throws CustomIllegalArgumentException{         // to locate the item the admin input
		
		for (int i = 0; i < libraryItems.size(); i++) {
			if (title.equals(libraryItems.get(i).getTitle())) {
				return libraryItems.get(i);
			}
		}
			throw new CustomIllegalArgumentException("No such Item. Try again:");     
	}
	
	public LibraryMember searchForMember(String name) throws IllegalArgumentException{       //to locate the member the admin input
		for (int i = 0; i < libraryMembers.size(); i++) {
			if (name.equals(libraryMembers.get(i).getName().toString())) {
				return libraryMembers.get(i);
			}
		}
		throw new CustomIllegalArgumentException("No such member. Try again: ");
	}
	
	public boolean updateItem(LibraryItem o, String property) {    // the property of the item is basically it's data fields, if the admin wants to update the track number of a cd, they simply input "track number".
		if (property.equals("Track Number")) {    
			System.out.println("New track: ");
			int track = scan.nextInt();
			o.getCd().setTrackNo(track);
			return true;
			
		} else if (property.equals("ISBN")) {
			System.out.println("New ISBN: ");
			String ISBN = scan.next();
			o.getBook().setISBN(ISBN);
			return true;
			
		} else if (property.equals("Author")) {
			System.out.println("New Author: ");
			String author = scan.nextLine();
			String[] nameParts = author.split(" ");
			String fName = nameParts[0];
			String lName = nameParts[1];
			o.getBook().getAuthor().setFirstName(fName);
			o.getBook().getAuthor().setLastName(lName);
			return true;
			
		} else if (property.equals("Composer")) {
			System.out.println("New Composer: ");
			String composer = scan.nextLine();
			String [] nameParts = composer.split(" ");
			String fName = nameParts[0];
			String lName = nameParts[1];
			o.getCd().getComposer().setFirstName(fName);
			o.getCd().getComposer().setLastName(lName);
			return true;
			
		} else if (property.equals("Title")) {
			System.out.println("New title: ");
			String title = scan.nextLine();
			o.setTitle(title);
			return true;
			
		} else if (property.equals("Number of copies")) {
			System.out.println("New value: ");
			o.setNumberOfCopies(scan.nextInt());
			return true;
		}
		return false;
	}
	
	public boolean updateMember(LibraryMember o, String property) {
		String firstName, middleName, lastName;
		
		if (property.equals("Name")) {
			System.out.println("New name: ");
			String name = scan.nextLine();
			String[] nameParts = name.split(" ");
			
			if (nameParts.length == 2) {
				firstName = nameParts[0];
			    lastName = nameParts[1];
			    o.getName().setFirstName(firstName);
			    o.getName().setLastName(lastName);
			    
			} else if (nameParts.length == 3) {
				firstName = nameParts[0];
				middleName = nameParts[1];
				lastName = nameParts[2];
				 o.getName().setFirstName(firstName);
				 o.getName().setMiddleName(middleName);
				 o.getName().setLastName(lastName);
			}
			return true;
			
		} else if (property.equals("Number")) {
			System.out.println("New number:");
			int num = scan.nextInt();
			o.getStudent().setStudentNo(num);
			return true;
			
		} else if (property.equals("Average mark")) {
			System.out.println("New avg:");
			double avgmark = scan.nextDouble();
			o.getStudent().setAvgMark(avgmark);
			return true;
			
		} else if (property.equals("Salary")) {
			System.out.println("New salary:");
			double salary = scan.nextDouble();
			o.getProfessor().setSalary(salary);
			return true;
			
		} else if (property.equals("Date of birth")) {
			System.out.println("Enter day, month and year respectively:");
			String day, month, year;
			day = scan.next();
			month = scan.next();
			year = scan.next();	
			o.getDateOfBirth().setDay(day);
			o.getDateOfBirth().setMonth(month);
			o.getDateOfBirth().setYear(year);
			return true;
		}
		return false;
	}
	
	public void libraryReport() {           //prints out all the specifications of the library items sorted according to their number of borrowings, and members.
		Collections.sort(libraryItems);
		
		System.out.println("*ITEMS:");
		for (int i = 0; i < libraryItems.size(); i++) {
			System.out.println(libraryItems.get(i).toString());
		}
		
		System.out.println("\n*MEMBERS:");
		for (int i = 0; i < libraryMembers.size(); i++) {
			System.out.println(libraryMembers.get(i).toString());
		}
	}
		
	public boolean borrowItem(LibraryMember m, LibraryItem i) {
		if (m.getStudent() != null && m.getNumberOfBorrowedItems() < 5 && i.getBorrowDate() == null) {      // if the member is a student and they borrowed less than 5 so far and the item still hasn't been borrowed.
			
			m.getListOFLibraryItems()[m.getNumberOfBorrowedItems()] = i;  // adds the item to the borrowed items list of the student
			m.setNumberOfBorrowedItems(m.getNumberOfBorrowedItems() + 1); // increments the borrowed times so that when it reaches 5 they can't borrow no more
			
			   LocalDate currentDate = LocalDate.now();          
			     int day = currentDate.getDayOfMonth();          
			     int month = currentDate.getMonthValue();        
			     int year = currentDate.getYear();               // this is the acquisition date.
			     
			   Random random = new Random();
			   LocalDate futureDate = currentDate.plusDays(random.nextInt(30));
		        int dueDay = futureDate.getDayOfMonth();
		        int dueMonth = futureDate.getMonthValue();
		        int dueYear = futureDate.getYear();              // This date is the due date. I am generating a random date in the future within the range of 30 days from today. 
		        
			i.setBorrowDate(new Borrow(new NewDate(Integer.toString(day), Integer.toString(month), Integer.toString(year)), new NewDate(Integer.toString(dueDay), Integer.toString(dueMonth), Integer.toString(dueYear)), m));
		  	return true;
		  	
		} else if (m.getProfessor() != null && i.getBorrowDate() == null) {  // if the member in question is a professor and the item still hasn't been borrowed.
			
			m.getListOFLibraryItems()[m.getNumberOfBorrowedItems()] = i;
			m.setNumberOfBorrowedItems(m.getNumberOfBorrowedItems() + 1);
			
			LocalDate currentDate = LocalDate.now();     
		     int day = currentDate.getDayOfMonth(); 
		     int month = currentDate.getMonthValue(); 
		     int year = currentDate.getYear();
		     
		   Random random = new Random();
		   LocalDate futureDate = currentDate.plusDays(random.nextInt(30));
	        int dueDay = futureDate.getDayOfMonth();
	        int dueMonth = futureDate.getMonthValue();
	        int dueYear = futureDate.getYear();
	        
		i.setBorrowDate(new Borrow(new NewDate(Integer.toString(day), Integer.toString(month), Integer.toString(year)), new NewDate(Integer.toString(dueDay), Integer.toString(dueMonth), Integer.toString(dueYear)), m));
			return true;
			
		} else if (m.getStudent() != null && m.getNumberOfBorrowedItems() == 5) {  //if indeed the student has borrowed 5 items already
			System.out.println("Students cannot borrow more than 5 items.");
		} else if (i.getBorrowDate() != null) {   // if the item i already borrowed
			System.out.println("Item already borrowed.");
		}
		return false;
			
	}
	
	
	


 
}
