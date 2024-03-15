package EventHandling;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.Scene;

public class TextKeyPressedEvent extends Application{
	
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text text = new Text(10, 10, "A");
		text.setX(100);
		text.setY(100);
		pane.getChildren().add(text);
		
		
		text.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case UP: text.setY(text.getY() - 10); break;
			case DOWN: text.setY(text.getY() + 10); break;
			case LEFT: text.setX(text.getX() - 10); break;
			case RIGHT: text.setX(text.getX() + 10); break;
			default: if (Character.isLetterOrDigit(e.getText().charAt(0)))
				        text.setText(e.getText());
			}			
		});
		
		pane.widthProperty().addListener((obs, oldVal, newVal) ->{
			text.setX((newVal.doubleValue()) / 2);
		});
		
		pane.heightProperty().addListener((obs, oldVal, newVal) ->{
			text.setY((newVal.doubleValue())/ 2);
		});
			
		Scene scene = new Scene(pane, 400, 350);
		primaryStage.setTitle("Keys");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		text.requestFocus();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
