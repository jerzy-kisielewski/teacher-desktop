package com.teacherdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Topbar topbar = new Topbar();
        GroupsSidebar groupsBar = new GroupsSidebar();
        BorderPane layout = new BorderPane();

        layout.setTop(topbar);
        layout.setLeft(groupsBar);
        Scene scene = new Scene(layout, 320, 240);
        scene.getStylesheets().add(getClass().getResource("/com/teacherdesktop/css/style.css").toExternalForm());

        stage.setMaximized(true);
        stage.setTitle("TeacherDesktop");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}