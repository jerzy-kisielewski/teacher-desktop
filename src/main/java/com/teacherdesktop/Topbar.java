package com.teacherdesktop;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Topbar extends HBox {

    public Topbar(){

        ImageView setImg = null;
        ImageView groupImg = null;
        ImageView txtImg = null;
        ImageView treeImg = null;

        //Wczytanie grafiki
        InputStream input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/groups.png");
        Image image = new Image(input);
        groupImg = new ImageView(image);
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/texts.png");
        Image image2 = new Image(input);
        txtImg = new ImageView(image2);
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/tree.png");
        Image image3 = new Image(input);
        treeImg = new ImageView(image3);
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/burger.png");
        Image image4 = new Image(input);
        setImg = new ImageView(image4);

        //burgerek
        Menu menuFile = new Menu("Plik");
        MenuItem fileItm1 = new MenuItem("Otwórz");
        MenuItem fileItm2 = new MenuItem("Zapisz");
        menuFile.getItems().addAll(fileItm1, fileItm2);

        MenuItem itm1 = new MenuItem("Ustawienia");
        MenuItem itm2 = new MenuItem("Drukuj");
        MenuItem itm3 = new MenuItem("Wyjdź");

        MenuButton burger = new MenuButton("", setImg);
        burger.getItems().addAll(menuFile, itm1, itm2, itm3);

        //przyciski
        Button btn1 = new Button("");
        btn1.setGraphic(groupImg);
        Button btn2 = new Button("");
        btn2.setGraphic(txtImg);
        Button btn3 = new Button("");
        btn3.setGraphic(treeImg);

        burger.setMinSize(70,50);
        btn1.setMinSize(60,50);
        btn2.setMinSize(60,50);
        btn3.setMinSize(60,50);

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
