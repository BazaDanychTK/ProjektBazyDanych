package controllers;

import dialogsUtil.DialogsUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TopMenuButtonsController {
    public static final String KLIENCI_FXML = "/fxml/Klienci.fxml";
    public static final String UMOWY_FXML = "/fxml/Umowy.fxml";
    public static final String USLUGI_FXML = "/fxml/Uslugi.fxml";
    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public void openUslugi(ActionEvent actionEvent) {
        mainWindowController.setCenter(USLUGI_FXML);
    }

    public void openKlienci(ActionEvent actionEvent) {
        mainWindowController.setCenter(KLIENCI_FXML);
    }

    public void openUmowy(ActionEvent actionEvent) {
        mainWindowController.setCenter(UMOWY_FXML);
    }


}
