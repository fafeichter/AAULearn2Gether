package at.aau.learn2gether.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ImageView profilePicImgView;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnMyGroups;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignOut;

    @FXML
    private StackPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDashboard.setStyle("-fx-background-color: #003E55");
        profilePicImgView.setClip(new Circle(35, 35, 35));
    }

    public void handleClicks(ActionEvent actionEvent) {
        btnDashboard.setStyle("-fx-background-color: #027faf");
        btnCreate.setStyle("-fx-background-color: #027faf");
        btnMyGroups.setStyle("-fx-background-color: #027faf");
        btnSettings.setStyle("-fx-background-color: #027faf");
        btnSignOut.setStyle("-fx-background-color: #027faf");

        if (actionEvent.getSource().equals(btnDashboard)) {
            btnDashboard.setStyle("-fx-background-color: #003E55");
            loadView("view/dashboard.fxml");
        } else {
            if (actionEvent.getSource().equals(btnCreate)) {
                btnCreate.setStyle("-fx-background-color: #003E55");
                loadView("view/form.fxml");
            } else {
                if (actionEvent.getSource().equals(btnSettings)) {
                    btnSettings.setStyle("-fx-background-color: #003E55");
                    loadView("view/settings.fxml");
                } else {
                    if (actionEvent.getSource().equals(btnSignOut)) {
                        btnSignOut.setStyle("-fx-background-color: #003E55");
                        loadView("view/sign_out.fxml");
                    } else {
                        if (actionEvent.getSource().equals(btnMyGroups) || actionEvent.getSource() instanceof Button) {
                            btnMyGroups.setStyle("-fx-background-color: #003E55");
                            loadView("view/my_learning_groups.fxml");
                        }
                    }
                }
            }
        }
    }

    private void loadView(String s) {
        try {
            ((StackPane) content).getChildren().clear();
            ((StackPane) content).getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource(s)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}