package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.Position;
import javafx.scene.image.ImageView;

public class Sprite {
    ImageView img;

    public ImageView getImg() {
        return img;
    }

    public void updateLocation(Position position) {
        img.setX(position.x() * ImageResource.size);
        img.setY(position.y() * ImageResource.size);
    }
}
