package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HorizontalNavigationBar extends Application {
    
    @Override
    public void start(Stage stage) {
        
        // Create the buttons
        Button homeButton = new Button("Home");
        Button aboutButton = new Button("About");
        Button contactButton = new Button("Contact");
        
        // Set the style of the buttons
        homeButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        aboutButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        contactButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        
        // Add the buttons to an HBox
        HBox buttonBox = new HBox(homeButton, aboutButton, contactButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        // Create a StackPane to center the HBox horizontally and vertically
        StackPane centerPane = new StackPane(buttonBox);
        
        // Set the background color of the navigation bar
        centerPane.setStyle("-fx-background-color: #CCCCCC;");
        
        // Add padding to the StackPane
        centerPane.setPadding(new Insets(10, 0, 10, 0));
        
        // Add the StackPane to a VBox to allow for additional content above or below the navigation bar
        VBox navBar = new VBox(centerPane);
        
        // Create a Scene with the navigation bar VBox and set it as the root of the stage
        Scene scene = new Scene(navBar, 400, 100);
        stage.setScene(scene);
        stage.setTitle("Horizontal Navigation Bar Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
