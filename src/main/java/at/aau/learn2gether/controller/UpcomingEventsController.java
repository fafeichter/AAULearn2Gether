package at.aau.learn2gether.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UpcomingEventsController {

    @FXML
    public Label showMoreLbl;

    public void handleShowAll() {
        showMoreLbl.getScene().lookup("#btnMyGroups").fireEvent(new ActionEvent());
    }
}