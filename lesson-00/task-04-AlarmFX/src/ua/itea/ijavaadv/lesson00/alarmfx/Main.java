//D
package ua.itea.ijavaadv.lesson00.alarmfx;
/**
 * Created by derevianko on 28.01.17.
 */
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Button btn = new Button();
        btn.setText("Hello World");
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
