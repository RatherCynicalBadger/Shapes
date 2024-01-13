package com.example.shapes;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ShapeManager {

    private static final double MAX_FIG_SIZE = 40;
    private static final double MIN_FIG_SIZE = 20;
    private static final int MAX_NUMBER_OF_SHAPES = 20;
    public static final ArrayList<Shape> shapes = new ArrayList<Shape>(MAX_NUMBER_OF_SHAPES);
    private final Pane plane;

    public ShapeManager(Pane plane) {
        this.plane = plane;
    }

    /**
     * Adds selected shape with random parameters within boundaries
     *
     * @param sides Number of sides of created figure
     *              0 for circle
     *              3 for triangle
     *              4 for rectangle
     */
    public void addRandomizedShape(int sides) {

        if (shapes.size() == MAX_NUMBER_OF_SHAPES) {
            //dodać popup do programu
            System.out.println("Max shape limit reached.");
        } else {
            Point center = new Point((Math.random() * (1000 - MIN_FIG_SIZE * 2)), 1000 - (Math.random() * (1000 - MIN_FIG_SIZE * 2)));
            switch (sides) {
                case 0:
                    Circle c = new Circle(randomSize(), center);
                    shapes.add(c);
                    this.drawShape(c);
                    break;
                case 3:
                    double length = MIN_FIG_SIZE + (Math.random() * (MAX_FIG_SIZE - MIN_FIG_SIZE));
                    //sin i cos 30 stopni w radianach
                    double sin = Math.sin(0.5235987756) * length;
                    double cos = Math.cos(0.5235987756) * length;
                    Point v1 = new Point(center.xPosition, center.yPosition + length);
                    Point v2 = new Point(center.xPosition + cos, center.yPosition - sin);
                    Point v3 = new Point(center.xPosition - cos, center.yPosition - sin);
                    Triangle t = new Triangle(v1, v2, v3, center);
                    shapes.add(t);
                    this.drawShape(t);
                    System.out.println();
                    break;
                case 4:
                    Rectangle r = new Rectangle(randomSize() * 2, randomSize() * 2, center);
                    shapes.add(r);
                    this.drawShape(r);
                    break;
                default:
                    System.out.println("Wrong number dummy");
            }
        }
    }

    public void drawShape(Shape shape) {
        this.plane.getChildren().add(shape.getFigure());
    }

    private double randomSize() {
        return ((Math.random() * (MAX_FIG_SIZE - MIN_FIG_SIZE)) + MIN_FIG_SIZE);
    }

    public static void checkListForCollision(Shape shape) {
        boolean hit = false;
        for (Shape s : shapes) {
            if (shape.id != s.id) {
                shape.checkCollision(s);
                hit = true;
            }
        }
        if (!hit) {
            shape.noCollision();
        }
    }
}
