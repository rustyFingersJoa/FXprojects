package EventHandling;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonEnlargeShrink extends Application{
	
	private Circle circle = new Circle();
	private Button btEnlarge, btShrink;
	private BorderPane basePane = new BorderPane();
	private StackPane centerPane = new StackPane();
	private HBox bottomPane = new HBox();
	private Label lbMyName = new Label("COMP2311");
	private Font font = Font.font("Times New Roman", FontWeight.BOLD, 15);
	
	public void start(Stage primaryStage) {
		lbMyName.setFont(font);
		
		circle.setRadius(20);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.RED);
		
		btEnlarge = new Button("Enlarge");
		btShrink = new Button("Shrink");
		btEnlarge.setFont(font);
		btShrink.setFont(font);
		
		btEnlarge.setOnAction(e -> {
				circle.setRadius(circle.getRadius() + 2);							
		});
		
		btShrink.setOnAction(e -> {			
				circle.setRadius(circle.getRadius() > 2 ?
						circle.getRadius() - 2 : circle.getRadius());						
		});
		
		centerPane.getChildren().add(circle);
		
		bottomPane.setSpacing(10);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().addAll(btEnlarge, btShrink);
		
		basePane.setCenter(centerPane);
		basePane.setBottom(bottomPane);
		BorderPane.setAlignment(bottomPane, Pos.CENTER);
		
		Scene scene = new Scene(basePane, 200, 150);
		primaryStage.setTitle("BorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}






