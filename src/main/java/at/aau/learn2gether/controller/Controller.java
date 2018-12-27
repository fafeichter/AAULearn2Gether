package at.aau.learn2gether.controller;

import at.aau.learn2gether.model.Course;
import at.aau.learn2gether.model.LearningGroup;
import at.aau.learn2gether.model.Room;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private Parent embeddedListView; //embeddedElement

    @FXML
    private ListView embeddedListViewController;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignOut;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlMenus;



    @FXML
    private ImageView profilePicture;

    private java.util.List<LearningGroup> exampleData = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnOverview.setStyle("-fx-background-color: #10165F");

        profilePicture.setClip(new Circle(35, 35, 35));
    }

    public void handleClicks(ActionEvent actionEvent) {
        btnOverview.setStyle("-fx-background-color: #027faf");
        btnAdd.setStyle("-fx-background-color: #027faf");
        btnHistory.setStyle("-fx-background-color: #027faf");
        btnSettings.setStyle("-fx-background-color: #027faf");
        btnSignOut.setStyle("-fx-background-color: #027faf");

        if (actionEvent.getSource() == btnOverview) {
            try {
                ((StackPane) embeddedListView).getChildren().clear();
                ((StackPane) embeddedListView).getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource("view/List.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            btnOverview.setStyle("-fx-background-color: #10165F");
        }
        if (actionEvent.getSource() == btnAdd) {
            try {
                ((StackPane) embeddedListView).getChildren().clear();
                ((StackPane) embeddedListView).getChildren().add(FXMLLoader.load(getClass().getClassLoader().getResource("view/Form.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            btnAdd.setStyle("-fx-background-color: #10165F");

        }
        if (actionEvent.getSource() == btnHistory) {
            btnHistory.setStyle("-fx-background-color: #10165F");
        }
        if (actionEvent.getSource() == btnSettings) {
            btnSettings.setStyle("-fx-background-color: #10165F");
        }
        if (actionEvent.getSource() == btnSignOut) {
            btnSignOut.setStyle("-fx-background-color: #10165F");
        }
    }
}