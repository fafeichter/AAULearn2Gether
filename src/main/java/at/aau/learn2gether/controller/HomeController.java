package at.aau.learn2gether.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCreate;

    @FXML
    public Button btnMyGroups;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignOut;

    @FXML
    private Parent overview;

    @FXML
    private ImageView profilePicImgView;

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

        if (actionEvent.getSource() == btnDashboard) {
            btnDashboard.setStyle("-fx-background-color: #003E55");
            loadView("view/overview.fxml");
        }
        if (actionEvent.getSource() == btnCreate) {
            btnCreate.setStyle("-fx-background-color: #003E55");
            loadView("view/form.fxml");
        }
        if (actionEvent.getSource() == btnMyGroups) {
            btnMyGroups.setStyle("-fx-background-color: #003E55");
            loadView("view/list.fxml");
        }
        if (actionEvent.getSource() == btnSettings) {
            btnSettings.setStyle("-fx-background-color: #003E55");
            loadView("view/settings.fxml");
        }
        if (actionEvent.getSource() == btnSignOut) {
            btnSignOut.setStyle("-fx-background-color: #003E55");
        }
    }

    private void loadView(String s) {
        try {
            ((StackPane) overview).getChildren().clear();
            ((StackPane) overview).getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource(s)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}