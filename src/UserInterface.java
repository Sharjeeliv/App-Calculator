import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.effect.DropShadow;

public class UserInterface extends Application {
    int SIZE = 12;
    Button[] buttons = new Button[SIZE];


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        try {
            stage.setMaxHeight(400);
            stage.setMaxWidth(300);

            stage.setMinHeight(400);
            stage.setMinWidth(300);


            for (int i = 0; i < SIZE; i++) {
                // Init & Size
                Button button = new Button(String.valueOf(i));
                button.setPrefSize(50,50);
                // Shadows

                DropShadow bottomShadow = new DropShadow();
                bottomShadow.setOffsetY(5.0);
                bottomShadow.setOffsetX(5.0);
                bottomShadow.setColor(Color.GRAY);

                DropShadow topShadow = new DropShadow();
                topShadow.setOffsetY(-5.0);
                topShadow.setOffsetX(-5.0);
                topShadow.setColor(Color.WHITE);

                bottomShadow.setInput(topShadow);
                button.setEffect(bottomShadow);

                buttons[i] = button;
            }

            GridPane gridpane = new GridPane();
            gridpane.add(buttons[0], 5, 1);
            gridpane.add(buttons[1], 1, 1);
            gridpane.add(buttons[2], 2, 1);
            gridpane.add(buttons[3], 0, 2);
            gridpane.add(buttons[4], 1, 2);
            gridpane.add(buttons[5], 2, 2);
            gridpane.add(buttons[6], 0, 3);
            gridpane.add(buttons[7], 1, 3);
            gridpane.add(buttons[8], 2, 3);

            gridpane.setHgap(10);
            gridpane.setVgap(10);
            gridpane.setPadding(new Insets(10));

            Scene scene = new Scene(gridpane);
            stage.setScene(scene);


            stage.setMaximized(true);
            scene.getStylesheets().add("simple.css");

            stage.setTitle("Calculator");
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
