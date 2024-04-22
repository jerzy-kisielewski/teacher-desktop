package com.teacherdesktop;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GroupsSidebar extends VBox {
    public GroupsSidebar(){
        super(10);
        Button btn1 = new Button("Grupa 1");
        Button btn2 = new Button("Grupa 2");
        Button btn3 = new Button("Grupa 3");

        btn1.setPrefSize(280,50);
        btn2.setPrefSize(280,50);
        btn3.setPrefSize(280,50);

        this.setSpacing(10);
        this.getChildren().addAll(btn1,btn2,btn3);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(300,  500);
        this.setStyle(
                "-fx-background-color: #6298e5;" +
                        "-fx-display: flex;" +
                        "-fx-flex-wrap: wrap;" +
                        "-fx-flex-direction: column;"
        );
    }
}
