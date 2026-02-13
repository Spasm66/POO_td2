package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Drone;
import javafx.scene.image.ImageView;

public class SpriteDrone extends SpriteVehicle {

    public SpriteDrone(Drone drone) {
        vehi = drone;
        img = new ImageView(ImageResource.imageDrone);
        updateLocation(drone.position);
    }
}
