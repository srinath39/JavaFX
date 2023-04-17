package com.example;

import java.io.File;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    private ProgressBar progressBar;
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        // Create the root StackPane and set its properties
        StackPane root = new StackPane();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create the GridPane and set its properties
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Add a Label and Button to the GridPane for selecting a file
        Label fileLabel = new Label("Select an image file:");
        Button fileButton = new Button("Select File");
        fileButton.setOnAction(new FileButtonHandler());

        gridPane.add(fileLabel, 0, 0);
        gridPane.add(fileButton, 1, 0);

        // Create a FlowPane for displaying the image and progress bar
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);

        // Add an ImageView and ProgressBar to the FlowPane
        imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        flowPane.getChildren().add(imageView);

        progressBar = new ProgressBar(0);
        progressBar.setVisible(false);
        flowPane.getChildren().add(progressBar);

        // Add the GridPane and FlowPane to the root StackPane
        VBox vBox = new VBox(gridPane, flowPane);
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);

        // Create the Scene and set it on the primary stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Layout Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class FileButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            // Display a FileChooser dialog to select an image file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Image File");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp"));
            File file = fileChooser.showOpenDialog(progressBar.getScene().getWindow());

            if (file != null) {
                // Load the selected image file and display it in the ImageView
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);

                // Start a Task to simulate loading the image and updating the ProgressBar
                Task<Void> task = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        progressBar.setVisible(true);
                        for (int i = 0; i < 10; i++) {
                            updateProgress(i, 10);
                            Thread.sleep(500);
                        }
                        progressBar.setVisible(false);
						return null;
                       
                    }
                };

                // Bind the ProgressBar's progress property to the Task's progress property
                progressBar.progressProperty().bind(task.progressProperty());

                // Start the Task on a new thread
                new Thread(task).start();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

