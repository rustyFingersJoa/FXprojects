package SchLibTrackingSystem;

public class LibraryItem extends Library implements Comparable<LibraryItem>{
	
	private String title;
	private Book book;
	private CD cd;
	private int numberOfCopies;
	private int borrowedTimes;	
	private Borrow borrowDate;
	

	public LibraryItem() {
		
	}
	
	public LibraryItem(String title, Book book, int numberOfCopies, int borrowedTimes) {
		this.setTitle(title);
		this.setBook(book);
		this.setNumberOfCopies(numberOfCopies);
		this.setBorrowedTimes(borrowedTimes);
	}
	
	public LibraryItem(String title, CD cd, int numberOfCompies, int borrowedTimes) {
		this.setTitle(title);
		this.setCd(cd);
		this.setNumberOfCopies(numberOfCompies);
		this.setBorrowedTimes(borrowedTimes);
	}
	
	
	
	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	public int getBorrowedTimes() {
		return borrowedTimes;
	}

	public void setBorrowedTimes(int borrowedTimes) {
		this.borrowedTimes = borrowedTimes;
	}
	
	public Borrow getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Borrow borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	
	public String toString() {
		if (book != null && borrowDate != null) {    // if the item being called is a book and borrowed
			return "-Book: " + title + " by " + book.getAuthor() + " - ISBN: " + book.getISBN() + ", Copies: " + numberOfCopies 
			+ "\n     Borrowed by: " + borrowDate.getWho().getName().toString() + "  Acquisition date: " 
		    + borrowDate.getAcquisitionDate() + ", Due date: " + borrowDate.getDueDate();
			
		} else  if (book != null){    // if the item being called is a book unborrowed
		    return "-Book: " + title + " by " + book.getAuthor() + " - ISBN: " + book.getISBN() + ", Copies: " + numberOfCopies + ", Borrowed: " + borrowedTimes;
		    
		} else if (cd != null && borrowDate != null){    // a borrowed cd
			return "-CD: " + title + ", Track No. " + cd.getTrackNo() + " by " + cd.getComposer() + ", Copies: " + numberOfCopies
			+ "\n     Borrowed by: " + borrowDate.getWho().getName().toString() + "  Acquisition date: " 
		    + borrowDate.getAcquisitionDate() + ", Due date: " + borrowDate.getDueDate();
			
		} else {  // an unborrowed cd.
			return "-CD: " + title + ", Track No. " + cd.getTrackNo() + " by " + cd.getComposer() + ", Copies: " + numberOfCopies + ", Borrowed: " + borrowedTimes;
			
		}
	}

	@Override
	public int compareTo(LibraryItem o) {    //sorting the items according to their number of copies
//		if (Integer.parseInt(this.getBook().getISBN())  > Integer.parseInt(o.getBook().getISBN())) {
//			return 1;
//		} else if (Integer.parseInt(this.getBook().getISBN())  < Integer.parseInt(o.getBook().getISBN())) {
//			return -1;
//		} else 
//		    return 0;
//		
		if (this.getBorrowedTimes() > o.getBorrowedTimes()) {
			return 1;
		} else if (this.getBorrowedTimes() < o.getBorrowedTimes()) {
			return -1;
		} else 
		    return 0;
	}

	@Override
	public boolean equals(Object obj) {     // comparing two items of the same type based on the author if it's a book or the composer if it's a cd
		if (obj instanceof LibraryItem && ((LibraryItem)obj).getBook() != null) {
			if (this.getBook().getAuthor().toString().equals(((LibraryItem)obj).getBook().getAuthor().toString())) 
				return true;				
		} else if (obj instanceof LibraryItem && ((LibraryItem)obj).getCd() != null) {
			if (this.getCd().getComposer().toString().equals(((LibraryItem)obj).getCd().getComposer().toString())) 
				return true;						
	    }
		
		return false;
	}
	
	
	
	
	

}
