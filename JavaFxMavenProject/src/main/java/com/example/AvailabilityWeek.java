package com.example;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AvailabilityWeek extends Application{
	private TableView tableview;
	private TableColumn<Person,String > column1;
	private TableColumn<Person,Integer> column2;
	private TableColumn<Person,Integer> column3;
	
	public AvailabilityWeek()
	{
		tableview=new TableView();
		
		column1=new TableColumn<>("WeekDay");
		column1.setCellValueFactory(new PropertyValueFactory("weekday"));
		column2=new TableColumn<>("WorkingHours");
		column2.setCellValueFactory(new PropertyValueFactory("whours"));
		column3=new TableColumn<>("Non-WorkingHours");
		column3.setCellValueFactory(new PropertyValueFactory("nwhours"));
		tableview.getColumns().add(column1);
		tableview.getColumns().add(column2);
		tableview.getColumns().add(column3);
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root=new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tableview);
		Scene scene=new Scene(root,600,500);
		stage.setScene(scene);
		stage.setTitle("availability");
		stage.show();
	}
	
	
	public void addRows(int id) throws Exception
	{
		tableview.getItems().add(new EmployeeWork("moday",5,3));
		tableview.getItems().add(new EmployeeWork("tuesday",4,4));
		tableview.getItems().add(new EmployeeWork("Wednesday",6,2));
		tableview.getItems().add(new EmployeeWork("Thursday",5,3));
		tableview.getItems().add(new EmployeeWork("friay",4,4));
		Stage stg=new Stage();
		start(stg);
		
	}
	public static void main(String args[])
	{
		launch(args);
	}
	
}

