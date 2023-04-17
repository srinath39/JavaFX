package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegsitrationEmployee extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    	ToggleGroup group = new ToggleGroup();  
        RadioButton male = new RadioButton("male");  
        RadioButton female = new RadioButton("female");
        RadioButton other = new RadioButton("other");
        HBox box=new HBox(10);
        box.getChildren().addAll(male,female,other);
        male.setToggleGroup(group);
        female.setToggleGroup(group);
        other.setToggleGroup(group);
        Label gender=new Label("Gender :");
        Label title=new Label("Registration Form");
      //  Label form=new Label("Form");
   //     form.setFont(new Font("Arial", 20));
   //     form.setTextFill(Color.BLUE);
        title.setTextFill(Color.BLUE);
        title.setFont(new Font("Arial", 20));
    	Label tl=new Label("UserName :");
    	Label dl=new Label("DOB");
    	Label phno=new Label("Phno :");
    	Label id=new Label("User ID :");
    	Label textarea=new Label("Address :");
    	TextArea tarea = new TextArea();
    	tarea.setPrefSize(100, 60);
    	TextField tf=new TextField();
    	TextField tid=new TextField();
    	TextField tphno=new TextField();
    	DatePicker dp=new DatePicker();
    	Button submit=new Button("Submit");
    	submit.setOnAction(e->{
    		primaryStage.close();
    		EmployeeAvailability emp=new EmployeeAvailability();
    		try {
				emp.addRows(Integer.parseInt(tid.getText()),tf.getText() );
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    	GridPane root=new GridPane();
    	root.setHgap(10);
    	root.setVgap(25);
    	//root.setGridLinesVisible(true);
    	//root.addRow(0, title,form);
    	root.addRow(0,tl,tf);
    	root.addRow(1,id,tid);
    	root.addRow(2,phno,tphno);
    	root.addRow(3,gender,box);
    	root.addRow(4,textarea,tarea);
    	root.addRow(5, dl,dp);
    	root.setAlignment(Pos.CENTER);
    	VBox vbox=new VBox();
    	vbox.getChildren().addAll(title,root,submit);
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setSpacing(30);
        Scene scene = new Scene(vbox, 600, 500);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign Up");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

