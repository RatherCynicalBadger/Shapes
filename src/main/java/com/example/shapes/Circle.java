package com.example.shapes;

import javafx.scene.paint.Color;

public class Circle extends Shape {

    private final double radius;

    public Circle(double r, Point c) {
        super(c);
        this.radius = r;
        this.figure = new javafx.scene.shape.Circle(this.center.xPosition, this.center.yPosition, this.radius, this.color);
        this.figure.setStroke(Color.BLACK);
        this.figure.setStrokeWidth(2);
        this.draggy = new DragController(this);
    }
}
