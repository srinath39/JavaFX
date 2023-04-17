package com.example;

import java.awt.Button;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RankingPage extends Application{
	private Connection conn;
	private Stage main;
	public RankingPage(Connection conn,Stage main) {
		this.conn=conn;
		this.main=main;
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		Statement statement = conn.createStatement();
	    String q = "SELECT avg(score), carId FROM feedback GROUP BY carId ORDER BY avg(score) desc;";
	    ResultSet resultSet = statement.executeQuery(q);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(2));
		}
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("main.fxml"))));
		stage.setTitle("Ranking Page");
		stage.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}

}
