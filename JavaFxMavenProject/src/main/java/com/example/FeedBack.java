package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FeedBack extends Application {
	private PreparedStatement statement=null;
	private Connection conn=null;
	private  Stage main=null;
	private  int carId;
	private ArrayList<ToggleGroup> arr;
	private int feedId;
	public FeedBack(Stage main,int id,Connection conn) {
		this.conn=conn;
		this.main=main;
		carId=id;
		arr=new ArrayList<>();
		feedId=201;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox root=new HBox();
		VBox leftroot=new VBox();
		Font font = Font.font("Arial", 18);
		Label comfort=new Label("How is the comfort level?");
		comfort.setFont(font);
		Label handling=new Label("how well is Handling?");
		handling.setFont(font);
		Label braking=new Label("How perfect are the brakes are?");
		braking.setFont(font);
		Label ifeatures=new Label("Do you Like the interior features?");
		ifeatures.setFont(font);
		Label efeatures=new Label("Do you like the exterior features of the car?");
		efeatures.setFont(font);
		Label noisel=new Label("How about the Noise level free?");
		noisel.setFont(font);
		Label accs=new Label("How is the Acceleration and speed?");
		accs.setFont(font);
		leftroot.getChildren().add(comfort);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(handling);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(braking);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(ifeatures);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(efeatures);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(noisel);
		leftroot.getChildren().add(this.getfeed());
		leftroot.getChildren().add(accs);
		leftroot.getChildren().add(this.getfeed());
		leftroot.setSpacing(20);
		
		VBox rightroot=new VBox();
		Label comment =new Label("FeedBack :");
		comment.setFont(font);
		TextArea area=new TextArea();
		area.setPrefSize(150, 100);
		Button submit =new Button("Submit Feedback");
		rightroot.getChildren().addAll(comment,area,submit);
		submit.setPrefWidth(180);
		submit.setPrefHeight(40);
		submit.setFont(font);
		submit.setOnAction(e->{
			HashMap<String,Double> h=new HashMap<>();
			h.put("VeryGood",10.0);
			h.put("Good", 7.5);
			h.put("Fair", 5.0);
			h.put("Poor", 2.5);
			
			Double sum=0.0;
			for(int i=0;i<arr.size();i++)
			{
			RadioButton selectedRadioButtonValue = (RadioButton) arr.get(i).getSelectedToggle();
            String text = selectedRadioButtonValue.getText();
            sum=sum+ h.get(text);
            
			}
			UUID uuid = UUID.randomUUID();
			Double score=sum/arr.size();
			String q = String.format("insert into feedback values (?,?,?);");
			try {
				statement = conn.prepareStatement(q);
				statement.setString(1, uuid.toString());
	            statement.setDouble(2, score);
	            statement.setInt(3, carId);
	            statement.executeUpdate();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
	        feedId=feedId+1;
			primaryStage.close();
			FinalPage obj=new FinalPage(primaryStage,main);
			Stage stage=new Stage();
			try {
				obj.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		rightroot.setSpacing(20);
		
		root.getChildren().addAll(leftroot,rightroot);
		root.setSpacing(30);
		
		AnchorPane anchor_pane = new AnchorPane(root);
        AnchorPane.setTopAnchor(root, 50.0);
        AnchorPane.setLeftAnchor(root, 250.0);
        AnchorPane.setRightAnchor(root, 50.0);
        AnchorPane.setBottomAnchor(root, 100.0);
		Scene scene=new Scene(anchor_pane,1000,700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FeedBack form");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public  HBox getfeed()
	{
		HBox leftroot=new HBox();
		RadioButton vg=new RadioButton("VeryGood");
		RadioButton g=new RadioButton("Good");
		RadioButton f=new RadioButton("Fair");
		RadioButton p=new RadioButton("Poor");
		ToggleGroup tg=new ToggleGroup();
		vg.setToggleGroup(tg);
		g.setToggleGroup(tg);
		f.setToggleGroup(tg);
		p.setToggleGroup(tg);
		leftroot.getChildren().addAll(vg,g,f,p);
		leftroot.setSpacing(15);
		arr.add(tg);
		return leftroot;
	}
}
