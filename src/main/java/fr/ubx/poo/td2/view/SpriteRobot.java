package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Robot;
import javafx.scene.image.ImageView;

public class SpriteRobot extends SpriteVehicle {

    public SpriteRobot(Robot robot) {
        vehi = robot;
        img = new ImageView(ImageResource.imageRobot);
        updateLocation(robot.position);
    }
}
