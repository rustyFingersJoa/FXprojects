package EventHandling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TawjihiEditorInterface extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		
		GridPane topPane = new GridPane();
		
		TextField tfGender = new TextField();
		tfGender.setPrefColumnCount(1);
		
		
		
		Label Math = new Label("Math");
		Label Mandatory = new Label("Mandatory");
		Label mathGrade = new Label("185/200");
		Label English = new Label("English");
        Label mand = new Label("Mandatory");
		Label engGrade = new Label("94/100");
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(0,0,0,10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(Math, 0, 0);
		gridPane.add(Mandatory, 1, 0);
		gridPane.add(mathGrade, 2, 0);
		gridPane.add(English, 0, 1);
		gridPane.add(mand, 1, 1);
		gridPane.add(engGrade, 2, 1);
		
		borderPane.setLeft(gridPane);
		
		ImageView picture = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\nizar.jpg"));
		Pane pane = new Pane();
		pane.setPadding(new Insets(5,5,5,5));
		pane.getChildren().add(picture);
		
		borderPane.setRight(pane);
		
		Label avg = new Label("Average = 93%");
		Button prior = new Button("Prior");
		Button next = new Button("Next");
		
		HBox buttonsPane = new HBox(5);
		buttonsPane.setAlignment(Pos.CENTER);
		buttonsPane.getChildren().addAll(prior, next);
		
		VBox bottomPane = new VBox(5);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.getChildren().addAll(avg, buttonsPane);
		
		borderPane.setBottom(bottomPane);
		
		Scene scene = new Scene(borderPane, 500, 400);
		primaryStage.setTitle("Tawjihi");
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}

	public static void main(String[] args) {
		launch(args);

	}

	

}
