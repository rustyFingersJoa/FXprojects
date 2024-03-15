package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class BarChart extends Application {
	
	private VBox projectPane = new VBox(10);
	private VBox quizPane = new VBox(10);
	private VBox midtermPane = new VBox(10);
	private VBox finalPane = new VBox(10);
	private HBox HPane = new HBox(10);
	private Text txtProject = new Text(); 
	private Text txtQuiz = new Text(); 
	private Text txtMidterm = new Text(); 
	private Text txtFinal = new Text(); 
	private Rectangle barProject = new Rectangle(80, 50);
	private Rectangle barQuiz = new Rectangle(80, 30);
	private Rectangle barMidterm = new Rectangle(80, 70);
	private Rectangle barFinal = new Rectangle(80, 90);
	private Scene scene;
	
	public void start (Stage primaryStage) {
		barProject.setFill(Color.RED);
		barQuiz.setFill(Color.BLUE);
		barMidterm.setFill(Color.GREEN);
		barFinal.setFill(Color.YELLOW);
		
		txtProject.setText("Project -- 20%");
		txtQuiz.setText("Quiz -- 10%");
		txtMidterm.setText("Midterm -- 20%");
		txtFinal.setText("Final -- 20%");
		
		projectPane.getChildren().addAll(txtProject, barProject);
		quizPane.getChildren().addAll(txtQuiz, barQuiz);
		midtermPane.getChildren().addAll(txtMidterm, barMidterm);
		finalPane.getChildren().addAll(txtFinal, barFinal);
		
		HPane.setAlignment(Pos.BOTTOM_CENTER);
		HPane.setPadding(new Insets(200, 10, 5, 10));
		HPane.getChildren().addAll(projectPane, quizPane, midtermPane, finalPane);
		
		scene = new Scene(HPane, 400, 150);
		primaryStage.setTitle("Display a bar chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


