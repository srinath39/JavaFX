package com.example;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainPage extends Application{
	private static Connection conn=null;
	private static Stage main=null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Statement statement = conn.createStatement();
	    String q = "select * from carsSurvey";
	    ResultSet resultSet = statement.executeQuery(q);
		main=primaryStage;
		VBox page=new VBox();
		BorderPane bp=new BorderPane();
		Label top=new Label("");
		Font font = Font.font("Arial", 20);
		Label appName =new Label("CarSurvey");
        appName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        appName.setTextFill(Color.WHITE);
        Button rank=new Button("Rank");
        rank.setPrefWidth(130);
        rank.setPrefHeight(40);
        rank.setFont(font);
        BackgroundFill background_fillb = new BackgroundFill(Color.WHITE, 
                CornerRadii.EMPTY, Insets.EMPTY);
       Background backgroundb = new Background(background_fillb);
        rank.setBackground(backgroundb);
        rank.setOnAction(e->{
        	main.close();
        	Stage stage=new Stage();
        	RankingPage obj=new RankingPage(conn,main);
        	try {
				obj.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        	
        });
        bp.setLeft(appName);
        bp.setTop(top);
        bp.setRight(rank);
        bp.setPrefHeight(100.0);
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, 
                CornerRadii.EMPTY, Insets.EMPTY);
       Background background = new Background(background_fill);
        bp.setBackground(background);
        
        
		ScrollPane pane=new ScrollPane();
		VBox root=new VBox();

		while(resultSet.next()) {
			root.getChildren().add(this.getNode(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8)));
		}
		root.setSpacing(50);
		root.setAlignment(Pos.CENTER);
		 AnchorPane anchor_pane = new AnchorPane(root);
         AnchorPane.setTopAnchor(root, 50.0);
         AnchorPane.setLeftAnchor(root, 150.0);
         AnchorPane.setRightAnchor(root, 50.0);
         AnchorPane.setBottomAnchor(root, 100.0);
        pane.setContent(anchor_pane);
        BackgroundFill background_fillp = new BackgroundFill(Color.GRAY, 
                CornerRadii.EMPTY, Insets.EMPTY);
       Background backgroundp = new Background(background_fillp);
        pane.setBackground(backgroundp);
        
        
        
        page.getChildren().addAll(bp,pane);
		Scene scene=new Scene(page,1000,700);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("sample");
		primaryStage.show();
	}
	public static void main(String args[]) throws ClassNotFoundException, Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbName = "mydb";
		String db_username = "root";
		String db_password = "1234";
		try {
			conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/"+dbName, db_username, db_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		launch(args);
	}
	
	public HBox getNode(int id, String carN, String carE, double carB, int sc, String dt, int mileage, String fuel)
	{
		HBox root=new HBox();
		Rectangle rec=new Rectangle();
		rec.setWidth(300);
		rec.setHeight(275);
		Font font = Font.font("Arial", 20);
		GridPane subroot=new GridPane();
		Label carName=new Label("Name:");
        carName.setFont(font);
        Label carNamev=new Label(carN);
        carNamev.setFont(font);
		Label carEngine=new Label("Engine:");
		carEngine.setFont(font);
		Label carEnginev=new Label(carE);
		carEnginev.setFont(font);
		Label carBHP=new Label("BHP:");
		carBHP.setFont(font);
		Label carBHPv=new Label(String.valueOf(carB)+" Bhp");
		carBHPv.setFont(font);
		Label carSeating=new Label("Seating Capacity:");
		carSeating.setFont(font);
		Label carSeatingv=new Label(String.valueOf(sc));
		carSeatingv.setFont(font);
		Label carDriveType=new Label("");
		carDriveType.setFont(font);
		Label carDriveTypev=new Label("");
		carDriveTypev.setFont(font);
		Label carMileage=new Label("Mileage:");
		carMileage.setFont(font);
		Label carMileagev=new Label(String.valueOf(mileage)+" kmpl");
		carMileagev.setFont(font);
		Label carFuel=new Label("Fuel:");
		carFuel.setFont(font);
		Label carFuelv=new Label(fuel);
		carFuelv.setFont(font);
		BackgroundFill backgroundb = new BackgroundFill(Color.WHITE, 
                CornerRadii.EMPTY, Insets.EMPTY);
       Background backgroundbs = new Background(backgroundb);		
		Button view =new Button("View More");
		view.setPrefWidth(130);
		view.setPrefHeight(40);
		view.setFont(font);
		view.setBackground(backgroundbs);
		view.setOnAction(e->{
			try {
				Desktop.getDesktop().browse(new URI("https://www.cardekho.com/kia/seltos"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Button feedback=new Button("FeedBack");
		feedback.setPrefWidth(130);
		feedback.setPrefHeight(40);
		feedback.setFont(font);
		feedback.setBackground(backgroundbs);
		feedback.setOnAction(e->{
			main.close();
			Stage stage=new Stage();
			FeedBack obj=new FeedBack(main,id,conn);
			try {
				obj.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		subroot.addRow(0,carName,carNamev);
		subroot.addRow(1,carEngine,carEnginev);
		subroot.addRow(2,carBHP,carBHPv);
		subroot.addRow(3,carSeating,carSeatingv);
		subroot.addRow(6,carDriveType,carDriveTypev);
		subroot.addRow(4,carMileage,carMileagev);
		subroot.addRow(5,carFuel,carFuelv);
		subroot.addRow(7, view,feedback);
		
		subroot.setHgap(20);
		subroot.setVgap(10);
		
		root.getChildren().addAll(rec,subroot);
		root.setSpacing(20);
		BackgroundFill background_fill = new BackgroundFill(Color.DARKGRAY, 
                CornerRadii.EMPTY, Insets.EMPTY);
       Background background = new Background(background_fill);
       root.setBackground(background);
		return root;
	}
}
