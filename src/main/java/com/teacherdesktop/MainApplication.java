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
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml")); nw czy to potrzebne czy było do testów lol
        Scene scene = new Scene(layout, 320, 240);
        stage.setMaximized(true);
        stage.setTitle("TeacherDesktop");
        stage.setScene(scene);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}