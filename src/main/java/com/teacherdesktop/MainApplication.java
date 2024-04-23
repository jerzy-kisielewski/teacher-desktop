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
        DataStoreManager.saveWorkSpaces();

        Topbar topbar = new Topbar();
        GroupsSidebar groupsBar = new GroupsSidebar();
        Chat chat = new Chat();

        BorderPane layout = new BorderPane();

        layout.setTop(topbar);
        layout.setLeft(groupsBar);
        layout.setCenter(chat);
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