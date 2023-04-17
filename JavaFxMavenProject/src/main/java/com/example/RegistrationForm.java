package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
    	Dialog<String> dialog = new Dialog<String>();
        // Create the GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Create the form elements
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setFont(Font.font ("Verdana", 14));
        firstNameLabel.setTextFill(Color.BROWN);
        TextField firstNameTextField = new TextField();
        firstNameTextField.setPromptText("first name");
        
        TextArea area = new TextArea();
        area.setPromptText("first name");
        
        RadioButton radio=new RadioButton("sample");
        radio.setTextFill(Color.AQUA);
        
        

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameTextField = new TextField();
   
        lastNameLabel.setFont(Font.font ("Verdana", 14));
        lastNameLabel.setTextFill(Color.BROWN);

        Label emailLabel = new Label("Email:");
        TextField emailTextField = new TextField();
        emailLabel.setFont(Font.font ("Verdana", 14));
        emailLabel.setTextFill(Color.BROWN);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordLabel.setFont(Font.font ("Verdana", 14));
        passwordLabel.setTextFill(Color.BROWN);

        Label confirmPasswordLabel = new Label("Confirm Password:");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordLabel.setFont(Font.font ("Verdana", 14));
        confirmPasswordLabel.setTextFill(Color.BROWN);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> {
        	 dialog.setTitle("Dialog");
            ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
        	dialog.setContentText("Submitted Successfully");
        	dialog.getDialogPane().getButtonTypes().add(type);
        	dialog.showAndWait();
        	firstNameTextField.setText("");
        	lastNameTextField.setText("");
        	emailTextField.setText("");
        	passwordField.setText("");
        	confirmPasswordField.setText("");
            });
        registerButton.setStyle("-fx-background-color: #89cff0");
        registerButton.setMaxHeight(40);
        registerButton.setMaxWidth(100);

        // Add the form elements to the GridPane
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameTextField, 1, 0);

        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameTextField, 1, 1);

        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailTextField, 1, 2);

        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);

        gridPane.add(confirmPasswordLabel, 0, 4);
        gridPane.add(confirmPasswordField, 1, 4);

        gridPane.add(registerButton, 1, 5);
        gridPane.add(area, 0, 6);
        gridPane.add(radio, 1, 6);

        // Create the scene and set it on the stage
        Scene scene = new Scene(gridPane, 500, 500);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration Form");
 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

