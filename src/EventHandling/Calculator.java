package EventHandling;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Calculator extends Application {
	
	private VBox vPane = new VBox(20);
	private HBox fields = new HBox(5);
	private HBox buttons = new HBox(5);
	private Text txtNum1 = new Text("Number 1: ");
	private Text txtNum2 = new Text("Number 2: ");
	private Text txtResult = new Text("Result: ");
	private TextField tfNum1 = new TextField();
	private TextField tfNum2 = new TextField();
	private TextField tfResult = new TextField();
	private Button add = new Button("Add");
	private Button subtract = new Button("Subtract");
	private Button multiply = new Button("Multiply");
	private Button divide = new Button("Divide");
	private Scene scene;
	
	public void start(Stage primaryStage) {
		
		add.setOnAction(e ->{
			double num1 = Double.parseDouble(tfNum1.getText());
			double num2 = Double.parseDouble(tfNum2.getText());
			tfResult.setText(String.valueOf(num1 + num2));
		});
		
		subtract.setOnAction(e ->{
			double num1 = Double.parseDouble(tfNum1.getText());
			double num2 = Double.parseDouble(tfNum2.getText());
			tfResult.setText(String.valueOf(num1 - num2));
		});
		
		multiply.setOnAction(e ->{
			double num1 = Double.parseDouble(tfNum1.getText());
			double num2 = Double.parseDouble(tfNum2.getText());
			tfResult.setText(String.valueOf(num1 * num2));
		});
		
		divide.setOnAction(e ->{
			double num1 = Double.parseDouble(tfNum1.getText());
			double num2 = Double.parseDouble(tfNum2.getText());
			tfResult.setText(String.valueOf(num1 / num2));
		});
		
		tfNum1.setPrefColumnCount(3);
		tfNum2.setPrefColumnCount(3);
		tfResult.setPrefColumnCount(3);
		
		fields.setAlignment(Pos.CENTER);
		fields.getChildren().addAll(txtNum1, tfNum1, txtNum2, tfNum2, txtResult, tfResult);
		
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(add, subtract, multiply, divide);
		
		vPane.setAlignment(Pos.BOTTOM_CENTER);
		vPane.setPadding(new javafx.geometry.Insets(30, 10, 0, 10));
		vPane.getChildren().addAll(fields, buttons);
		
		scene = new Scene(vPane);
		primaryStage.setTitle("calc");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}





