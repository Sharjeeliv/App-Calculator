import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.effect.DropShadow;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setMaxHeight(400);
        stage.setMaxWidth(300);

        stage.setMinHeight(400);
        stage.setMinWidth(300);

        Button button1 = new Button("1");
        button1.setPrefSize(50,50);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setOffsetX(5.0);
        ds.setColor(Color.GRAY);

        DropShadow ds2 = new DropShadow();
        ds2.setOffsetY(-5.0);
        ds2.setOffsetX(-5.0);
        ds2.setColor(Color.WHITE);

        ds.setInput(ds2);
        button1.setEffect(ds);


        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");

        GridPane gridpane = new GridPane();
        gridpane.add(button1, 5, 1);
        gridpane.add(button2, 1, 1);
        gridpane.add(button3, 2, 1);
        gridpane.add(button4, 0, 2);
        gridpane.add(button5, 1, 2);
        gridpane.add(button6, 2, 2);
        gridpane.add(button7, 0, 3);
        gridpane.add(button8, 1, 3);
        gridpane.add(button9, 2, 3);

        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(10));

        Scene scene = new Scene(gridpane);
        stage.setScene(scene);




        stage.setMaximized(true);
        scene.getStylesheets().add("simple.css");

        stage.setTitle("Calculator");
        stage.show();
    }
}
