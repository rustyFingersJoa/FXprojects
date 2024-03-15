package EventHandling;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarApplication extends Application {

    private YearMonth currentYearMonth;
    private Text monthText;

    @Override
    public void start(Stage primaryStage) {
        currentYearMonth = YearMonth.now();
        BorderPane mainPane = new BorderPane();
        GridPane calendarGrid = createCalendarGrid(currentYearMonth);
        
        Button previousButton = new Button("Prior");
        previousButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            updateCalendarGrid(calendarGrid, currentYearMonth);
            monthText.setText(currentYearMonth.format(DateTimeFormatter.ofPattern("MMMM, yyyy")));
        });
        
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            updateCalendarGrid(calendarGrid, currentYearMonth);
            monthText.setText(currentYearMonth.format(DateTimeFormatter.ofPattern("MMMM, yyyy")));
        });
        
        HBox buttonBar = new HBox(previousButton, nextButton);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setSpacing(10);
        
        monthText = new Text(currentYearMonth.format(DateTimeFormatter.ofPattern("MMMM, yyyy")));
        HBox titleBar = new HBox(monthText);
        titleBar.setAlignment(Pos.CENTER);
        
        mainPane.setTop(titleBar);
        mainPane.setCenter(calendarGrid);
        mainPane.setBottom(buttonBar);
        
        Scene scene = new Scene(mainPane, 300, 200);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private GridPane createCalendarGrid(YearMonth yearMonth) {
        GridPane grid = new GridPane();
        for (int i = 0; i < 7; i++) {
            grid.add(new Label(DayOfWeek.of(i + 1).getDisplayName(TextStyle.FULL, Locale.getDefault())), i, 0);
        }
        updateCalendarGrid(grid, yearMonth);
        return grid;
    }
    
    private void updateCalendarGrid(GridPane grid, YearMonth yearMonth) {
        grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) > 0);
        int dayOfWeekOfFirst = yearMonth.atDay(1).getDayOfWeek().getValue();
        int daysInMonth = yearMonth.lengthOfMonth();
        
        for (int i = 1, day = 1, row = 1; day <= daysInMonth; i++) {
            if (i >= dayOfWeekOfFirst) {
                grid.add(new Label(String.valueOf(day)), (i - 1) % 7, row);
                if ((i - 1) % 7 == 6) {
                    row++;
                }
                day++;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
