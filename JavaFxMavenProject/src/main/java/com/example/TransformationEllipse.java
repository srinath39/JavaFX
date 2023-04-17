package com.example;



import javafx.application.Application;  
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate; 


public class TransformationEllipse extends Application implements EventHandler{  
	Ellipse rect;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Translate translate;
	Rotate rotate;
	Scale scale;
	Shear shear;
    @Override  
    public void start(Stage primaryStage) {  
    	rect=new Ellipse(100,100,50,30);
    	rect.setFill(Color.AQUA);
    	rect.setStroke(Color.BLACK);
    	translate=new Translate();
    	translate.setX(30);
    	translate.setY(30);
    	translate.setZ(30);
        btn1=new Button("Translate");
    	btn1.setLayoutX(100);
    	btn1.setLayoutY(350);
    	btn1.setOnAction(this);
    	rotate=new Rotate();
    	rotate.setPivotX(100);
    	rotate.setPivotY(100);
    	rotate.setAngle(30);

    	btn2=new Button("Rotate");
    	btn2.setLayoutX(200);
    	btn2.setLayoutY(350);
    	btn2.setOnAction(this);
    	scale=new Scale();
    	scale.setX(1.5);
    	scale.setY(1.5);
    	scale.setPivotX(100);
    	scale.setPivotY(100);
    	btn3=new Button("Scale");
    	btn3.setLayoutX(300);
    	btn3.setLayoutY(350);
    	btn3.setOnAction(this);
    	shear=new Shear();
    	shear.setPivotX(100);
    	shear.setPivotY(100);
    	shear.setX(0.3);
    	shear.setY(0.0);
    	btn4=new Button("Shear");
    	btn4.setLayoutX(400);
    	btn4.setLayoutY(350);
    	btn4.setOnAction(this);
    	btn5=new Button("normal");
    	btn5.setLayoutX(500);
    	btn5.setLayoutY(350);
    	btn5.setOnAction(this);
    	Group root=new Group();
    	root.getChildren().addAll(rect,btn1,btn2,btn3,btn4,btn5);
        Scene scene=new Scene(root,600,400);      
        primaryStage.setScene(scene);  
        primaryStage.setTitle("First JavaFX Application");  
        primaryStage.show();  
    }  
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		if(event.getSource()==btn1)
			translate();
		else if(event.getSource()==btn2)
			rotate();
		else if(event.getSource()==btn3)
			scale();
		else if(event.getSource()==btn4)
			shear();
		else
		{
			rect.getTransforms().clear();
    		rect.getTransforms().add(new Affine());
		}
	}
	
	public void translate()
	{
		rect.getTransforms().addAll(translate);
	}
  
	public void rotate()
	{
		rect.getTransforms().addAll(rotate);
	}
	public void scale()
	{
		rect.getTransforms().addAll(scale);
	}
	public void shear()
	{
		rect.getTransforms().addAll(shear);
	}
  
}  