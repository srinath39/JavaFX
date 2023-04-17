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

public class EmployeeAvailability extends Application{
	private TableView tableview;
	private TableColumn<Person,Integer> column1;
	private TableColumn<Person,String> column2;
	private TableColumn<Person,Button> column3;
	
	
	public EmployeeAvailability()
	{
		tableview=new TableView();
		column1=new TableColumn<>("User ID");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column2=new TableColumn<>("UserName");
		column2.setCellValueFactory(new PropertyValueFactory("username"));
		column3=new TableColumn<>("Availabitity");
		column3.setCellValueFactory(new PropertyValueFactory("available"));
		tableview.getColumns().add(column1);
		tableview.getColumns().add(column2);
		tableview.getColumns().add(column3);
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Button btn=new Button("ADD");
		btn.setOnAction(e->{
			stage.close();
			RegsitrationEmployee rg=new RegsitrationEmployee();
			Stage stg=new Stage();
			try {
				rg.start(stg);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		VBox root=new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tableview,btn);
		Scene scene=new Scene(root,600,500);
		stage.setScene(scene);
		stage.setTitle("availability");
		stage.show();
	}
	
	
	public void addRows(int val,String str) throws Exception
	{
		Stage stg=new Stage();
		Button btn=new Button("Availability");
		btn.setOnAction(e->{
			stg.close();
			AvailabilityWeek av=new AvailabilityWeek();
			try {
				av.addRows(101);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		tableview.getItems().add(new Person(val,str,btn));
		start(stg);
		
	}
	public static void main(String args[])
	{
		launch(args);
	}
	
}
