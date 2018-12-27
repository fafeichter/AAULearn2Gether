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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;

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
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @FXML
    private ImageView profilePicture;

    private List<LearningGroup> exampleData = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnOverview.setStyle("-fx-background-color: #10165F");

        generateTestData();

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/resources/views/Item.fxml"));

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color: #0A0E3F; -fx-background-radius: 1em"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color: #02060A; -fx-background-radius: 1em"));

                LearningGroup learningGroup = exampleData.get(i);

                ((Label) nodes[i].lookup("#lv")).setText(learningGroup.getLv().toString());
                ((Label) nodes[i].lookup("#description")).setText(learningGroup.getDescription());
                ((Label) nodes[i].lookup("#date")).setText(learningGroup.getDateFormatted());
                ((Label) nodes[i].lookup("#room")).setText(learningGroup.getRoom().getNumber());

                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        profilePicture.setClip(new Circle(35, 35, 35));
    }

    private void generateTestData() {
        LearningGroup learningGroup;

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.352")
                        .setTitle("Interaktive Systeme I")
                        .setTyp("PR"))
                .setDescription("Blatt 3")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Aula"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.352")
                        .setTitle("Interaktive Systeme I")
                        .setTyp("PR"))
                .setDescription("Blatt 3")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Aula"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.000")
                        .setTitle("Einführung in das wissenschaftliche Arbeiten")
                        .setTyp("VC"))
                .setDescription("Übung 5.2")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("E.1.42"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.119")
                        .setTitle("Algorithmen und Datenstrukturen")
                        .setTyp("UE"))
                .setDescription("Übungsblatt 7")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Nautilusheim"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.119")
                        .setTitle("Algorithmen und Datenstrukturen")
                        .setTyp("VO"))
                .setDescription("Lernen für VO-Prüfung")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Nautilusheim"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.119")
                        .setTitle("Algorithmen und Datenstrukturen")
                        .setTyp("UE"))
                .setDescription("Lernen für Minitest #2")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Nautilusheim"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("651.001")
                        .setTitle("Einführung in die Informatik")
                        .setTyp("UE"))
                .setDescription("Lernen für Minitest #1")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Informatik-Labor"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("621.000")
                        .setTitle("Einführung in das wissenschaftliche Arbeiten")
                        .setTyp("VC"))
                .setDescription("Übung 5.2")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("E.2.42"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("311.763")
                        .setTitle("Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen")
                        .setTyp("PR"))
                .setDescription("Besprechung der Inhalte")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("HSC"));
        exampleData.add(learningGroup);

        learningGroup = new LearningGroup()
                .setLv(new Course()
                        .setNumber("311.170")
                        .setTitle("Stochastik 1").setTyp("VU"))
                .setDescription("Blatt 9")
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber("Aula"));
        exampleData.add(learningGroup);

        Collections.sort(exampleData);
    }

    public void handleClicks(ActionEvent actionEvent) {
        btnOverview.setStyle("-fx-background-color: #027faf");
        btnAdd.setStyle("-fx-background-color: #027faf");
        btnHistory.setStyle("-fx-background-color: #027faf");
        btnSettings.setStyle("-fx-background-color: #027faf");
        btnSignOut.setStyle("-fx-background-color: #027faf");

        if (actionEvent.getSource() == btnOverview) {
            btnOverview.setStyle("-fx-background-color: #10165F");
        }
        if (actionEvent.getSource() == btnAdd) {
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

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}