package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class FaceDrawingExample extends Application{
	private Circle face, leftPupil, rightPupil;
	private Ellipse leftEye, rightEye;
	private Polygon nose;
	private Arc mouth;
	private StackPane rightEyePane, leftEyePane, fullFace;
	private HBox eyes, hMouth;
	private BorderPane eyesMouthNose;

	@Override
	public void start(Stage primaryStage) throws Exception {
		face = new Circle(200);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);
		
		nose = new Polygon();
		nose.getPoints().addAll(100.0, 50.0,   50.0, 150.0,   150.0, 150.0);
		nose.setStroke(Color.BLACK);
		nose.setFill(Color.WHITE);      
		
		leftPupil = new Circle(25);
		rightPupil = new Circle(25);
		leftPupil.setStroke(Color.BLACK);
		rightPupil.setStroke(Color.BLACK);
		
		leftEye = new Ellipse(50, 40);
		rightEye = new Ellipse(50, 40);
		leftEye.setStroke(Color.BLACK);
		rightEye.setStroke(Color.BLACK);
		leftEye.setFill(Color.WHITE);
		rightEye.setFill(Color.WHITE);
		
		leftEyePane = new StackPane();
		leftEyePane.getChildren().addAll(leftEye, leftPupil);
		
		rightEyePane = new StackPane();
		rightEyePane.getChildren().addAll(rightEye, rightPupil);
		
		mouth = new Arc(100, 100, 80, 80, 100, 100);
		mouth.setType(ArcType.OPEN);
        mouth.setFill(Color.TRANSPARENT);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(1);
        mouth.setRotate(90);
        
        hMouth = new HBox();
        hMouth.setPadding(new Insets(0, 0, 80, 220));
        hMouth.getChildren().add(mouth);
        
        eyes = new HBox(55);
        eyes.setPadding(new Insets(100, 100, 10, 170));
        eyes.getChildren().addAll(leftEyePane, rightEyePane);
		
		eyesMouthNose = new BorderPane();
		eyesMouthNose.setTop(eyes);
		eyesMouthNose.setBottom(hMouth);
		eyesMouthNose.setCenter(nose);
		BorderPane.setMargin(nose, new Insets(-20, 0, 0, 0));
		//BorderPane.setMargin(mouth, new Insets(-40, -100, 0, 0));
		
		fullFace = new StackPane();
		fullFace.getChildren().addAll(face, eyesMouthNose);
		
		Scene scene = new Scene(fullFace, 600, 450);
	    primaryStage.setTitle("Silly ass mafukin face");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
