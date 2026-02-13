package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.Position;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class View {
    private int width;
    private int height;
    private Pane pane;
    private Scene scene;
    Set<Line[]> squares = new HashSet<>();

    public View(int width, int height) {
        this.pane = new Pane();
        this.scene = new Scene(pane);
        scene.setFill(Color.rgb(241,199,128));
        this.width = width;
        this.height = height;
        drawLines();
    }

    private void drawLines() {
        for (int i = 1; i < width; i++) {
            int x = ImageResource.size*i;
            Line line = new Line(x, 0, x, ImageResource.size*height);
            line.setStroke(Color.GRAY);
            line.getStrokeDashArray().addAll(2d, 5d);
            pane.getChildren().add(line);
        }
        for (int j = 1; j < height; j++) {
            int y = ImageResource.size*j;
            Line line = new Line(0, y, ImageResource.size*width, y);
            line.getStrokeDashArray().addAll(2d, 5d);
            line.setStroke(Color.GREY);
            pane.getChildren().add(line);
        }
    }

    public void draw_case(int x, int y) {
        int x_p = ImageResource.size*x;
        int y_p = ImageResource.size*y;
        Line[] square = new Line[4];
        Line verti = new Line(x_p, y_p, x_p, y_p+ImageResource.size);
        Line hori = new Line(x_p, y_p, x_p+ImageResource.size, y_p);
        Line verti_ = new Line(x_p+ImageResource.size, y_p, x_p+ImageResource.size, y_p+ImageResource.size);
        Line hori_ = new Line(x_p, y_p+ImageResource.size, x_p+ImageResource.size, y_p+ImageResource.size);
        square[0] = hori;
        square[1] = verti;
        square[2] = hori_;
        square[3] = verti_;
        for (int i = 0; i < 4; i++) {
            square[i].setStroke(Color.RED);
            square[i].getStrokeDashArray().addAll(2d, 5d);
            pane.getChildren().add(square[i]);
        }
        squares.add(square);
    }

    public void clear_cases() {
        Iterator<Line[]> it = squares.iterator();
        while (it.hasNext()) {
            Line[] square = it.next();
            for (int i = 0; i < 4; i++)
                pane.getChildren().remove(square[i]);
        }
    }

    public void clear_case(int x, int y) {
        int x_p = x*ImageResource.size;
        int y_p = y*ImageResource.size;
        Iterator<Line[]> it = squares.iterator();
        while (it.hasNext()) {
            Line[] square = it.next();
            if (square[0].getStartX() == x_p && square[1].getStartY() == y_p) {
                for (int i = 0; i < 4; i++) {
                    pane.getChildren().remove(square[i]);
                }
            }
        }
    }

    /* Returns the position of the mouse in the grid */
    public Position getPosition(MouseEvent e) {
        int x = (int) e.getX() / ImageResource.size;
        int y = (int) e.getY() / ImageResource.size;
        return new Position(x, y);
    }

    public Pane getPane() {
        return pane;
    }
}
