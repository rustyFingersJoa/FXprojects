package EventHandling;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ThreeXThreeMatrixClicks extends Application{
	
	private GridPane grid = new GridPane();
	private StackPane stack;
	private Rectangle cell;
    private Random rand = new Random();
    private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++) {
				
				cell = new Rectangle(90, 90);
				cell.setStroke(Color.RED);
				cell.setFill(Color.WHITE);
				cell.setStrokeWidth(4);
				
				Label label = new Label();
				label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
				
				stack = new StackPane(cell, label);
				stack.setOnMouseClicked(e -> label.setText(String.valueOf(rand.nextInt(2))));
				
				grid.add(stack, c, r);
			}
		
		scene = new Scene(grid);
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}





