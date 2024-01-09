package com.example.shapes;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static final double WINDOW_X = 1000;
    public static final double WINDOW_Y = 1000;

    @Override
    public void start(Stage stage) {


        Group root = new Group();
//        root.autosize();
//        root.setAutoSizeChildren(true);
        //nowa scena
        //Scene scene = new Scene(root, WINDOW_X + 250, WINDOW_Y + 50, Color.DARKGRAY);
        Scene scene = new Scene(root, Color.DARKGRAY);
        //podział na płaszczyznę i panel sterowania
        BorderPane borderPane = new BorderPane();
        Pane plane = new Pane();
        VBox controlPanel = new VBox();
        Button button1 = new Button("Add random rectangle");
        Button button2 = new Button("Add random circle");
        Button button3 = new Button("Add random triangle");
        //kształty
        ShapeManager shapeManager = new ShapeManager(plane);
        //tutaj przyciski dodające figury
        initControls(shapeManager, button1, button2, button3);

        controlPanel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        controlPanel.setSpacing(10);
        controlPanel.setBackground(Background.fill(Color.LIGHTGRAY));
        controlPanel.getChildren().addAll(button1, button2, button3);
        controlPanel.autosize();
        plane.setMaxSize(1920, 1080);

        //podziel okno na 2 części
        borderPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        borderPane.autosize();
        borderPane.setPadding(new Insets(10));
        borderPane.setRight(controlPanel);
        borderPane.setLeft(plane);
        BorderPane.setMargin(plane, new Insets(10));
        BorderPane.setMargin(controlPanel, new Insets(10));

        //oś X i Y: rozmiar i co ile jednostek pokazywać etykietę
        NumberAxis xAxis = new NumberAxis(0, 100, 5);
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        //inicjalizacja osi własną metodą i dodanie do sceny
        initAxes(xAxis, yAxis);
        plane.getChildren().addAll(xAxis, yAxis);
        root.getChildren().add(borderPane);


        stage.setTitle("JavaFX Shapes Collision Nonsense");
        stage.setScene(scene);
        stage.show();

    }

    public static void initAxes(NumberAxis xAxis, NumberAxis yAxis) {
        //bez podziałki
        xAxis.setTickMarkVisible(false);
        yAxis.setTickMarkVisible(false);
        xAxis.setMinorTickVisible(false);
        yAxis.setMinorTickVisible(false);
        //rozmiar osi, dopasowany do rozmiaru ekranu
        xAxis.setPrefWidth(WINDOW_X - 10);
        yAxis.setPrefHeight(WINDOW_Y - 10);
        //pozycja osi
        xAxis.setSide(Side.BOTTOM);
        yAxis.setSide(Side.LEFT);
        xAxis.setLayoutY(WINDOW_Y);
        xAxis.layoutYProperty().bind(Bindings.subtract(WINDOW_Y, xAxis.heightProperty()));
        yAxis.layoutXProperty().bind(Bindings.subtract(0, yAxis.widthProperty()));
    }

    public static void initControls(ShapeManager sm, Button b1, Button b2, Button b3) {

        String style = """
                -fx-background-color:\s
                        #090a0c,
                        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),
                        linear-gradient(#20262b, #191d22),
                        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));
                    -fx-background-radius: 5,4,3,5;
                    -fx-background-insets: 0,1,2,0;
                    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );
                    -fx-font-family: "Arial";
                    -fx-text-fill: linear-gradient(white, #d0d0d0);
                    -fx-font-size: 12px;
                    -fx-padding: 10 20 10 20;""";
        EventHandler<ActionEvent> btnRectangle = actionEvent -> sm.addRandomizedShape(4);
        EventHandler<ActionEvent> btnCircle = actionEvent -> sm.addRandomizedShape(0);
        EventHandler<ActionEvent> btnTriangle = actionEvent -> sm.addRandomizedShape(3);
        b1.setOnAction(btnRectangle);
        b2.setOnAction(btnCircle);
        b3.setOnAction(btnTriangle);
        b1.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxWidth(Double.MAX_VALUE);
        b3.setMaxWidth(Double.MAX_VALUE);
        b1.setWrapText(true);
        b2.setWrapText(true);
        b3.setWrapText(true);
        b1.setStyle(style);
        b2.setStyle(style);
        b3.setStyle(style);
    }

    public static void main(String[] args) {
        launch();
    }
}