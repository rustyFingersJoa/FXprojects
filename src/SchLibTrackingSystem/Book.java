package SchLibTrackingSystem;

public class Book extends LibraryItem{
	
	private Name author;
	private String ISBN;
	
	public Book() {
		
	}
	
	public Book(Name author, String ISBN) {
		this.setAuthor(author);
		this.setISBN(ISBN);
	}
	
	
	public Name getAuthor() {
		return author;
	}
	public void setAuthor(Name author) {
		this.author = author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	

	public String toString() {
		return " by " + author + " - ISBN: " + ISBN;
	}
	

}
