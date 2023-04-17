package com.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalPage extends Application{
	private static Stage feed;
	private static Stage main;
	
	public FinalPage(Stage feed, Stage main) {
		this.feed=feed;
		this.main=main;
	}
	@Override
	public void start(Stage stage) throws Exception {
		Font font = Font.font("Arial", 24);
		Label sucess=new Label("FeedBack Form Sucessfully submitted");
		Button go=new Button("Goto HomePage");
		go.setFont(Font.font("Arial", 18));
		go.setPrefSize(180, 40);
		go.setTranslateX(400);
		go.setTranslateY(100);
		go.setOnAction(e->{
			stage.close();
			MainPage obj=new MainPage();
			try {
				obj.start(main);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		sucess.setFont(font);
		sucess.setTranslateX(300);
		sucess.setTranslateY(50);
		Group root=new Group();
		root.getChildren().addAll(sucess,go);
		Scene scene=new Scene(root,1000,700);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Sucessfull");
		stage.show();
	}
	public static void main(String args[])
	{
		launch(args);
	}

}
