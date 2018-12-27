package at.aau.learn2gether.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExitController {

    @FXML
    private Button closeBtn;

    public void initialize() {
        System.out.println("el pene");
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
