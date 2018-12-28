package at.aau.learn2gether.controller;

import at.aau.learn2gether.model.Course;
import at.aau.learn2gether.model.LearningGroup;
import at.aau.learn2gether.model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.StringUtils;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DashboardController {

    private static java.util.List<LearningGroup> dummyLearningGroups = new ArrayList<>();

    @FXML
    private VBox learningGroupsVBox;

    @FXML
    private TextField searchTxtFld;

    private String prevSearchTerm;

    private Node[] nodes = new Node[12];

    public VBox getLearningGroupsVBox() {
        return learningGroupsVBox;
    }

    public DashboardController setLearningGroupsVBox(VBox learningGroupsVBox) {
        this.learningGroupsVBox = learningGroupsVBox;
        return this;
    }

    public void initialize() {
        TextFields.bindAutoCompletion(searchTxtFld,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");

        if (dummyLearningGroups.isEmpty()) {
            generateDummyLearningGroups();
        }

        for (int i = 0; i < nodes.length; i++) {
            try {
                final int j = i;

                nodes[i] = loadView();

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color: #2c3034; -fx-background-radius: 1em"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color: #02060A; -fx-background-radius: 1em"));

                LearningGroup learningGroup = dummyLearningGroups.get(i);

                Label lv = (Label) nodes[i].lookup("#lv");
                lv.setText(learningGroup.getLv().toString());
                lv.setTooltip(new Tooltip(learningGroup.getLv().toString()));

                Label description = (Label) nodes[i].lookup("#description");
                description.setText(learningGroup.getDescription());
                description.setTooltip(new Tooltip(learningGroup.getDescription()));

                Label date = (Label) nodes[i].lookup("#date");
                date.setText(learningGroup.getDateFormatted());
                date.setTooltip(new Tooltip(learningGroup.getDateFormatted()));

                Label room = (Label) nodes[i].lookup("#room");
                room.setText(learningGroup.getRoom().getNumber());
                room.setTooltip(new Tooltip(learningGroup.getRoom().getNumber()));

                Button action = (Button) nodes[i].lookup("#action");
                action.setOnMouseEntered(event -> action.setStyle("-fx-border-color: #003E55; -fx-border-radius: 20; -fx-background-color: #027FAF; -fx-background-radius: 20"));
                action.setOnMouseExited(event -> action.setStyle("-fx-border-color:  #027FAF; -fx-border-radius: 20; -fx-background-color: transparent;"));
                action.setOnAction(event -> {
                    if (learningGroup.isSelected() != null && learningGroup.isSelected()) {
                        learningGroup.setSelected(false);

                        action.setText("join");

                        action.setStyle("-fx-border-color:  #003e55; -fx-border-radius: 20; -fx-background-color: #027FAF; -fx-background-radius: 20");
                        action.setOnMouseEntered(eventi -> action.setStyle("-fx-border-color: #003e55; -fx-border-radius: 20; -fx-background-color: #027FAF; -fx-background-radius: 20"));
                        action.setOnMouseExited(eventii -> action.setStyle("-fx-border-color:  #027FAF; -fx-border-radius: 20; -fx-background-color: transparent;"));
                    } else {
                        learningGroup.setSelected(true);

                        action.setText("leave");

                        action.setStyle("-fx-border-color:  #003e55; -fx-border-radius: 20; -fx-background-color: #F64747; -fx-background-radius: 20");
                        action.setOnMouseEntered(eventi -> action.setStyle("-fx-border-color: #003e55; -fx-border-radius: 20; -fx-background-color: #F64747; -fx-background-radius: 20"));
                        action.setOnMouseExited(eventii -> action.setStyle("-fx-border-color:  #F64747; -fx-border-radius: 20; -fx-background-color: transparent;"));
                    }
                });

                learningGroupsVBox.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Node loadView() throws IOException {
        return FXMLLoader.load(getClass().getClassLoader().getResource("view/learning_group.fxml"));
    }

    private void generateDummyLearningGroups() {
        dummyLearningGroups.add(getLearningGroup("621.352", "Interaktive Systeme I", "PR", "Blatt 3", "Aula"));
        dummyLearningGroups.add(getLearningGroup("621.352", "Interaktive Systeme I", "PR", "Blatt 3", "Aula"));
        dummyLearningGroups.add(getLearningGroup("621.000", "Einführung in das wissenschaftliche Arbeiten", "VC", "Übung 5.2", "E.1.42"));
        dummyLearningGroups.add(getLearningGroup("621.119", "Algorithmen und Datenstrukturen", "UE", "Übungsblatt 7", "Nautilusheim"));
        dummyLearningGroups.add(getLearningGroup("621.119", "Algorithmen und Datenstrukturen", "VO", "Lernen für VO-Prüfung", "Nautilusheim"));
        dummyLearningGroups.add(getLearningGroup("621.119", "Algorithmen und Datenstrukturen", "UE", "Lernen für Minitest #2", "Nautilusheim"));
        dummyLearningGroups.add(getLearningGroup("651.001", "Einführung in die Informatik", "UE", "Lernen für Minitest #1", "Informatik-Labor"));
        dummyLearningGroups.add(getLearningGroup("621.000", "Einführung in das wissenschaftliche Arbeiten", "VC", "Übung 5.2", "E.2.42"));
        dummyLearningGroups.add(getLearningGroup("311.763", "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen", "PR", "Besprechung der Inhalte für Klausur", "HSC"));
        dummyLearningGroups.add(getLearningGroup("311.170", "Stochastik 1", "VU", "Blatt 9", "Aula"));
        dummyLearningGroups.add(getLearningGroup("529.180", "Stochastik 2", "VU", "Allgemeines", "Uni"));
        dummyLearningGroups.add(getLearningGroup("678.912", "Datenbanken", "UE", "Aufgabe 7.4", "HSB"));

        Collections.sort(dummyLearningGroups);
    }

    private LearningGroup getLearningGroup(String lvNr, String lvTitle, String lvType, String description, String roomNr) {
        return new LearningGroup()
                .setLv(new Course()
                        .setNumber(lvNr)
                        .setTitle(lvTitle)
                        .setType(lvType))
                .setDescription(description)
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber(roomNr));

    }

    public void handleSearch(ActionEvent event) {
        if (event.getSource().equals(searchTxtFld)) {
            String searchTerm = ((TextField) event.getSource()).getText();

            if (StringUtils.isBlank(searchTerm)) {
                learningGroupsVBox.getChildren().setAll(nodes);
            } else {
                if (prevSearchTerm == null || !prevSearchTerm.equals(searchTerm)) {
                    prevSearchTerm = searchTerm;
                    learningGroupsVBox.getChildren().setAll(nodes[(int) (Math.random() * 10)]);
                }
            }
        }
    }
}