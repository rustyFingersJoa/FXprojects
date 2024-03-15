package EventHandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallMouseMovement extends Application {

	private Circle ball = new Circle(20);
	private Pane pane = new Pane();
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ball.setStroke(Color.BLACK);
		ball.setStrokeWidth(4);
		ball.setFill(Color.WHITE);
		ball.setCenterX(200);
		ball.setCenterY(200);
		
		pane.getChildren().add(ball);
		
		ball.setOnMouseDragged(e ->{
			ball.setCenterX(e.getX());
			ball.setCenterY(e.getSceneY());
		});
		
		scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Ball Dragging");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}























































