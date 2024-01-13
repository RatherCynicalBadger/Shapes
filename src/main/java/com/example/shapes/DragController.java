package com.example.shapes;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DragController {

    private final Shape target;
    private double anchorX;
    private double anchorY;
    private double mouseOffsetX;
    private double mouseOffsetY;
    private EventHandler<MouseEvent> setAnchor;
    private EventHandler<MouseEvent> updatePosition;
    private EventHandler<MouseEvent> commitPosition;
    private boolean cycleStatus = false;


    public DragController(Shape target) {
        this.target = target;
        createHandlers();
        this.target.getFigure().addEventFilter(MouseEvent.MOUSE_PRESSED, setAnchor);
        this.target.getFigure().addEventFilter(MouseEvent.MOUSE_DRAGGED, updatePosition);
        this.target.getFigure().addEventFilter(MouseEvent.MOUSE_RELEASED, commitPosition);
    }

    private void createHandlers() {
        setAnchor = mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                cycleStatus = true;
                anchorX = mouseEvent.getSceneX();
                anchorY = mouseEvent.getSceneY();
                mouseOffsetX = mouseEvent.getX();
                mouseOffsetY = mouseEvent.getY();
            }
            if (mouseEvent.isSecondaryButtonDown()) {
                cycleStatus = false;
                this.target.getFigure().setTranslateX(0);
                this.target.getFigure().setTranslateY(0);
            }
        };
        updatePosition = mouseEvent -> {
            if (cycleStatus) {
                this.target.getFigure().setTranslateX(mouseEvent.getSceneX() - anchorX);
                this.target.getFigure().setTranslateY(mouseEvent.getSceneY() - anchorY);
            }
        };
        commitPosition = mouseEvent -> {
            if (cycleStatus) {
                this.target.getFigure().setLayoutX(mouseEvent.getSceneX() - mouseOffsetX);
                this.target.getFigure().setLayoutY(mouseEvent.getSceneY() - mouseOffsetY);

                this.target.getFigure().setTranslateX(0);
                this.target.getFigure().setTranslateY(0);

                ShapeManager.checkListForCollision(this.target);
            }
        };
    }
}
