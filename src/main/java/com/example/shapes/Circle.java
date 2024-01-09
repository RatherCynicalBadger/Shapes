package com.example.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Circle extends Shape {

    private final double radius;

    public Circle(double r, Point c) {
        super(c);
        this.radius = r;
        this.figure = new javafx.scene.shape.Circle(this.center.xPosition, this.center.yPosition, this.radius, this.color);
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
