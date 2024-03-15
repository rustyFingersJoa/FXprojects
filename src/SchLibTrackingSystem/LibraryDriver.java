package SchLibTrackingSystem;

import java.util.InputMismatchException;

import javafx.application.Application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class LibraryDriver {
	
	private static Library list = new Library("BZU LIB");
	private static int count;

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int option = 0;
		

		list.addLibraryItem("Pneumonia Blues", "Samuel Lightnin' Hopkins", 6, 2, 3);
		list.addLibraryItem("The Shinning", "Stephen King", "127458", 3, 9);
		list.addLibraryItem("One Piece", "Eichiro Oda", "733635", 5, 21);
		list.addLibraryItem("Loving you", "Freddie Mercury", 8, 1, 18);
		list.addLibraryItem("Fugitive Blues", "Samuel Lightnin' Hopkins", 1, 8, 5);
		list.addLibraryItem("Human Nature", "Robert Greene", "128562", 9, 11);
		list.addLibraryItem("Night Shift", "Stephen King", "427585", 10, 20);
		list.addLibraryItem("The Pretender", "Freddie Mercury", 2, 7, 13);
		list.addLibraryItem("Slow Wind", "R. Kelly", 4, 2, 7);
		list.addLibraryItem("No Longer Human", "Osamu Dazai", "784929", 6, 2);
		list.addLibraryItem("Fugitive Blues", "Samuel Lightnin' Hopkins", 3, 9, 1);
		
		list.addLibraryMember("Yousef Dweik", 2, 88.4, "Al-dahan", "Abu Madi St.", "Jerusalem", "Palestine", 278043, "0585601555", "yousefdweik24@gmail.com", "25", "2", "2002");
		list.addLibraryMember("Mohammed Amer", 8, 67.5, "Al-Samieh", "Abu Taha St.", "Jericho", "Palestine", 218005, "0582606125", "moamr11@gmail.com", "6", "5", "1998");
		list.addLibraryMember("Haitham Natsheh", 50000.9, "Al-shams", "dahiah St.", "Jerusalem", "Palestine", 2856201, "0846328435", "haithamnatsheh@gmail.com", "14", "6", "1975");
		list.addLibraryMember("Tamer Shamasneh", 88000.5, "Al-mada", "Salam St.", "Hebron", "Palestine", 1038532, "07951010743", "tamershams@gmail.com", "29", "10", "1969");
		
		
		
		while (option != 12) {
			try {
			System.out.println("\n1. Library Report.\n"
					+          "2. Add Item.    3. Remove Item.    4.  Update an item. \n"
					+          "5. Add Member.  6. Remove Member.  7.  Update a member.\n"
					+          "8. Borrow.      9. Compare item.   10. Update File.\n"
					+          "11. Read from file.   12. Exit.    13. Launch GUI. \n");
		
		option = scan.nextInt();
		
		String item, item1, member, bookTitle, cdTitle, name, author, composer, ISBN, property, building, street, city, country, phone, email, day, month, year;
		int track, POBox, copies, itemType, borrowings;
		boolean input = true;
		
		switch(option) {
		case 1:		   
			   list.libraryReport();
			   System.out.println();
			   break;      //breaking from case 1
		case 2: 
		       System.out.println("What type of item.\n 1. Book  2. CD:");
			   while (input) { 
				   try {
					   			             
			           itemType = scan.nextInt();
			           
			   if (itemType == 1) {
				   System.out.println("Enter the title: ");
				   scan.nextLine();
				   bookTitle = scan.nextLine();
				   System.out.println("Author's name:");
				   author = scan.nextLine();
				   System.out.println("Enter the ISBN:");
				   ISBN = scan.next();
				   System.out.println("Enter number of copies: ");
				   copies = scan.nextInt();
				   System.out.println("Enter number of borrowed times: ");
				   borrowings = scan.nextInt();
				   list.addLibraryItem(bookTitle, author, ISBN, copies, 0);  //adding the item of type book
				   
			   } else if (itemType == 2) {
				   System.out.println("Enter the title: ");
				   scan.nextLine();
				   cdTitle = scan.nextLine();
				   System.out.println("Enter track number: ");
				   track = scan.nextInt();
				   System.out.println("Composer's name: ");
				   scan.nextLine();
				   composer = scan.nextLine();
				   System.out.println("Enter number of copies: ");
				   copies = scan.nextInt();
				   System.out.println("Enter number of borrowed times: ");
				   borrowings = scan.nextInt();
				   list.addLibraryItem(cdTitle, composer, track, copies, borrowings);  //adding the item of type cd
			   }  else {
				   throw new CustomIllegalArgumentException();
			   }
			               input = false;
				   } catch (InputMismatchException e) {
					    System.out.println("Invalid input. Please enter an integer:");
					    scan.nextLine();
				   } catch (CustomIllegalArgumentException e) {
					   System.out.println(e.toString());				   
				   } 
				   
				   
			   }    // end of while loop
			   
			   break;      //beaking from case 2
		case 3:
			   while (input) { 
				   try {
					    list.listItems();   // Listing Item info for the user.
					    System.out.println("\nEnter the item you wish to remove by typing it's title: ");
					    
					    if (count == 0)
					    scan.nextLine();
					    
					    item = scan.nextLine();
					    list.removeItem(item);
					    input = false;
					   
				      } catch (CustomIllegalArgumentException e) {
					   System.out.println(e.toString());	
					   count++;
					   //scan.nextLine();
				      } 				   
		    	}  //end of while loop
			   count = 0;
			   break;      //breaking from case 3
		case 4:			   
			   while (input) {
			       try {
			    	    list.listItems();
			            System.out.println("\nEnter the item you wish to update by typing it's title: ");	
			            
			            if (count == 0)
			            scan.nextLine();
			            
			            item = scan.nextLine();				   			   
			            LibraryItem libItem = list.searchForItem(item);			   
			            System.out.println("Properties:\n");
			   
			        if (libItem.getBook() == null) {          // checking to see if the item is of type book
				        System.out.println("Title.\nTrack Number\nComposer\nNumber of copies\n"); 
				   
			        } else if (libItem.getCd() == null) {     // to see if it's a CD
			         	   System.out.println("Title\nAuthor\nISBN\nNumber of copies\n");
			        }
			   
			               System.out.println("Enter the property you'd like to change: ");
			               property = scan.nextLine();
			               System.out.println(list.updateItem(libItem, property));
			   
			              input = false;
			            } catch (CustomIllegalArgumentException e) {
							   System.out.println(e.toString());	
							   count++;
					    } 
			   
		       } // end of loop
			   count = 0;
			   break;      //breaking from case 4
		case 5:
			   System.out.println("1. Student.   2. Professor: ");
			   while (input) { 
				   try {
			  
				    itemType = scan.nextInt();
				    
			   if (itemType == 1) {
				   System.out.println("Enter name:");
				   scan.nextLine();
				   name = scan.nextLine();
				   System.out.println("Enter student's number:");
				   int studentNum = scan.nextInt();
				   System.out.println("Enter average mark:");
				   double avgmark = scan.nextDouble();
				   if (!Student.isEligibleToEnroll(avgmark)) {    //if the students average is not greater than 79 the system won't register them as a member
					   System.out.println("Student is not eligible to enrol due to insufficient average mark (Less than 80).");
					   break;
				   }
				   System.out.println("Enter building name, street, city, country, POBox, phonenumber, and email respectively: ");
				   building = scan.next();
				   street = scan.next();
				   city = scan.next();
				   country = scan.next();
				   POBox = scan.nextInt();
				   phone = scan.next();
				   email = scan.next();
				   System.out.println("Enter the day, month and year of birth respectively:");
				   day = scan.next();
				   month = scan.next();
				   year = scan.next();
                   list.addLibraryMember(name, studentNum, avgmark, building, street, city, country, POBox, phone, email, day, month, year);
                   
			   } else if (itemType == 2) {    
				   System.out.println("Enter name:");
				   scan.nextLine();
				   name = scan.nextLine();
				   System.out.println("Enter professor's salary:");
				   double salary = scan.nextDouble();
				   System.out.println("Enter building name, street, city, country, POBox, phonenumber and email respectively: ");
				   building = scan.next();
				   street = scan.next();
				   city = scan.next();
				   country = scan.next();
				   POBox = scan.nextInt();
				   phone = scan.next();
				   email = scan.next();
				   System.out.println("Enter the day, month and year of birth respectively:");
				   day = scan.next();
				   month = scan.next();
				   year = scan.next();
				   list.addLibraryMember(name, salary, building, street, city, country, POBox, phone, email, day, month, year);
			   } else {
				   throw new CustomIllegalArgumentException();
			   }
		        input = false;
						   } catch (InputMismatchException e) {
							    System.out.println("Invalid input. Please enter an integer:");
							    scan.nextLine();
						   } catch (CustomIllegalArgumentException ex) {
							   System.out.println(ex.toString());					   
						   } 
			   }
			   
			   break;      //breaking from case 5
		case 6:		   
			   while (input) {
			       try {
			    	     list.listMembers();
			             System.out.println("\nEnter the name of the member you wish to remove: ");
			             
			             if (count == 0)
			             scan.nextLine();
			             
			             name = scan.nextLine();
			             list.removeMember(name);
		           	     input = false;
		           	     
				       } catch (CustomIllegalArgumentException e) {
				     	   System.out.println(e.toString());
				     	   count++;
				       } 
			} // end of while loop
			   count = 0;
			   break;      //breaking from case 6
		case 7:		       
		       while (input) {
			       try {
			    	   list.listMembers();
			            System.out.println("\nEnter the name of the member:");
			            
			            if (count == 0)
			            scan.nextLine();
			            
			            member = scan.nextLine();
			            LibraryMember libMember = list.searchForMember(member);
			            System.out.println("Properties:\n");
			   
			            if (libMember.getStudent() != null) {   //checking to see if the member is a student
			        	    System.out.println("Name\nNumber\nAverage mark\n"); 
				   
			            } else if (libMember.getProfessor() != null) {    // same but for professor
				            System.out.println("Name\nSalary\nDate of birth\n");				   
		           	    }
			   
			                System.out.println("Enter the property you'd like to change: ");
			                property = scan.nextLine();
			                System.out.println(list.updateMember(libMember, property)); 
			                input = false;
			                
		            } catch (CustomIllegalArgumentException e) {
			             System.out.println(e.toString());	
			             count++;
		            }
		   
	       } // end of loop
		       count = 0;
			   break;      //breaking from case 7
		case 8:
			   while (input) {
			   try {
			   list.listMembers();
			   System.out.println("\nEnter the name of the member that wishes to borrow:");
			   
			   if (count == 0)
			   scan.nextLine();
			   
			   member = scan.nextLine();
			   LibraryMember libraryMember = list.searchForMember(member);
			   list.listItems();
			   System.out.println("\nEnter the item's title:");
			   item = scan.nextLine();
			   LibraryItem libraryItem = list.searchForItem(item);
			   System.out.println(list.borrowItem(libraryMember, libraryItem));    
			   input = false;
			   } catch (CustomIllegalArgumentException e) {
				   System.out.println(e.toString());
				   count++;
			   }
			   }
			   count = 0;
			   break;      //breaking from case 8
		case 9:
			   while (input) {
				   try {
			            list.listItems();
			            System.out.println("\nEnter the first Item:");
			   
			            if (count == 0)
			            scan.nextLine();
			   
			            item = scan.nextLine();
			            
			            System.out.println("Enter the second Item (of the same type):");
			            item1 = scan.nextLine();
			   
			            LibraryItem libraryItem1 = list.searchForItem(item);
			            LibraryItem libraryItem2 = list.searchForItem(item1);
			   
			            if (libraryItem1.equals(libraryItem2)) {    //Based on whether the author is the same or composer
			      	     System.out.println("Equal.");
				   
			            } else if (!libraryItem1.equals(libraryItem2)) {
			        	     System.out.println("Not equal.");				   
			            }
			            
			             input = false;
			             
			            } catch (CustomIllegalArgumentException e) {
			               System.out.println(e.toString());
			         	   count++;
			            }
				   
			   }  //end of while loop
			   count = 0;
			    break;      //breaking from case 9
		case 10:		
			    /*
			     * I'm trying to transfer the data from the libraryReport(): void method to the random access file.
			     * In order to save the contents of the void method in a string, I redirected the output stream to a PrintStream variable.
			     */
		        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                PrintStream ps = new PrintStream(baos);
	                PrintStream originalOut = System.out; // Store the original standard output
					
			     try {
			    	  System.setOut(ps);     // Redirecting the output from system to ps
			          list.libraryReport();
			        
			        String data = baos.toString();
		            System.setOut(System.out); // Restore the standard output
			        
		            RandomAccessFile file = new RandomAccessFile("inout.dat", "rw");	            
		            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
		            file.seek(0);
		            file.write(bytes);
		            
		            file.close();
		            
		        } catch (IOException e) {
		            System.out.println(e.getMessage());		            
		        } finally {
					System.setOut(originalOut); // Restore the standard output
		        }
			    		
			    break;
		case 11:
			    try {
		            RandomAccessFile file = new RandomAccessFile("inout.dat", "r");
		            long length = file.length();
		            byte[] bytes = new byte[(int) length];
		            file.readFully(bytes);
		            String data = new String(bytes, StandardCharsets.UTF_8);
		            file.close();

		            System.out.println(data); // Print the contents of the file
		          } catch (IOException e) {
		              System.out.println(e.getMessage());
		          }
			  
			    break;      //breaking from case 11.
		case 12:
			    option = 12;
		        System.out.println("You have exited the system.");		    
			    break;      //breaking from case 12.
		case 13:
			    try {
			    	
			          Application.launch(LibraryGUI.class, args);
			                    //this exception is called when the application is launched more than once
			    } catch (java.lang.IllegalStateException e) {
			    	System.out.println(e.getMessage());
			    }
			    break;
		default:
			    System.out.println("Invalid input.");
		        break;
		        
		   } //end of switch
		
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input. Please enter a number from 1-12.");
			scan.nextLine();
		}
		
		 }   // end of while
		
		
		
		scan.close();
		}
	
	public static Library getList() {
		return list;
	}

	public static void setList(Library list) {
		LibraryDriver.list = list;
	}
	
		
	}
	
