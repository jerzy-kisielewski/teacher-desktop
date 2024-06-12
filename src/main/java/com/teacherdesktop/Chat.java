package com.teacherdesktop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Chat extends VBox {

    private List<JSONObject> messages = new ArrayList<>();
    private VBox leftSide;
    private VBox rightSide;
    private boolean firstMessage = true;
    private boolean hostMessage = false;
    private TextField inputTextField;
    private Button sendButton;
    private int margin = 40;

    public Chat() {
        initVBox();
    }

    private void initVBox() {
        HBox messageContainer = new HBox();
        leftSide = new VBox();
        rightSide = new VBox();
        leftSide.setAlignment(Pos.TOP_LEFT);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        messageContainer.getChildren().addAll(leftSide, rightSide);
        messageContainer.setHgrow(leftSide, Priority.ALWAYS);
        messageContainer.setHgrow(rightSide, Priority.ALWAYS);
        messageContainer.setAlignment(Pos.CENTER);

        HBox inputContainer = new HBox();
        inputTextField = new TextField();
        sendButton = new Button("Send");
        sendButton.setStyle("-fx-background-color: #9C6ED8;" +
                            "-fx-padding: 15px;");
        inputContainer.getChildren().addAll(inputTextField, sendButton);
        inputContainer.setHgrow(inputTextField, Priority.ALWAYS);
        inputContainer.setSpacing(10);
        inputContainer.setPadding(new Insets(10, 10, 10, 10));
        inputContainer.setAlignment(Pos.CENTER);

        this.getChildren().addAll(messageContainer, inputContainer);
        VBox.setVgrow(messageContainer, Priority.ALWAYS);
        VBox.setMargin(inputContainer, new Insets(20, 10, 10, 10));

        sendButton.setOnAction(e -> sendMessage());

        initMessages();
    }

    private void initMessages() {
        try {
            InputStream is = getClass().getResourceAsStream("/messages.json");
            byte[] bytes = is.readAllBytes();
            String items = new String(bytes, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(items);

            int start = Math.max(0, jsonArray.length() - 10);
            for (int i = start; i < jsonArray.length(); i++) {
                JSONObject jsonMessage = jsonArray.getJSONObject(i);
                messages.add(jsonMessage);
                if (jsonMessage.getString("ip").equals(DataStoreManager.DataStore.hostIp)) {
                    showHostMessage(jsonMessage);
                } else {
                    showMessage(jsonMessage);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showHostMessage(JSONObject message) {
        Label label = new Label();
        label.setText(message.getString("message"));
        label.setStyle(
                "-fx-background-color: #9C6ED8;" +
                        "-fx-padding: 15px;" +
                        "-fx-min-width: 100px;" +
                        "-fx-min-height: 50px;" +
                        "-fx-start-margin: 50px;" +
                        "-fx-background-radius: 50px;"
        );
        rightSide.getChildren().add(label);
        if (firstMessage || hostMessage) {
            rightSide.setMargin(label, new Insets(10, 10, 0, 0));
            firstMessage = false;
        } else {
            rightSide.setMargin(label, new Insets(margin, 10, 0, 0));
            hostMessage = true;
            margin += 40;
        }
    }

    private void showMessage(JSONObject message) {
        Label label = new Label();
        label.setText(message.getString("message"));
        label.setStyle(
                "-fx-background-color: #9C6ED8;" +
                        "-fx-padding: 15px;" +
                        "-fx-min-width: 100px;" +
                        "-fx-min-height: 50px;" +
                        "-fx-start-margin: 50px;" +
                        "-fx-background-radius: 50px;"
        );
        leftSide.getChildren().add(label);
        if (firstMessage || !hostMessage) {
            leftSide.setMargin(label, new Insets(10, 0, 0, 10));
            firstMessage = false;
        } else {
            leftSide.setMargin(label, new Insets(margin, 0, 0, 10));
            hostMessage = false;
            margin += 40;
        }
    }

    private void sendMessage() {
        String messageText = inputTextField.getText();
        if (!messageText.isEmpty()) {
            String created = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
            JSONObject message = new JSONObject();
            message.put("message", messageText);
            message.put("ip", DataStoreManager.DataStore.hostIp);
            message.put("firstName", DataStoreManager.DataStore.Workspaces.get(0).firstName);
            message.put("lastName", DataStoreManager.DataStore.Workspaces.get(0).lastName);
            message.put("created", created);
            messages.add(message);
            if (messages.size() > 10) {
                removeOldestMessage();
            }
            showHostMessage(message);
            inputTextField.clear();
            saveMessagesToFile();
        }
    }

    private void removeOldestMessage() {
        JSONObject oldestMessage = messages.remove(0);
        if (oldestMessage.getString("ip").equals(DataStoreManager.DataStore.hostIp)) {
            rightSide.getChildren().remove(0);
        } else {
            leftSide.getChildren().remove(0);
        }
        firstMessage = messages.isEmpty();
    }

    private void saveMessagesToFile() {
        JSONArray jsonArray = new JSONArray(messages);
        try (FileWriter file = new FileWriter("src/main/resources/messages.json")) {
            file.write(jsonArray.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
