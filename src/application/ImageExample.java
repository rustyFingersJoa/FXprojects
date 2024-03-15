package application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageExample extends Application{
	StackPane pane = new StackPane();
	Image image;
	ImageView hunterxhunter;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		image = new Image("C:\\Users\\Admin\\Downloads\\hunterxhunter.jpg");
		hunterxhunter = new ImageView(image);
		
		hunterxhunter.fitWidthProperty().bind(pane.widthProperty());
		hunterxhunter.fitHeightProperty().bind(pane.heightProperty());
		
		pane.getChildren().add(hunterxhunter);
		Scene scene = new Scene(pane, 450, 600);
        primaryStage.setTitle("HXH");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}


