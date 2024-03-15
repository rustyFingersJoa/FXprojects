package SchLibTrackingSystem;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import application.AddNewRowDemo.Country;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

public class LibraryGUI extends Application{
	
	private String[] lines;
	private int currentIndex = 0;
	private TextArea bookText;
	private Text bookTextInfoUp = new Text();
	
	private Font font = new Font("Segoe UI", 14);	
	private Font font1 = new Font("Times New Roman", 18);
	
	private Button read = new Button("Read");
	private Button previous = new Button("Previous");
	private Button next = new Button("Next");
	private Button add = new Button("Add");
	private Button search1 = new Button("Search");
	private Button update = new Button("Update");
	private Button save = new Button("Save");
	private Button sortByBookISBN = new Button("Sort by book ISBN");

	private TextField tfTitle = new TextField();
	private TextField tfAuthor = new TextField();
	private TextField tfISBN = new TextField();
	
	private TextField tfISBNup = new TextField();
	private TextField tfNewTitle = new TextField();
	private TextField tfNewAuthor = new TextField();
	private TextField tfNewISBN = new TextField();
	
	private Label title = new Label("Title:");
	private Label author = new Label("Author:");
	private Label ISBN = new Label("ISBN:");
	
	private Label newTitle = new Label("New Title:");
	private Label newAuthor = new Label("New Author:");
	private Label newISBN = new Label("New ISBN:");
	
	private Label isbn = new Label("ISBN:");
	private Label isBN = new Label("ISBN:");
	private Label removeBookFL = new Label("Remove Book From The Library");
	
	
	private VBox rightPane = new VBox(5);
	private HBox searchToRemovePane = new HBox(5);	
	private GridPane addBookPane = new GridPane();
	private HBox searchUpdatePane = new HBox(5);
	private GridPane updateBookPane = new GridPane();
	private VBox centerPane = new VBox(10);
	private HBox previousNextPane = new HBox(20);
	private VBox topPane = new VBox(10);
	private BorderPane basePane = new BorderPane();
	private VBox bottomPane = new VBox(20);
	

	@Override
	public void start(Stage primaryStage) throws Exception {			
				
		read.setPrefSize(80, 25);	
		previous.setPrefSize(70, 10);
		next.setPrefSize(70, 10);
		
		bookText = new TextArea();
		bookText.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 25;");
		bookText.setPrefSize(900, 80);
		bookText.setEditable(false);	
		
		read.setOnAction(e ->{
			readUpdatedList();
			if (lines != null && lines.length > 0) {				
				bookText.setText(lines[0]);
				currentIndex = 0;
			}		
		});
		
		previous.setOnAction(e ->{
			readUpdatedList();
			if (currentIndex > 0) {
				currentIndex--;
				bookText.setText(lines[currentIndex]);
			}
		});
		
		next.setOnAction(e ->{
			readUpdatedList();
			if (currentIndex < lines.length - 1) {
				currentIndex++;
				bookText.setText(lines[currentIndex]);
			}
		});		
			
		title.setFont(font);		
		author.setFont(font);
		ISBN.setFont(font);
		
		newTitle.setFont(font);	
		newAuthor.setFont(font);	
		newISBN.setFont(font);
		
		addBookPane.setHgap(5);
		addBookPane.setVgap(5);
		addBookPane.add(title, 0, 0); addBookPane.add(tfTitle, 1, 0);
		addBookPane.add(author, 0, 1); addBookPane.add(tfAuthor, 1, 1);
		addBookPane.add(ISBN, 0, 2); addBookPane.add(tfISBN, 1, 2);
		
		
		
		add.setOnAction(e ->{
			LibraryDriver.getList().addLibraryItem(tfTitle.getText(), tfAuthor.getText(), tfISBN.getText(), 0, 0);
			tfTitle.clear();
			tfAuthor.clear();
			tfISBN.clear();
		});
		
		Label addBookTL = new Label("Add Book To The Library");
		//addBookTL.setFont(font);
		
		VBox leftPane = new VBox(10);
		leftPane.setAlignment(Pos.CENTER);
		
		leftPane.getChildren().addAll(addBookTL, addBookPane, add);
		
		TextField tfISBNrm = new TextField();		
		Button search = new Button("Search");
		Text bookTextInfo = new Text();
		Button remove = new Button("Remove");
		
		search.setOnAction(e ->{
			try {
			LibraryItem libItem = searchForBook(tfISBNrm.getText());
			if (tfISBNrm.getText() != null) {
			bookTextInfo.setText(libItem.getTitle() + libItem.getBook().toString());
			} else {
				bookTextInfo.setText("Please enter the ISBN of the book you're trying to search for.");
			}
			} catch (IllegalArgumentException ex) {
				bookTextInfo.setText(ex.getMessage());
			}
		});
		
		remove.setOnAction(e ->{
			removeBook(tfISBNrm.getText());
			tfISBNrm.clear();
		});
		
		
		
		isbn.setFont(font);
		
		
		isBN.setFont(font);
		
		
		searchToRemovePane.setAlignment(Pos.CENTER);
		searchToRemovePane.getChildren().addAll(isbn, tfISBNrm, search);
		
		
		//removeBookFL.setFont(font);
		
		
		VBox.setMargin(add, new Insets(0,45,0,0));
		rightPane.setAlignment(Pos.CENTER);
		rightPane.getChildren().addAll(removeBookFL, searchToRemovePane, bookTextInfo, remove);
		
		
		save.setPrefSize(80, 25);
		
		search1.setOnAction(e ->{
			try {
			LibraryItem libItem = searchForBook(tfISBNup.getText());
			if (tfISBNrm.getText() != null) {
			bookTextInfoUp.setText(libItem.getTitle() + libItem.getBook().toString());
			} else {
				bookTextInfoUp.setText("Please enter the ISBN of the book you're trying to search for.");
			}
            } catch (IllegalArgumentException ex) {
            	bookTextInfoUp.setText(ex.getMessage());
			}
		});
		
		update.setOnAction(e ->{
		     LibraryItem libItem = searchForBook(tfISBNup.getText());
		     updateBook(libItem, tfNewTitle.getText(), tfNewAuthor.getText(), tfNewISBN.getText());
		     tfNewTitle.clear();
		     tfNewAuthor.clear();
		     tfNewISBN.clear();
		});
		
		save.setOnAction(e ->{
			readUpdatedList();
			try (BufferedWriter writer = new BufferedWriter(new PrintWriter("LibraryFileOutput.txt"))){
				writer.write(LibraryDriver.getList().listBookItems());
				
			} catch (IOException ex) {
				System.out.println();
			}
		});
		
		
		TableView<LibraryItem> tableView = new TableView<>();
		
		ObservableList<LibraryItem> data = FXCollections.observableArrayList();
			   
		for (LibraryItem item : LibraryDriver.getList().Books()) {
		    data.add(item);
		}
		
	    tableView.setItems(data);

		
		TableColumn titleColumn = new TableColumn("Title");
	    titleColumn.setMinWidth(150);
	    titleColumn.setCellValueFactory(new PropertyValueFactory<LibraryItem, String>("title"));
	    
	    TableColumn<LibraryItem, String> authorColumn = new TableColumn<>("Author");
	    authorColumn.setCellValueFactory(cellData -> {
	    	
	        LibraryItem libraryItem = cellData.getValue();
	        if (libraryItem != null && libraryItem.getBook() != null) {
	            String author = libraryItem.getBook().getAuthor().toString();
	            return new SimpleStringProperty(author);
	        } else {
	            return new SimpleStringProperty("");
	        }
	    });
	    authorColumn.setMinWidth(125);

	    TableColumn<LibraryItem, String> isbnColumn = new TableColumn<>("ISBN");
	    isbnColumn.setCellValueFactory(cellData -> {
	    	
	        LibraryItem libraryItem = cellData.getValue();
	        if (libraryItem != null && libraryItem.getBook() != null) {
	            String isbn = libraryItem.getBook().getISBN();
	            return new SimpleStringProperty(isbn);
	        } else {
	            return new SimpleStringProperty("");
	        }
	    });
	    isbnColumn.setMinWidth(100);
	    

	    tableView.getColumns().addAll(titleColumn, authorColumn,isbnColumn);
	    
	    sortByBookISBN.setOnAction(e ->{
			Stage bookData = new Stage();
			bookData.setTitle("Book Data");
			bookData.setScene(new Scene(tableView, 500, 250));
			bookData.show();
		});
		
		
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().addAll(save, sortByBookISBN);
		
		searchUpdatePane.setAlignment(Pos.CENTER);
		searchUpdatePane.getChildren().addAll(isBN, tfISBNup, search1);
		
		
		updateBookPane.setAlignment(Pos.CENTER);
		updateBookPane.setHgap(5);
		updateBookPane.setVgap(5);
		updateBookPane.add(newTitle, 0, 0); updateBookPane.add(tfNewTitle, 1, 0);
		updateBookPane.add(newAuthor, 0, 1); updateBookPane.add(tfNewAuthor, 1, 1);
		updateBookPane.add(newISBN, 0, 2); updateBookPane.add(tfNewISBN, 1, 2);
		
		
		centerPane.setAlignment(Pos.CENTER);
		centerPane.getChildren().addAll(new Text("Update Book Information"), searchUpdatePane, bookTextInfoUp, updateBookPane, update);
		
		
		previousNextPane.setAlignment(Pos.CENTER);
		previousNextPane.getChildren().addAll(previous, next);
		
		
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(5, 5 ,5 ,5));
		topPane.getChildren().addAll(read, bookText, previousNextPane);
		
		
		basePane.setPadding(new Insets(5, 5, 5, 5));
		basePane.setTop(topPane);
		basePane.setLeft(leftPane);
		basePane.setRight(rightPane);
		basePane.setCenter(centerPane);
		
		//BorderPane.setAlignment(save, Pos.CENTER);
		basePane.setBottom(bottomPane);
		
		Scene scene = new Scene(basePane, 800, 500);
		primaryStage.setTitle("LibraryGUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void readUpdatedList() {
		
		try (BufferedWriter writer = new BufferedWriter(new PrintWriter("LibraryFileInput.txt"))) {
		      //writing the book items info onto the file
		    writer.write(LibraryDriver.getList().listBookItems());
	    } catch (IOException e) {
		    System.out.println(e.getMessage());
	    }
		
		try (BufferedReader reader = new BufferedReader(new FileReader("LibraryFileInput.txt"))) {				   
			   //saving the contents of the file as a string array where each element is a line from the file
         lines = reader.lines().toArray(String[]::new);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public LibraryItem searchForBook(String ISBN) throws IllegalArgumentException{
		for (int i = 0; i < LibraryDriver.getList().getLibraryItems().size(); i++) {
			if (LibraryDriver.getList().getLibraryItems().get(i).getBook() != null) {
				if (ISBN.equals( LibraryDriver.getList().getLibraryItems().get(i).getBook().getISBN())) {
					return  LibraryDriver.getList().getLibraryItems().get(i);				
				}
			}
		}
		throw new IllegalArgumentException("No such book.");
	}
	
	public void removeBook(String ISBN) {
		for (int i = 0; i < LibraryDriver.getList().getLibraryItems().size(); i++) {
			if (LibraryDriver.getList().getLibraryItems().get(i).getBook() != null) {
				if (ISBN.equals( LibraryDriver.getList().getLibraryItems().get(i).getBook().getISBN())) {
					LibraryDriver.getList().getLibraryItems().remove(i);				
				}
			}
		}
	}
	
	public void updateBook(LibraryItem o, String title, String author, String ISBN) {
		o.setTitle(title);
		
		if (author.contains(" ")) {
		String[] nameParts = author.split(" ");
		String fName = nameParts[0];
		String lName = nameParts[1];
		o.getBook().getAuthor().setFirstName(fName);
		o.getBook().getAuthor().setLastName(lName);
		} else {
			o.getBook().getAuthor().setFirstName(author);
		}
		
		o.getBook().setISBN(ISBN);
	}
	
	/*
	 * please launch the application from the LibraryDrive class. There is an option for launching the the app (case 13 in switch);
	 */
	
	public static void main(String[] args) {     
		launch(args);
	}
	
	

	public VBox getBottomPane() {
		return bottomPane;
	}

	public void setBottomPane(VBox bottomPane) {
		this.bottomPane = bottomPane;
	}
	
	public Text getBookTextInfoUp() {
		return bookTextInfoUp;
	}

	public void setBookTextInfoUp(Text bookTextInfoUp) {
		this.bookTextInfoUp = bookTextInfoUp;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getSearch1() {
		return search1;
	}

	public void setSearch1(Button search1) {
		this.search1 = search1;
	}

	public Button getUpdate() {
		return update;
	}

	public void setUpdate(Button update) {
		this.update = update;
	}

	public Button getSave() {
		return save;
	}

	public void setSave(Button save) {
		this.save = save;
	}

	public TextField getTfISBNup() {
		return tfISBNup;
	}

	public void setTfISBNup(TextField tfISBNup) {
		this.tfISBNup = tfISBNup;
	}

	public TextField getTfNewTitle() {
		return tfNewTitle;
	}

	public void setTfNewTitle(TextField tfNewTitle) {
		this.tfNewTitle = tfNewTitle;
	}

	public TextField getTfNewAuthor() {
		return tfNewAuthor;
	}

	public void setTfNewAuthor(TextField tfNewAuthor) {
		this.tfNewAuthor = tfNewAuthor;
	}

	public TextField getTfNewISBN() {
		return tfNewISBN;
	}

	public void setTfNewISBN(TextField tfNewISBN) {
		this.tfNewISBN = tfNewISBN;
	}

	public Label getIsbn() {
		return isbn;
	}

	public void setIsbn(Label isbn) {
		this.isbn = isbn;
	}

	public Label getIsBN() {
		return isBN;
	}

	public void setIsBN(Label isBN) {
		this.isBN = isBN;
	}

	public Label getRemoveBookFL() {
		return removeBookFL;
	}

	public void setRemoveBookFL(Label removeBookFL) {
		this.removeBookFL = removeBookFL;
	}

	public VBox getRightPane() {
		return rightPane;
	}

	public void setRightPane(VBox rightPane) {
		this.rightPane = rightPane;
	}

	public HBox getSearchToRemovePane() {
		return searchToRemovePane;
	}

	public void setSearchToRemovePane(HBox searchToRemovePane) {
		this.searchToRemovePane = searchToRemovePane;
	}

	public GridPane getAddBookPane() {
		return addBookPane;
	}

	public void setAddBookPane(GridPane addBookPane) {
		this.addBookPane = addBookPane;
	}

	public Label getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(Label newTitle) {
		this.newTitle = newTitle;
	}

	public Label getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(Label newAuthor) {
		this.newAuthor = newAuthor;
	}
	
	public Label getNewISBN() {
		return newISBN;
	}

	public void setNewISBN(Label newISBN) {
		this.newISBN = newISBN;
	}

	public Label getISBN() {
		return ISBN;
	}

	public void setISBN(Label iSBN) {
		ISBN = iSBN;
	}

	public Label getAuthor() {
		return author;
	}

	public void setAuthor(Label author) {
		this.author = author;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TextField getTfTitle() {
		return tfTitle;
	}

	public void setTfTitle(TextField tfTitle) {
		this.tfTitle = tfTitle;
	}

	public TextField getTfAuthor() {
		return tfAuthor;
	}

	public void setTfAuthor(TextField tfAuthor) {
		this.tfAuthor = tfAuthor;
	}
	
	public TextField getTfISBN() {
		return tfISBN;
	}

	public void setTfISBN(TextField tfISBN) {
		this.tfISBN = tfISBN;
	}

	public Button getNext() {
		return next;
	}

	public void setNext(Button next) {
		this.next = next;
	}
	
	public Button getSortByBookISBN() {
		return sortByBookISBN;
	}

	public void setSortByBookISBN(Button sortByBookISBN) {
		this.sortByBookISBN = sortByBookISBN;
	}

	public Button getPrevious() {
		return previous;
	}

	public void setPrevious(Button previous) {
		this.previous = previous;
	}

	public Button getRead() {
		return read;
	}

	public void setRead(Button read) {
		this.read = read;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public Font getFont1() {
		return font1;
	}

	public void setFont1(Font font1) {
		this.font1 = font1;
	}

	public String[] getLines() {
		return lines;
	}

	public void setLines(String[] lines) {
		this.lines = lines;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public TextArea getBookText() {
		return bookText;
	}

	public void setBookText(TextArea bookText) {
		this.bookText = bookText;
	}
	
	public HBox getSearchUpdatePane() {
		return searchUpdatePane;
	}

	public void setSearchUpdatePane(HBox searchUpdatePane) {
		this.searchUpdatePane = searchUpdatePane;
	}

	public GridPane getUpdateBookPane() {
		return updateBookPane;
	}

	public void setUpdateBookPane(GridPane updateBookPane) {
		this.updateBookPane = updateBookPane;
	}

	public VBox getCenterPane() {
		return centerPane;
	}

	public void setCenterPane(VBox centerPane) {
		this.centerPane = centerPane;
	}

	public HBox getPreviousNextPane() {
		return previousNextPane;
	}

	public void setPreviousNextPane(HBox previousNextPane) {
		this.previousNextPane = previousNextPane;
	}

	public VBox getTopPane() {
		return topPane;
	}

	public void setTopPane(VBox topPane) {
		this.topPane = topPane;
	}

	public BorderPane getBasePane() {
		return basePane;
	}

	public void setBasePane(BorderPane basePane) {
		this.basePane = basePane;
	}

	

}
