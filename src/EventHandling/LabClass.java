package EventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LabClass extends Application{
	
	private BorderPane bpBase = new BorderPane();
	private VBox vbLeft = new VBox(10);
	private VBox vbRight = new VBox(10);
	private HBox hbBottom = new HBox(10);
	private Pane paneForText = new Pane();
	
	private MenuBar mbTop = new MenuBar();
	private Menu fileMenu = new Menu("File");
	private MenuItem mIClearText = new MenuItem("Clear Text");
	
	private RadioButton rbRed = new RadioButton ("Red");
	private RadioButton rbGreen = new RadioButton ("Green");
	private RadioButton rbBlue = new RadioButton ("Blue");
	private ToggleGroup tgGroup = new ToggleGroup();
	
	private CheckBox cbBold = new CheckBox("Bold");
	private CheckBox cbItalic = new CheckBox("Italic");
	
	private Button btLeft = new Button("Left");
	private Button btRight = new Button("Right");
    private Button btGetText = new Button("Get Text");
    
	private Text tText = new Text(50, 100, "Hello");
	
	private ComboBox<String> cboPrint = new ComboBox();
	
	private TextField tfText = new TextField();
	
	private Font boldItalicFont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
	private Font boldFont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
	private Font ItalicFont = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
	private Font nomralFont = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		fileMenu.getItems().add(mIClearText);
		mbTop.getMenus().add(fileMenu);
		bpBase.setTop(mbTop);
		
		cboPrint.getItems().addAll("Print Hi", "Print Hello");
		hbBottom.getChildren().addAll(btLeft, btRight, tfText, btGetText, cboPrint);
		hbBottom.setAlignment(Pos.CENTER);
		bpBase.setBottom(hbBottom);
		
		rbRed.setToggleGroup(tgGroup);
		rbGreen.setToggleGroup(tgGroup);
		rbBlue.setToggleGroup(tgGroup);
		
		
		vbLeft.getChildren().addAll(rbRed, rbGreen, rbBlue);
		vbLeft.setPadding(new Insets(50, 10, 10, 10));
		bpBase.setLeft(vbLeft);
		
		paneForText.getChildren().add(tText);
		paneForText.setPadding(new Insets(10, 10, 10 ,10));
		bpBase.setCenter(paneForText);
		
		vbRight.getChildren().addAll(cbBold, cbItalic);
		vbRight.setPadding(new Insets(10, 10, 10 ,10));
		bpBase.setRight(vbRight);
		
		btLeft.setOnAction(e ->{
			if (tText.getX() > 30)
			tText.setX(tText.getX() - 10);
		});
		
		btRight.setOnAction(e ->{
			if (tText.getX() < 30)
			tText.setX(tText.getX() + 10);
		});
		
		rbRed.setOnAction(e ->{
			tText.setFill(Color.RED);
		});
		
		rbGreen.setOnAction(e ->{
			tText.setFill(Color.GREEN);
		});
		
		rbBlue.setOnAction(e ->{
			tText.setFill(Color.BLUE);
		});
		
		mIClearText.setOnAction(e ->{
			tText.setText(" ");
		});
		
		EventHandler<ActionEvent> handler=e->{
			if (cbBold.isSelected() && cbItalic.isSelected())
				tText.setFont(boldItalicFont);
			else if (cbBold.isSelected())
				tText.setFont(boldFont);
			else if (cbItalic.isSelected())
				tText.setFont(ItalicFont);
			else
				tText.setFont(nomralFont);
		};
		
		cbBold.setOnAction(handler);
		cbItalic.setOnAction(handler);
		
		btGetText.setOnAction(e ->{
			tText.setText(tfText.getText());
		});
		
		cboPrint.setOnAction(e ->{
			if (cboPrint.getSelectionModel().getSelectedIndex() == 0)
				System.out.println("Hi");
			else
				System.out.println("Hello");
		});
		
		
		
		
		Scene scene = new Scene(bpBase, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Last JavaFX App");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	

}
