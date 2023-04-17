package com.example;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutPractice extends Application{

	
	@Override
	public void start(Stage stage) throws Exception {
   /*   BorderPane root=new BorderPane();
		root.setCenter(new Label("this is at center"));
		root.setTop(new Label("this is at Top"));
		root.setRight(new Label("this is at Right"));
		root.setBottom(new Label("this is at Bottom"));
		root.setLeft(new Label("this is at Left")); */
	/*	Label label=new Label();
		TextInputDialog text=new TextInputDialog();
		text.setHeaderText("enter scale value");
		
		Button btn1=new Button("click");
		btn1.setOnAction(e->{
			Optional<String> result = text.showAndWait();

	        result.ifPresent(name -> {
	            label.setText(name);
	        });
		});
		VBox root=new VBox();
		root.setSpacing(5);*/
	/*	Button btn3=new Button("button3");
	/*	HBox root=new HBox();
		root.setSpacing(30);  */
		
		/*	VBox root=new VBox();
		root.setSpacing(30); */
		
	/*	StackPane root=new StackPane(); */
		
/*		Label firstName=new Label("Firstname");
		Label lastName =new Label("LastName");
		TextField fname=new TextField();
		TextField lname=new TextField();
		GridPane root=new GridPane();
	//	root.setGridLinesVisible(true);
		root.setHgap(20);
		root.setVgap(20);
		root.addRow(0,firstName,fname);
		root.addRow(1,lastName,lname);    */
	
	/*	FlowPane root=new FlowPane();
		root.setVgap(20);
		root.setHgap(50);
		root.setPrefWrapLength(50);
		root.getChildren().addAll(btn1,btn2); */
		
		
		
		
		Button btn1=new Button("btn1");
		Button btn2=new Button("btn2");
		Button btn3=new Button("btn3");
		
		
		
		
		
		TilePane tile=new TilePane();     // fixed size of grid
		//tile.setAlignment(Pos.LEFT);
		tile.setOrientation(Orientation.HORIZONTAL);
		tile.setHgap(20);
		
		
		
		
		
		tile.getChildren().addAll(btn1,btn2,btn3);
		Scene scene=new Scene(tile,400,400);
		stage.setScene(scene);
		stage.setTitle("layout Practice");
		stage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}	
