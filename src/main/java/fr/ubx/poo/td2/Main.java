package fr.ubx.poo.td2;

import fr.ubx.poo.td2.model.Drone;
import fr.ubx.poo.td2.model.Robot;
import fr.ubx.poo.td2.view.*;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class Main extends Application {

    public World w;
    @Override
    public void start(Stage stage) {
        int l = 4;
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().requestFocus();
        view.getPane().setFocusTraversable(true);
        w = new World(view, 20, 20, 10, 10);
        Robot robot1 = new Robot("Curiosity", 20000, 2, w);
        Robot robot2 = new Robot("Opportunity", 20000, 2, w);
        Drone drone1 = new Drone("Ingenuity", 1000, 1);
        Drone drone2 = new Drone("Perseverance", 500, 2);
        robot1.move(new Position(5, 5));
        robot2.move(new Position(10, 5));
        drone1.move(new Position(11, 0));
        drone2.move(new Position(2, 7));
        SpriteRobot spriteRobot1 = new SpriteRobot(robot1);
        SpriteRobot spriteRobot2 = new SpriteRobot(robot2);
        SpriteDrone spriteDrone1 = new SpriteDrone(drone1);
        SpriteDrone spriteDrone2 = new SpriteDrone(drone2);
        SpriteVehicle[] sprites = new SpriteVehicle[] {spriteRobot1, spriteRobot2, spriteDrone1, spriteDrone2};
        Set<SpriteVehicle> cur_sprites = new HashSet<>();


        // Un seul listener pour la souris
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            boolean isCtrlClick = e.isControlDown();
            if (isCtrlClick) {
                // Sélection
                for (SpriteVehicle s : sprites) {
                    if (s.vehi.getPosition().equals(target)) {
                        System.out.println(s.vehi);
                        if (!cur_sprites.add(s)) {
                            view.clear_case(target.x(), target.y());
                            cur_sprites.remove(s);
                        }
                        else
                            view.draw_case(target.x(), target.y());
                    }
                }
            } else {
                // Déplacement
                for (SpriteVehicle cs : cur_sprites) {
                    if (cs.vehi.getPosition().equals(target)) {}
                    else if (cs.vehi.canMove(target)) {
                        cs.animateMove(target);
                        System.out.println("Moving robot " + cs.vehi.getName() + " power: " + cs.vehi.energy + "\tpos: " + target.y() + "\t" + target.x());
                    }
                    else {
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


