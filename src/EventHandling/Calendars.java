package EventHandling;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calendars extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		 Calendar calendar = new GregorianCalendar();
		 int year = calendar.get(Calendar.YEAR);
		 int month = calendar.get(Calendar.MONTH);		 		 
		 
		 HBox monthAndYearPane = new HBox(5);
		 monthAndYearPane.setAlignment(Pos.CENTER);
		 
		 String monthName = getMonth(month);
		 Label monthLabel = new Label(monthName);
		 Label yearLabel = new Label(String.valueOf(year));
		 
		 monthAndYearPane.getChildren().addAll(monthLabel, yearLabel);
		 
		 HBox daysOfWeek = new HBox(5);
		 
		 daysOfWeek.getChildren().addAll(new Label("Sun"), new Label("Mon"), new Label("Tue"), new Label("Wed"), new Label("Thu"), new Label("Fri"), new Label("Sat"));
		 
		 VBox topPane = new VBox(5);
		 
		 topPane.getChildren().addAll(monthAndYearPane, daysOfWeek);
		 
		 HBox buttonPane = new HBox(5);
		 buttonPane.setAlignment(Pos.CENTER);
		 
		 Button prior = new Button("Prior");
		 Button next = new Button("Next");
		 
		 buttonPane.getChildren().addAll(prior, next);
		 
		 // getting the first day of the month
		 Calendar cal = new GregorianCalendar(year, month, 1);
		 int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		 
		 // getting the number of days in the month
		 int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		 
		 GridPane centerPane = new GridPane();
		 centerPane.setAlignment(Pos.CENTER);
		 centerPane.setHgap(10);
		 centerPane.setVgap(10);
		 
		 for (int i = 1; i < firstDay; i++) {
			 Label space = new Label("     ");
			 centerPane.add(space, (i - 1), 0);
		 }
		 
		 int row = 0;
		 int col = firstDay - 1;
		 for (int day = 1; day <= numberOfDays; day++) {
			 Label dayNum = new Label(String.valueOf(day));
			 
			 if (row == 0) {
			 centerPane.add(dayNum, col, row);
			 col++;
			 
			 } else if (row != 0){
				 centerPane.add(dayNum, col, row);
			 }
			 
			 if ((day + firstDay - 1) % 7 == 0) {
				 col = 0;
			     row++;
			 }
		 }
		 
		 BorderPane basePane = new BorderPane();
		 basePane.setTop(topPane);
		 basePane.setCenter(centerPane);
		 basePane.setBottom(buttonPane);
		 
		 Scene scene = new Scene(basePane);
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("Calendar");
		 primaryStage.show();
		 
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public String getMonth(int month) {
		String[] months = {"January", "February",  "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
		return months[month];
	}

}
