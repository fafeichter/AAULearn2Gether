package at.aau.learn2gether.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class UpcomingEventsController {

    @FXML
    public Label showMoreLbl;

    public void handleShowAll(MouseEvent event) {
        showMoreLbl.getScene().lookup("#btnMyGroups").fireEvent(new ActionEvent("test", showMoreLbl));
    }
}
