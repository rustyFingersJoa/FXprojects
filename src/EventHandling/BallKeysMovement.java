package EventHandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallKeysMovement extends Application{
	
	private Pane pane = new Pane();
	private Circle ball = new Circle(20);
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ball.setStroke(Color.BLACK);
		ball.setFill(Color.BEIGE);
		ball.setCenterX(200);
		ball.setCenterY(200);
		
		pane.getChildren().addAll(ball);
		
		ball.setOnKeyPressed(e ->{
			switch(e.getCode()) {
		    	case LEFT: ball.setCenterX(ball.getCenterX() - 10); break;
			    case RIGHT: ball.setCenterX(ball.getCenterX() + 10); break;
			    case UP: ball.setCenterY(ball.getCenterY() - 10); break;
			    case DOWN: ball.setCenterY(ball.getCenterY() + 10); break;
			    default: break;
			}
		});
		
		scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dragging a ball with arrow keys");
		primaryStage.show();
	
		ball.requestFocus();
	}

	public static void main(String[] args) {
		launch(args);

	}

	

}
