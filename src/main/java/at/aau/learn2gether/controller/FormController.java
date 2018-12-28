package at.aau.learn2gether.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
import tornadofx.control.DateTimePicker;

public class FormController {

    @FXML
    public TextArea contentTxtArea;

    @FXML
    public DateTimePicker dateTimePicker;

    @FXML
    private TextField courseTxtFld;

    @FXML
    private TextField roomTxtFld;

    @FXML
    private Button submitBtn;

    public void initialize() {
        TextFields.bindAutoCompletion(courseTxtFld,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");

        TextFields.bindAutoCompletion(roomTxtFld,
                "HSA",
                "Aula",
                "E.2.42",
                "Informatik-Labor");

        submitBtn.setOnMouseEntered(event -> submitBtn.setStyle("-fx-border-color: #027FAF; -fx-border-radius: 20; -fx-background-color: #027FAF; -fx-background-radius: 20"));
        submitBtn.setOnMouseExited(event -> submitBtn.setStyle("-fx-border-color:  #027FAF; -fx-border-radius: 20; -fx-background-color: transparent;"));
    }
}