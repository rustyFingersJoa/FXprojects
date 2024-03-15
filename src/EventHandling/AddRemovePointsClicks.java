package EventHandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.ArrayList;

public class AddRemovePointsClicks extends Application{
	
	private Pane pane = new Pane();
	private ArrayList<Circle> balls = new ArrayList<>();
	private Circle ball;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pane.setOnMouseClicked(e ->{
			if (e.getButton() == MouseButton.PRIMARY) {
			ball = new Circle(10);
			ball.setStroke(Color.BLACK);
			ball.setFill(Color.SANDYBROWN);
			
			pane.getChildren().add(ball);
			
			ball.setCenterX(e.getX());
			ball.setCenterY(e.getY());
			
			balls.add(ball);
			
			} else if (e.getButton() == MouseButton.SECONDARY) {
				for (Circle ball : balls) {
					if (ball.contains(e.getX(), e.getY())) {
						pane.getChildren().remove(ball);
						balls.remove(ball);
						break;
					}
				}
			}
		});
		
        scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Keys");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}







