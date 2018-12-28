package at.aau.learn2gether.controller;

import javafx.application.Platform;

public class ExitController {

    public void initialize() {
    }

    public void exit() {
        Platform.exit();
        System.exit(0);
    }
}