package application;	

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;




public class GridPaneExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		     GridPane pane = new GridPane();
		     pane.setPadding(new Insets(5));
		     pane.setHgap(5);
		     pane.setVgap(5);
		     
		     pane.add(new Label("First Name:"), 0, 0);
		     pane.add(new TextField(), 1, 0);
		     
		     pane.add(new Label("Middle Name:"), 0, 1);
		     pane.add(new TextField(), 1, 1);
		     
		     pane.add(new Label("Last Name:"), 0, 3);
		     pane.add(new TextField(), 1, 3);
		   
		     Button btSave = new Button("Save");
		     pane.add(btSave, 1, 4);
		     GridPane.setHalignment(btSave, HPos.RIGHT);
		     
		     Scene scene = new Scene(pane);
		     primaryStage.setTitle("Personal ID");
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
