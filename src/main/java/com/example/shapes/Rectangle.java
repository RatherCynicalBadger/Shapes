package com.example.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rectangle extends Shape {

    private final double width;
    private final double height;


    public Rectangle(double width, double height, Point c) {
        super(c);
        this.width = width;
        this.height = height;
        this.figure = new javafx.scene.shape.Rectangle(this.center.xPosition, this.center.yPosition, this.width, this.height);
        this.figure.setFill(this.color);
        this.figure.setStroke(Color.BLACK);
        this.figure.setStrokeWidth(2);
    }

    @Override
    public ArrayList<Shape> checkCollision(Shape shape) {

        return null;
    }

    @Override
    protected void draw(Pane plane) {
        plane.getChildren().add(this.figure);
    }
}
