package EventHandling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXQuiz extends Application{
	
	private VBox basePane = new VBox(20);
	private ImageView imageView = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\landscape.jpg"));
	private HBox bottomPane = new HBox (5);
	private TextField tfNum1 = new TextField();
	private TextField tfNum2 = new TextField();	
	private TextField tfResult = new TextField();
	private Button minus = new Button("-");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		minus.setOnAction(e ->{
			int num1 =  Integer.parseInt(tfNum1.getText());
			int num2 = Integer.parseInt(tfNum2.getText());
			
			int result = num1 - num2;
			
			tfResult.setText(String.valueOf(result));
		});
		
		bottomPane.setAlignment(Pos.CENTER);
		HBox.setMargin(minus, new Insets(0, 0, 0, 10));
		bottomPane.getChildren().addAll(tfNum1, tfNum2, tfResult, minus);
		
		VBox.setMargin(imageView, new Insets(10, 10, 10, 10));
		
		basePane.getChildren().addAll(imageView, bottomPane);
		
		Scene scene = new Scene(basePane, 1030, 900);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
	
	public VBox getBasePane() {
		return basePane;
	}

	public void setBasePane(VBox basePane) {
		this.basePane = basePane;
	}
	
	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	public HBox getBottomPane() {
		return bottomPane;
	}

	public void setBottomPane(HBox bottomPane) {
		this.bottomPane = bottomPane;
	}
	
	public TextField getTfNum1() {
		return tfNum1;
	}

	public void setTfNum1(TextField tfNum1) {
		this.tfNum1 = tfNum1;
	}

	public TextField getTfNum2() {
		return tfNum2;
	}

	public void setTfNum2(TextField tfNum2) {
		this.tfNum2 = tfNum2;
	}

	public TextField getTfResult() {
		return tfResult;
	}

	public void setTfResult(TextField tfResult) {
		this.tfResult = tfResult;
	}

	public Button getMinus() {
		return minus;
	}

	public void setMinus(Button minus) {
		this.minus = minus;
	}


	

}
