package com.example.shapes;

import javafx.scene.paint.Color;

public abstract class Shape implements FigureCollision {

    public static int nextId = 0;
    public int id;
    protected javafx.scene.shape.Shape figure;
    protected Point center;
    protected Color color;
    protected DragController draggy;


    public Shape(Point c) {
        this.id = nextId;
        nextId++;
        this.center = c;
        //losowy kolor, bo czemu nie?
        this.color = Color.color(Math.random(), Math.random(), Math.random());
    }

    public javafx.scene.shape.Shape getFigure() {
        return this.figure;
    }
}
