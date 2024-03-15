package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckerBoard extends Application{

	private GridPane checkerBoard = new GridPane();	
	private Rectangle cell;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			
		for (int r = 0; r < 8; r ++) {
			for (int c = 0; c < 8; c++) {	
				
				cell = new Rectangle(50, 50);				
				cell.setFill((c + r) % 2 == 0 ? Color.WHITE : Color.BLACK);				
				checkerBoard.add(cell, c, r);
				
			}
		}
		
		Scene scene = new Scene(checkerBoard);
		primaryStage.setTitle("CheckerBoard");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public Rectangle getCell() {
		return cell;
	}

	public void setCell(Rectangle cell) {
		this.cell = cell;
	}

	public GridPane getCheckerBoard() {
		return checkerBoard;
	}
	
	public void setCheckerBoard(GridPane checkerBoard) {
		this.checkerBoard = checkerBoard;
	}

}

