package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Create the robot curiosity
        Robot robot1 = new Robot("Curiosity", 20000, 2);
        Robot robot2 = new Robot("Opportunity", 20000, 2);
        Drone drone = new Drone("Ingenuity", 1000, 1);
        robot1.getPosition().translate(-4);
        robot2.getPosition().translate(4);
        SpriteRobot spriteRobot1 = new SpriteRobot(robot1);
        SpriteRobot spriteRobot2 = new SpriteRobot(robot2);
        SpriteDrone spriteDrone = new SpriteDrone(drone);
        Vehicle[] vehicles = new Vehicle[] {robot1, robot2, drone};
        Sprite[] sprites = new Sprite[] {spriteRobot1, spriteRobot2, spriteDrone};

        // Display the window
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for (int i = 0; i < 3; i++) {
                if (vehicles[i].canMove(target)) {
                    sprites[i].animateMove(target);
                    System.out.println("Moving robot " + vehicles[i].getName() + " power: " + vehicles[i].energy + "\tpos: " + target.getX() + "\t" + target.getY());
                } else {
                    System.out.println("Can not move robot " + vehicles[i].getName());
                }
            }
        });
        for (int i = 0; i < 3; i++)
            view.getPane().getChildren().addAll(sprites[i].getImg());

    }

    public static void main(String[] args) { launch(); }
}