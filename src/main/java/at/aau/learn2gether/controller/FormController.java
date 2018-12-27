package at.aau.learn2gether.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

public class FormController {

    @FXML
    private TextField course;

    @FXML
    private TextField room;

@FXML
private Button submit;

    public void initialize() {
        System.out.println("kebap");

        TextFields.bindAutoCompletion(course,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");
        TextFields.bindAutoCompletion(room,
                "HSA",
                "Aula",
                "E.2.42",
                "Informatik-Labor");

        submit.setOnMouseEntered(event -> submit.setStyle("-fx-border-color: #2A73FF; -fx-border-radius: 20; -fx-background-color: #2A73FF; -fx-background-radius: 20"));
        submit.setOnMouseExited(event -> submit.setStyle("-fx-border-color:  #2A73FF; -fx-border-radius: 20; -fx-background-color: transparent;"));
    }
}