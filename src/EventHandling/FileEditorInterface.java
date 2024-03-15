package EventHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FileEditorInterface extends Application{
	
	private VBox vPane = new VBox(5);
	private HBox hPane = new HBox(10);
	private Text txtFileName = new Text("File Name: ");
	private Text txtContent = new Text();
	private TextField tfFileName = new TextField();
	private Button load = new Button("Load");
	private Button save = new Button("Save");
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		tfFileName.setPrefColumnCount(5);
		
		load.setOnAction(e ->{
			try (BufferedReader reader = new BufferedReader(new FileReader(tfFileName.getText())))
			{
			    StringBuilder stringBuilder = new StringBuilder();
			    String line;
			    while((line = reader.readLine()) != null)
			    	stringBuilder.append(line).append("\n");
			    
			    String content = stringBuilder.toString();
			    txtContent.setText(content);
				
			} catch (java.io.FileNotFoundException ex) {
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		hPane.setAlignment(Pos.CENTER);
		hPane.getChildren().addAll(txtFileName, tfFileName, load);
		
		vPane.setAlignment(Pos.CENTER);
		vPane.setSpacing(40);
		vPane.setPadding(new javafx.geometry.Insets(5, 10, 10,5));
		vPane.getChildren().addAll(hPane, txtContent, save);
		
		scene = new Scene(vPane, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("File Editor Interface");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}























