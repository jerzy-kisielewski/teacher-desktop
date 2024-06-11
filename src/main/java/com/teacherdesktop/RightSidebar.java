package com.teacherdesktop;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;

public class RightSidebar extends VBox {

    public RightSidebar() {
        Label czlonkowieLabel = createTitleLabel("CZŁONKOWIE");
        Label primaveraLabel = createStyledLabel("PRIMAVERA");
        Label sreverLabel = createStyledLabel("SREVER");
        Label riversLabel = createStyledLabel("RIVERS");
        Label benjiLabel = createStyledLabel("BENJI");

        this.getChildren().addAll(czlonkowieLabel, primaveraLabel, sreverLabel, riversLabel, benjiLabel);

        this.setStyle("-fx-background-color: #6298e5; -fx-padding: 10px; -fx-spacing: 10px;");
    }

    private Label createStyledLabel(String text) {
        Label label = new Label(text);
        label.setPrefSize(200, 50);  // Adjust size to match buttons
        label.setStyle("-fx-background-color: linear-gradient(to bottom, #f0f0f0, #d0d0d0); -fx-text-fill: black; -fx-font-weight: bold; -fx-border-color: gray; -fx-border-width: 1px; -fx-alignment: center;");

        label.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), Insets.EMPTY)));

        return label;
    }

    private Label createTitleLabel(String text) {
        Label label = new Label(text);
        label.setPrefSize(200, 60);  // Make the title label larger
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-font-weight: bold; -fx-alignment: center;");

        // Optionally, you can add a background and border to the title
        label.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5.0), Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

        return label;
    }
}
