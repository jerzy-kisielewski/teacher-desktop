package com.teacherdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import java.io.IOException;

public class Topbar extends HBox {

    public Topbar() {
        Button burger = new Button("≡");
        Button btn1 = new Button("GROUPS");
        Button btn2 = new Button("TXT");
        Button btn3 = new Button("TREE");
        this.getChildren().addAll(burger, btn1, btn2, btn3);
        this.setStyle("-fx-background-color: #5a6f8a");
        this.setSpacing(5);
    }
}
