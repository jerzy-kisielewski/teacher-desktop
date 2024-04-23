package com.teacherdesktop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Chat extends HBox {

    private JSONArray messages;
    private VBox leftSide;
    private VBox rightSide;
    private boolean firstMessage = true;
    private boolean hostMessage = false;


    public Chat(){
        initHBox();
    }

    private void initHBox(){
        leftSide = new VBox();
        rightSide = new VBox();
        leftSide.setAlignment(Pos.TOP_LEFT);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(leftSide, rightSide);
        this.setHgrow(leftSide, Priority.ALWAYS);
        this.setHgrow(rightSide, Priority.ALWAYS);
        this.setAlignment(Pos.CENTER);

        initMessages();
    }

    private void initMessages(){
        try {
            InputStream is = getClass().getResourceAsStream("/messages.json");
            byte[] bytes = is.readAllBytes();
            String items = new String(bytes, StandardCharsets.UTF_8);
            messages = new JSONArray(items);
            if(messages != null){
                for (int i = 0; i < messages.length(); i ++){
                        JSONObject message = messages.getJSONObject(i);
                        if(message.getString("ip").equals(DataStoreManager.DataStore.hostIp)){
                            showHostMessage(message);
                        }
                        else {
                            showMessage(message);
                        }


                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showHostMessage(JSONObject message){
        Label label = new Label();
        label.setText(message.getString("message"));
        label.setStyle(
                "-fx-background-color: #9C6ED8;" +
                "-fx-padding: 30px;" +
                "-fx-min-width: 100px;" +
                "-fx-min-height: 50px;" +
                "-fx-start-margin: 50px;" +
                "-fx-background-radius: 50px;"
        );
        rightSide.getChildren().add(label);
        if(firstMessage || hostMessage){
            rightSide.setMargin(label, new Insets(10, 10, 0, 0));
            firstMessage = false;
        } else {
            rightSide.setMargin(label, new Insets(80, 10, 0, 0));
            hostMessage = true;
        }

    }

    private void showMessage(JSONObject message){
        Label label = new Label();
        label.setText(message.getString("message"));
        label.setStyle(
                "-fx-background-color: #9C6ED8;" +
                "-fx-padding: 30px;" +
                "-fx-min-width: 100px;" +
                "-fx-min-height: 50px;" +
                "-fx-start-margin: 50px;" +
                "-fx-background-radius: 50px;"
        );

        leftSide.getChildren().add(label);
        if(firstMessage || !hostMessage){
            leftSide.setMargin(label, new Insets(10, 0, 0, 10));
            firstMessage = false;
        } else {
            leftSide.setMargin(label, new Insets(80, 0, 0, 10));
            hostMessage = false;
        }

    }

}
