package com.example.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class Triangle extends Shape {

    public Triangle(Point v1, Point v2, Point v3, Point c) {
        super(c);
        this.figure = new Polygon(v1.xPosition, v1.yPosition,
                v2.xPosition, v2.yPosition,
                v3.xPosition, v3.yPosition);
        this.figure.setFill(this.color);
        this.figure.setRotate(Math.random() * 360);
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
