package com.example.shapes;

import javafx.scene.paint.Color;

public abstract class Shape implements FigureCollision {

    public static int nextId = 0;
    protected int id;
    protected javafx.scene.shape.Shape figure;
    protected Point center;
    protected Color color;
    protected DragController draggy;
    protected boolean isColliding;


    protected Shape(Point c) {
        this.id = nextId;
        nextId++;
        this.center = c;
        //random color
        this.color = Color.color(Math.random(), Math.random(), Math.random());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public javafx.scene.shape.Shape getFigure() {
        return this.figure;
    }

    @Override
    public void checkCollision(Shape shape) {
        if (this.figure.getBoundsInParent().intersects(shape.getFigure().getBoundsInParent()) ) {
            this.setColliding(true);
            shape.setColliding(true);
        } else {
            this.setColliding(false);
            shape.setColliding(false);
        }
    }

    public void collisionReaction() {
        this.figure.setStroke(Color.RED);
        this.figure.setStrokeWidth(4);
        this.figure.setOpacity(0.5);
    }

    public void noCollision() {
        this.figure.setStrokeWidth(2);
        this.figure.setStroke(Color.BLACK);
        this.figure.setOpacity(1);
    }

    public boolean isColliding() {
        return isColliding;
    }
    public void setColliding(boolean colliding) {
        isColliding = colliding;
        if (!colliding) {
            noCollision();
        } else {
            collisionReaction();
        }
    }
}
