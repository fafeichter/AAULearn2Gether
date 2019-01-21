package at.aau.learn2gether.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

public class FormController {

    @FXML
    private TextField courseTxtFld;

    @FXML
    private TextField roomTxtFld;

    public void initialize() {
        TextFields.bindAutoCompletion(courseTxtFld,
                "Einführung in das wissenschaftliche Arbeiten [VC]",
                "Algorithmen und Datenstrukturen [VO]",
                "Einführung in die Informatik [UE]",
                "Wissenschaftliche Texte mit LaTeX und Versionskontrolle mit Git für TechnikerInnen [PR]");

        TextFields.bindAutoCompletion(roomTxtFld,
                "HSA",
                "Aula",
                "E.1.42",
                "E.2.42",
                "Informatik-Labor");
    }
}