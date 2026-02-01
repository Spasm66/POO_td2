package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Create the robot curiosity
        Robot robot = new Robot("curiosity", 200, 2);
        robot.getPosition().translate(-4);
        SpriteRobot spriteRobot = new SpriteRobot(robot);

        // Display the window
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            if (robot.canMove(target)) {
                spriteRobot.animateMove(target);
                System.out.println("Moving robot " + robot.getName() + " power: " + robot.energy + "\tpos: " + target.getX() + "\t" + target.getY());
            } else {
                System.out.println("Can not move robot " + robot.getName());
            }
        });

        view.getPane().getChildren().addAll(spriteRobot.getImg());

    }

    public static void main(String[] args) { launch(); }
}