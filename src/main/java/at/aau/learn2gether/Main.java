package at.aau.learn2gether;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double x, y;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/app.fxml"));

        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(String.valueOf(getClass().getClassLoader().getResource("images/aau_logo.png"))));

        root.setOnMousePressed(event -> {
            this.x = event.getSceneX();
            this.y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

        });

        stage.show();
    }
}