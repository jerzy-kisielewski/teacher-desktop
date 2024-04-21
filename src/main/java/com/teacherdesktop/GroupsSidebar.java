package com.teacherdesktop;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GroupsSidebar extends HBox {
    public GroupsSidebar(){
        Button btn1 = new Button("Grupa 1");
        Button btn2 = new Button("Grupa 2");
        Button btn3 = new Button("Grupa 3");

        btn1.setPrefSize(280,50);
        btn2.setPrefSize(280,50);
        btn3.setPrefSize(280,50);


        this.setSpacing(10);
        this.getChildren().addAll(btn1,btn2,btn3);
        this.setPrefSize(300,  500);
        this.setStyle(
                "-fx-background-color: #6298e5;"
        );
    }
}
