package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLights extends Application {

    Circle redLight, yellowLight, greenLight;

    @Override
    public void start(Stage primaryStage) {
        // Create the circles for the traffic lights
        redLight = new Circle(20, Color.GRAY);
        yellowLight = new Circle(20, Color.GRAY);
        greenLight = new Circle(20, Color.GRAY);
        
        // Create the buttons for changing the light state
        Button redButton = new Button("Red");
        redButton.setOnAction(e -> changeLight("RED"));
        Button yellowButton = new Button("Yellow");
        yellowButton.setOnAction(e -> changeLight("YELLOW"));
        Button greenButton = new Button("Green");
        greenButton.setOnAction(e -> changeLight("GREEN"));
        
        // Arrange everything in a VBox layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(redLight, yellowLight, greenLight, redButton, yellowButton, greenButton);
        
        // Set the scene
        Scene scene = new Scene(layout, 100, 250);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeLight(String color) {
        // Reset all lights to off
        redLight.setFill(Color.GRAY);
        yellowLight.setFill(Color.GRAY);
        greenLight.setFill(Color.GRAY);
        
        // Turn on the selected light
        switch (color) {
            case "RED":
                redLight.setFill(Color.RED);
                break;
            case "YELLOW":
                yellowLight.setFill(Color.YELLOW);
                break;
            case "GREEN":
                greenLight.setFill(Color.GREEN);
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
		
	}


