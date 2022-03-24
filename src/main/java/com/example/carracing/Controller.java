package com.example.carracing;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller{
    @FXML
    private Button start_Button, exit_Button, begin_Button;
    @FXML
    private Circle car_1, car_2, car_3, car_4;
    
    Path path;
    Car car1, car2, car3, car4;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void startSimulation(){
        moveCar1();
        moveCar2();
        moveCar3();
        moveCar4();
    }
    public void swapToScene1(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swapToScene2(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    public void moveCar1(){
        car1 = new Car();
        path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(550, 0));
        path.getElements().add(new LineTo(550, -265));
        path.getElements().add(new LineTo(0, -265));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_1);
        transition.setDuration(Duration.seconds(10 - car1.getSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar2(){
        car2 = new Car();
        path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(0, -265));
        path.getElements().add(new LineTo(-550, -265));
        path.getElements().add(new LineTo(-550, 5));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_2);
        transition.setDuration(Duration.seconds(10 - car2.getSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar3(){
        car3 = new Car();
        path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(-550, 0));
        path.getElements().add(new LineTo(-550, 265));
        path.getElements().add(new LineTo(0, 265));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_3);
        transition.setDuration(Duration.seconds(10 - car3.getSpeed()));
        transition.setPath(path);
        transition.play();
    }
    public void moveCar4(){
        car4 = new Car();
        path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(0, 265));
        path.getElements().add(new LineTo(550, 265));
        path.getElements().add(new LineTo(550, 0));
        path.getElements().add(new LineTo(0, 0));
        PathTransition transition = new PathTransition();
        transition.setNode(car_4);
        transition.setDuration(Duration.seconds(10 - car4.getSpeed()));
        transition.setPath(path);
        transition.play();
    }

    public void exitGame(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.close();
    }
}
