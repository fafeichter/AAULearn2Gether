package at.aau.learn2gether.controller;

import at.aau.learn2gether.model.Course;
import at.aau.learn2gether.model.LearningGroup;
import at.aau.learn2gether.model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DashboardController {

    @FXML
    public CheckBox filterChckBx;

    @FXML
    private VBox learningGroupsVBox;

    @FXML
    private ScrollPane learningGroupsScllPne;

    @FXML
    private TextField searchTxtFld;

    private java.util.List<LearningGroup> data = new ArrayList<>();

    private Node[] nodes = new Node[12];

    private String prevSearchTerm;

    public void initialize() {
        learningGroupsScllPne.setFitToWidth(true);
        learningGroupsScllPne.setFitToHeight(true);

        TextFields.bindAutoCompletion(searchTxtFld,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");

        if (data.isEmpty()) {
            generateDummyLearningGroups();
        }
        for (int i = 0; i < nodes.length; i++) {
            Node node = createNode(data.get(i));

            nodes[i] = node;
            learningGroupsVBox.getChildren().add(node);
        }
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

    public void handleFilter(ActionEvent event) {
        learningGroupsVBox.getChildren().clear();

        if (((CheckBox) event.getSource()).isSelected()) {
            List<LearningGroup> filteredList = data.stream()
                    .filter(learningGroup -> BooleanUtils.isTrue(learningGroup.isSelected()))
                    .collect(Collectors.toList());

            for (LearningGroup element : filteredList) {
                learningGroupsVBox.getChildren().add(createNode(element));
            }
        } else {
            for (int i = 0; i < nodes.length; i++) {
                learningGroupsVBox.getChildren().add(createNode(data.get(i)));
            }
        }
    }

    private Node createNode(LearningGroup learningGroup) {
        try {
            Node node = loadView();

            node.setOnMouseEntered(event -> node.setStyle("-fx-background-color: #2c3034; -fx-background-radius: 1em"));
            node.setOnMouseExited(event -> node.setStyle("-fx-background-color: #02060A; -fx-background-radius: 1em"));

            Label lv = (Label) node.lookup("#lv");
            lv.setText(learningGroup.getLv().toString());
            lv.setTooltip(new Tooltip(learningGroup.getLv().toString()));

            Label content = (Label) node.lookup("#content");
            content.setText(learningGroup.getContent());
            content.setTooltip(new Tooltip(learningGroup.getContent()));

            Label date = (Label) node.lookup("#date");
            date.setText(learningGroup.getDateFormatted());
            date.setTooltip(new Tooltip(learningGroup.getDateFormatted()));

            Label room = (Label) node.lookup("#room");
            room.setText(learningGroup.getRoom().getNumber());
            room.setTooltip(new Tooltip(learningGroup.getRoom().getNumber()));

            Button action = (Button) node.lookup("#action");
            if (BooleanUtils.isTrue(learningGroup.isSelected())) {
                setButtonStyleToJoined(action);
            } else {
                setButtonStyleToLeave(action);
            }

            action.setOnAction(event -> {
                if (BooleanUtils.isTrue(learningGroup.isSelected())) {
                    learningGroup.setSelected(false);

                    setButtonStyleToLeave(action);

                    if (filterChckBx.isSelected()) {
                        learningGroupsVBox.getChildren().remove(((Button) event.getSource()).getParent());
                    }
                } else {
                    learningGroup.setSelected(true);
                    setButtonStyleToJoined(action);
                }
            });

            return node;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void generateDummyLearningGroups() {
        data.add(getLearningGroupByData("621.352", "Interaktive Systeme I", "PR", "Blatt 3", "Aula"));
        data.add(getLearningGroupByData("621.352", "Interaktive Systeme I", "PR", "Blatt 3", "Aula"));
        data.add(getLearningGroupByData("621.000", "Einführung in das wissenschaftliche Arbeiten", "VC", "Übung 5.2", "E.1.42"));
        data.add(getLearningGroupByData("621.119", "Algorithmen und Datenstrukturen", "UE", "Übungsblatt 7", "Nautilusheim"));
        data.add(getLearningGroupByData("621.119", "Algorithmen und Datenstrukturen", "VO", "Lernen für VO-Prüfung", "Nautilusheim"));
        data.add(getLearningGroupByData("621.119", "Algorithmen und Datenstrukturen", "UE", "Lernen für Minitest #2", "Nautilusheim"));
        data.add(getLearningGroupByData("651.001", "Einführung in die Informatik", "UE", "Lernen für Minitest #1", "Informatik-Labor"));
        data.add(getLearningGroupByData("621.000", "Einführung in das wissenschaftliche Arbeiten", "VC", "Übung 5.2", "E.2.42"));
        data.add(getLearningGroupByData("311.763", "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen", "PR", "Besprechung der Inhalte für Klausur", "HSC"));
        data.add(getLearningGroupByData("311.170", "Stochastik 1", "VU", "Blatt 9", "Aula"));
        data.add(getLearningGroupByData("529.180", "Stochastik 2", "VU", "Allgemeines", "Uni"));
        data.add(getLearningGroupByData("678.912", "Datenbanken", "UE", "Aufgabe 7.4", "HSB"));

        Collections.sort(data);
    }

    private LearningGroup getLearningGroupByData(String lvNr, String lvTitle, String lvType, String content, String roomNr) {
        return new LearningGroup()
                .setLv(new Course()
                        .setNumber(lvNr)
                        .setTitle(lvTitle)
                        .setType(lvType))
                .setContent(content)
                .setDate(new Date((long) (new Date().getTime() - Math.random() * (0 - 60) * 60 * 60 * 24 * 1000)))
                .setRoom(new Room().setNumber(roomNr))
                .setSelected(false);
    }

    private Node loadView() throws IOException {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/learning_group.fxml")));
    }

    private void setButtonStyleToLeave(Button action) {
        action.setText("join");

        action.setStyle("-fx-border-color: #027FAF; -fx-border-radius: 20; -fx-background-color: transparent");
        action.setOnMouseEntered(eventi -> action.setStyle("-fx-border-color: #003e55; -fx-border-radius: 20; -fx-background-color: #027FAF; -fx-background-radius: 20"));
        action.setOnMouseExited(eventi -> action.setStyle("-fx-border-color:  #027FAF; -fx-border-radius: 20; -fx-background-color: transparent;"));
    }

    private void setButtonStyleToJoined(Button action) {
        action.setText("leave");

        action.setStyle("-fx-border-color: #F64747; -fx-border-radius: 20; -fx-background-color: transparent");
        action.setOnMouseEntered(eventi -> action.setStyle("-fx-border-color: #003e55; -fx-border-radius: 20; -fx-background-color: #F64747; -fx-background-radius: 20"));
        action.setOnMouseExited(eventi -> action.setStyle("-fx-border-color:  #F64747; -fx-border-radius: 20; -fx-background-color: transparent;"));
    }
}