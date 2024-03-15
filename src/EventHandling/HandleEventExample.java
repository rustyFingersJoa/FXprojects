package EventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class HandleEventExample extends Application{
	
	public void start(Stage primaryStage) {
		HBox pane = new HBox(10);		
		pane.setAlignment(Pos.CENTER);
		
		Button btOK = new Button("OK");
		OKHandlerClass handler1 = new OKHandlerClass();
		btOK.setOnAction(handler1);
		Button btCancel = new Button("Cancel");
		CancelHandlerClass handler2 = new CancelHandlerClass();
		btCancel.setOnAction(handler2);
		pane.getChildren().addAll(btOK, btCancel);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("EventHandle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}


class OKHandlerClass implements EventHandler<ActionEvent>{
	
	public void handle(ActionEvent e) {
		System.out.println("Ok button clicked.");
	}
}

class CancelHandlerClass implements EventHandler<ActionEvent>{
	
	public void handle(ActionEvent e) {
		System.out.println("Cancel button clicked.");
	}
}