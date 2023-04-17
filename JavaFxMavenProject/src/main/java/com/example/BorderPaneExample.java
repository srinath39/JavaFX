package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Label top=new Label("TOP");
		top.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		top.setBackground(new Background(new BackgroundFill(Color.valueOf("#b1cce7"), null, Insets.EMPTY)));
		Label bottom=new Label("BOTTOM");
		bottom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bottom.setBackground(new Background(new BackgroundFill(Color.valueOf("#cdf0ca"), null, Insets.EMPTY)));
		Label center=new Label("CENTER");
		center.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		center.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffdddd"), null, Insets.EMPTY)));
		Label left=new Label("LEFT");
		left.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		left.setBackground(new Background(new BackgroundFill(Color.valueOf("#cfbbff"), null, Insets.EMPTY)));
		Label right=new Label("BALASHIVA");
		right.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		right.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffbbce"),null, Insets.EMPTY))); 
		
		
		BorderPane root=new BorderPane();
		root.setPadding(new Insets(4));
		BorderPane.setMargin(top,new  Insets(3));
		BorderPane.setMargin(bottom,new  Insets(3));
		BorderPane.setMargin(left,new  Insets(3));
		BorderPane.setMargin(right,new  Insets(3));
		BorderPane.setMargin(center,new  Insets(3));
		root.setTop(top);
		root.setBottom(bottom);
		root.setCenter(center);
		root.setLeft(left);
		root.setRight(right);
		Scene scene=new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane window");
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
