package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        int l = 4;
        Line square;
        square = null;
        Robot robot1 = new Robot("Curiosity", 20000, 2);
        Robot robot2 = new Robot("Opportunity", 20000, 2);
        Drone drone1 = new Drone("Ingenuity", 1000, 1);
        Drone drone2 = new Drone("Perseverance", 500, 2);
        robot1.getPosition().translate(-4);
        robot2.getPosition().translate(4);
        drone2.getPosition().translate(8, 1);
        SpriteRobot spriteRobot1 = new SpriteRobot(robot1);
        SpriteRobot spriteRobot2 = new SpriteRobot(robot2);
        SpriteDrone spriteDrone1 = new SpriteDrone(drone1);
        SpriteDrone spriteDrone2 = new SpriteDrone(drone2);
        Sprite[] sprites = new Sprite[] {spriteRobot1, spriteRobot2, spriteDrone1, spriteDrone2};
        Set<Sprite> cur_sprites = new HashSet<>();

        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().requestFocus();
        view.getPane().setFocusTraversable(true);



        // Un seul listener pour la souris
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            boolean isCtrlClick = e.isControlDown();
            if (isCtrlClick) {
                // Sélection
                for (Sprite s : sprites) {
                    if (s.vehi.getPosition().equals(target)) {
                        System.out.println(s.vehi);
                        if (!cur_sprites.add(s)) {
                            view.clear_case(target.x, target.y);
                            cur_sprites.remove(s);
                        }
                        else
                            view.draw_case(target.x, target.y);
                    }
                }
            } else {
                // Déplacement
                for (Sprite cs : cur_sprites) {
                    if (cs.vehi.canMove(target)) {
                        cs.animateMove(target);
                        System.out.println("Moving robot " + cs.vehi.getName() + " power: " + cs.vehi.energy + "\tpos: " + target.getX() + "\t" + target.getY());
                    } else {
                        System.out.println("Can not move robot " + cs.vehi.getName());
                    }
                }
                cur_sprites.clear();
                view.clear_cases();
            }
        });

        for (int i = 0; i < l; i++)
            view.getPane().getChildren().addAll(sprites[i].getImg());
    }

    public static void main(String[] args) { launch(); }
}


