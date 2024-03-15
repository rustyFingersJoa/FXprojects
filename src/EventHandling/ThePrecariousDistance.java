package EventHandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThePrecariousDistance extends Application{
	
	private Pane pane = new Pane();
	private Circle c1 = new Circle(10);
	private Circle c2 = new Circle(10);
	private Line line = new Line();
	private Text txtDistance = new Text();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		c1.setCenterX(40);
		c1.setCenterY(40);
		
		c2.setCenterX(120);
		c2.setCenterY(150);
		
		updateLine();
		
		pane.getChildren().addAll(c1, c2, line, txtDistance);
		
		c1.setOnMouseDragged(e ->{
			 c1.setCenterX(e.getX());
	         c1.setCenterY(e.getY());
	         updateLine();
		});
		
        c2.setOnMouseDragged(e ->{
        	 c2.setCenterX(e.getX());
             c2.setCenterY(e.getY());
             updateLine();
		});
		
		Scene scene = new Scene(pane, 400, 350);
		primaryStage.setTitle("Keys");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public double calculateDistance(Circle c1, Circle c2) {
	  double dx = c1.getCenterX() - c2.getCenterX();
	  double dy = c1.getCenterY() - c2.getCenterY();
	  return Math.sqrt(dx*dx + dy*dy);
	}
	
	private void updateLine() {
        line.setStartX(c1.getCenterX());
        line.setStartY(c1.getCenterY());
        line.setEndX(c2.getCenterX());
        line.setEndY(c2.getCenterY());
        
        double distance = calculateDistance(c1, c2);
        
        txtDistance.setText(String.valueOf(distance));
        txtDistance.setX((c1.getCenterX() + c2.getCenterX()) / 2);
        txtDistance.setY((c1.getCenterY() + c2.getCenterY()) / 2 - 5);
    }
	

	public static void main(String[] args) {
		launch(args);

	}

	
}
