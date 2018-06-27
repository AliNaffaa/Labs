package lab8.pages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by ali.naffaa on 14.06.2018.
 */
public class Dashboard extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Data table");
        Group root = new Group();
        Scene scene = new Scene(root, 700, 700, Color.WHITE);

        root.getChildren().addAll(new DevicePage(primaryStage).getContent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
