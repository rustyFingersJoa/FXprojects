package EventHandling;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.geometry.Insets;

public class BallButtonMovement extends Application {
	
	private Pane pane = new Pane();
	private BorderPane basePane = new BorderPane();
	private HBox hPane = new HBox(5);
	private Button left = new Button("Left");
	private Button right = new Button("Right");
	private Button up = new Button("Up");
	private Button down = new Button("Down");
	private Circle ball = new Circle(10);
	private Scene scene;
	
	
	public void start(Stage primaryStage) {
		
		ball.setStroke(Color.BLACK);
		ball.setFill(Color.WHITE);
		
		pane.setPrefSize(100, 100);
		pane.getChildren().add(ball);
		
		left.setOnAction(e ->{
			if (ball.getCenterX() - 10 >= 0)
			ball.setCenterX(ball.getCenterX() - 10);
		});
		
		right.setOnAction(e ->{
			if (ball.getCenterX() + 10 <= 200)
			ball.setCenterX(ball.getCenterX() + 10);
		});
		
		up.setOnAction(e ->{
			if (ball.getCenterY() - 10 >= 0)
			ball.setCenterY(ball.getCenterY() - 10);
		});
		
		down.setOnAction(e ->{
			if (ball.getCenterY() + 10 <= 200)
			ball.setCenterY(ball.getCenterY() + 10);
		});
		
		
		
		
		pane.widthProperty().addListener((obs, oldVal, newVal) ->{
			ball.setCenterX((newVal.doubleValue() / 2));
		});
		
		pane.heightProperty().addListener((obs, oldVal, newVal) ->{
			ball.setCenterY((newVal.doubleValue() / 2));
		});
		
		hPane.getChildren().addAll(left, right, up, down);
		hPane.setAlignment(Pos.BOTTOM_CENTER);
		
		basePane.setPrefSize(300, 300);
		basePane.setCenter(pane);
		basePane.setBottom(hPane);
		BorderPane.setAlignment(pane, Pos.CENTER);
		BorderPane.setAlignment(hPane, Pos.BOTTOM_CENTER);
		
		scene = new Scene(basePane);
		primaryStage.setTitle("Ball movement");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}














