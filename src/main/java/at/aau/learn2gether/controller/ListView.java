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

public class ListView {

    private static java.util.List<LearningGroup> exampleData = new ArrayList<>();
    @FXML
    private VBox pnItems;
    @FXML
    private TextField search;
    private String prevSearch;
    private Node[] nodes;

    public VBox getPnItems() {
        return pnItems;
    }

    public ListView setPnItems(VBox pnItems) {
        this.pnItems = pnItems;
        return this;
    }

    public void initialize() {
        // initialize controls with data currently in properties,
        // and ensure changes to controls are written back to properties:

        TextFields.bindAutoCompletion(search,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");

        System.out.println("hallo");
        if (exampleData.isEmpty()) {
            generateTestData();
        }

        nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("view/Item.fxml"));

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color: #0A0E3F; -fx-background-radius: 1em"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color: #02060A; -fx-background-radius: 1em"));

                LearningGroup learningGroup = exampleData.get(i);

                ((Label) nodes[i].lookup("#lv")).setText(learningGroup.getLv().toString());
                ((Label) nodes[i].lookup("#lv")).setTooltip(new Tooltip(learningGroup.getLv().toString()));

                ((Label) nodes[i].lookup("#description")).setText(learningGroup.getDescription());
                ((Label) nodes[i].lookup("#description")).setTooltip(new Tooltip(learningGroup.getDescription()));

                ((Label) nodes[i].lookup("#date")).setText(learningGroup.getDateFormatted());
                ((Label) nodes[i].lookup("#date")).setTooltip(new Tooltip(learningGroup.getDateFormatted()));

                ((Label) nodes[i].lookup("#room")).setText(learningGroup.getRoom().getNumber());
                ((Label) nodes[i].lookup("#room")).setTooltip(new Tooltip(learningGroup.getRoom().getNumber()));

                Button action = (Button) nodes[i].lookup("#action");

                action.setOnMouseEntered(event -> action.setStyle("-fx-border-color: #2A73FF; -fx-border-radius: 20; -fx-background-color: #2A73FF; -fx-background-radius: 20"));
                action.setOnMouseExited(event -> action.setStyle("-fx-border-color:  #2A73FF; -fx-border-radius: 20; -fx-background-color: transparent;"));
                action.setOnAction(event -> {
                    if (learningGroup.isSelected() != null && learningGroup.isSelected()) {
                        learningGroup.setSelected(false);
                        action.setText("join");
                        action.setStyle("-fx-border-color:  #2A73FF; -fx-border-radius: 20; -fx-background-color: #2A73FF; -fx-background-radius: 20");
                        action.setOnMouseEntered(eventi -> action.setStyle("-fx-border-color: #2A73FF; -fx-border-radius: 20; -fx-background-color: #2A73FF; -fx-background-radius: 20"));
                        action.setOnMouseExited(eventii -> action.setStyle("-fx-border-color:  #2A73FF; -fx-border-radius: 20; -fx-background-color: transparent;"));
                    } else {
                        learningGroup.setSelected(true);
                        action.setText("leave");
                        action.setStyle("-fx-border-color: #F64747; -fx-border-radius: 20; -fx-background-color: #F64747; -fx-background-radius: 20");
                        action.setOnMouseEntered(eventu -> action.setStyle("-fx-border-color: #F64747; -fx-border-radius: 20; -fx-background-color: #F64747; -fx-background-radius: 20"));
                        action.setOnMouseExited(eventuu -> action.setStyle("-fx-border-color:  #F64747; -fx-border-radius: 20; -fx-background-color: transparent;"));
                    }
                });

                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public void handleSearch(ActionEvent event) {
        System.out.println("aa");

        if (event.getSource().equals(search)) {


            String searchText = ((TextField) event.getSource()).getText();
            if (StringUtils.isBlank(searchText)) {
                pnItems.getChildren().setAll(nodes);
            } else {
                if (prevSearch == null || !prevSearch.equals(searchText)) {
                    prevSearch = searchText;
                    pnItems.getChildren().setAll(nodes[(int) (Math.random() * 10)]);
                }
            }
        }

    }
}
