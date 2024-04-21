package com.teacherdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        burger.setMinSize(50,50);
        btn1.setMinSize(50,50);
        btn2.setMinSize(50,50);
        btn3.setMinSize(50,50);

        Label chatLabel = new Label("CZAT");
        chatLabel.setPrefSize(2000,30);
        chatLabel.setStyle(
                "-fx-font-size: 30; " +
                "-fx-text-alignment: center;"+
                "-fx-alignment: center");
        burger.setStyle("-fx-font-size: 15");

        this.getChildren().addAll(burger, btn1, btn2, btn3, chatLabel);
        this.setStyle(
                "-fx-background-color: #6298e5; " +
                "-fx-padding: 10");

        this.setSpacing(10);
        this.setPrefSize(getMaxWidth(), 30);

    }
}
