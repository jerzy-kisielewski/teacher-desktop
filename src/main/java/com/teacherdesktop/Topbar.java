package com.teacherdesktop;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.InputStream;
import static javafx.application.Platform.exit;

public class Topbar extends HBox {

    public Topbar() {
        ImageView setImg = null;
        ImageView groupImg = null;
        ImageView txtImg = null;
        ImageView treeImg = null;
        ImageView icon1Img = null;
        ImageView icon2Img = null;
        ImageView icon3Img = null;

        // Load icons
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

        // Load icons for the right side
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/phone-call.png");
        Image image5 = new Image(input);
        icon1Img = new ImageView(image5);
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/video-call.png");
        Image image6 = new Image(input);
        icon2Img = new ImageView(image6);
        input = getClass().getResourceAsStream("/com/teacherdesktop/TopbarImgs/stalker.png");
        Image image7 = new Image(input);
        icon3Img = new ImageView(image7);

        // Create menu items
        Menu menuFile = new Menu("Plik");
        MenuItem fileItmOpen = new MenuItem("Otwórz");
        MenuItem fileItmSave = new MenuItem("Zapisz");
        menuFile.getItems().addAll(fileItmOpen, fileItmSave);

        MenuItem itmSettings = new MenuItem("Ustawienia");
        MenuItem itmPrint = new MenuItem("Drukuj");
        MenuItem itmExit = new MenuItem("Wyjdź");

        // Create MenuButton
        MenuButton burger = new MenuButton("", setImg);
        burger.getItems().addAll(menuFile, itmSettings, itmPrint, itmExit);

        // Create buttons
        Button btn1 = new Button("");
        btn1.setGraphic(groupImg);
        Button btn2 = new Button("");
        btn2.setGraphic(txtImg);
        Button btn3 = new Button("");
        btn3.setGraphic(treeImg);

        // Create buttons for the right side
        Button iconBtn1 = new Button("");
        iconBtn1.setGraphic(icon1Img);
        Button iconBtn2 = new Button("");
        iconBtn2.setGraphic(icon2Img);
        Button iconBtn3 = new Button("");
        iconBtn3.setGraphic(icon3Img);

        // Set minimum sizes
        burger.setMinSize(70, 50);
        btn1.setMinSize(60, 50);
        btn2.setMinSize(60, 50);
        btn3.setMinSize(60, 50);
        iconBtn1.setMinSize(60, 50);
        iconBtn2.setMinSize(60, 50);
        iconBtn3.setMinSize(60, 50);

        // Create label
        Label chatLabel = new Label("CZAT");
        chatLabel.setPrefSize(2000, 30);
        chatLabel.setStyle(
                "-fx-font-size: 30; " +
                        "-fx-text-alignment: center;" +
                        "-fx-alignment: center"
        );
        burger.setStyle("-fx-font-size: 15");

        // Add elements to the HBox
        this.getChildren().addAll(burger, btn1, btn2, btn3, chatLabel, iconBtn1, iconBtn2, iconBtn3);
        this.setStyle(
                "-fx-background-color: #6298e5; " +
                        "-fx-padding: 10"
        );
        this.setSpacing(10);
        this.setPrefSize(getMaxWidth(), 30);

        // Set action events for menu items and buttons
        itmExit.setOnAction(event -> exit());
        itmPrint.setOnAction(event -> System.out.println("Otwarcie okna do druku"));
        itmSettings.setOnAction(event -> System.out.println("Otwarcie okna ustawień"));
        fileItmOpen.setOnAction(event -> System.out.println("Otwarcie pliku"));
        fileItmSave.setOnAction(event -> System.out.println("Zapisano plik"));
        btn1.setOnAction(event -> System.out.println("Otwarcie menu grup"));
        btn2.setOnAction(event -> System.out.println("Otwarcie czatu"));
        btn3.setOnAction(event -> System.out.println("Otwarcie menu vcs"));
    }
}
