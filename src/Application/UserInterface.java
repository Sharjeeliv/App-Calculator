package Application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class UserInterface extends Application {
    int SIZE = 15;
    Button[] buttons = new Button[SIZE];

    //Color LIGHT = Color.color(190/(float)255, 180/(float)255, 160/(float)255);
    //Color DARK = Color.color(150/(float)255, 142/(float)255, 120/(float)255);


    public static void run() {
        launch();
    }

    public void buttonLayout(){
        String[] values = {"+", "-", "*", "/", "="};

        // Layout Numbers
        for (int i = 1; i < 10; i++) {
            Button button = new Button(String.valueOf(i));
            button.setPrefSize(50, 50);
            button.getStylesheets().add("Application/Resources/simple.css");
            //button.setOnAction(new ButtonClickHandler());
            buttons[i] = button;
        }

        // Special: 0 & =
        Button zero = new Button("0");
        zero.setPrefSize(100, 50);
        zero.getStylesheets().add("Application/Resources/simple.css");
        buttons[0] = zero;

        // Layout Operator
        for (int i = 0; i < 5; i++) {
            Button button = new Button(values[i]);
            button.setPrefSize(50, 50);
            button.getStylesheets().add("Application/Resources/pop.css");
            //button.setOnAction(new ButtonClickHandler());
            buttons[i + 9] = button;
        }
    }

    private void window(Stage stage){
        stage.setMaxHeight(380);
        stage.setMaxWidth(260);
        stage.setMinHeight(380);
        stage.setMinWidth(260);
    }

    @Override
    public void start(Stage stage) {
        window(stage);
        buttonLayout();
        /*
        for (int i = 0; i < SIZE; i++) {
            if (i < 10) {
                Button button = new Button(String.valueOf(i));
                button.setPrefSize(50, 50);
                button.getStylesheets().add("Application/Resources/simple.css");
                button.setOnAction(new ButtonClickHandler());
                buttons[i] = button;
            } else {
                Button button = new Button(values[i % 10]);
                button.setPrefSize(50, 50);
                button.getStylesheets().add("Application/Resources/pop.css");
                button.setOnAction(new ButtonClickHandler());
                buttons[i] = button;
            }
        }
        */

        GridPane gridpane = new GridPane();
        int column, row = -1;
        for (int i = 0; i < SIZE; i++) {
            column = i % 4;
            if (column == 0) row++;
            System.out.println("column: " + column + " row: " + row);
            gridpane.add(buttons[i], column, row);
        }
        gridpane.setAlignment(Pos.CENTER);
        gridpane.getStylesheets().add("Application/Resources/base.css");

        gridpane.setHgap(10);
        gridpane.setVgap(20);
        gridpane.setPadding(new Insets(15));

        Scene scene = new Scene(gridpane);
        stage.setScene(scene);


        stage.setMaximized(true);
        scene.getStylesheets().add("Application/Resources/simple.css");

        stage.setTitle("Calculator");
        stage.show();

    }
}

class ButtonClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        // For safety we check...
        if (actionEvent.getSource().getClass().getSimpleName().equals("Button")) {
            System.out.println("Event was a button");
        }
    }
}