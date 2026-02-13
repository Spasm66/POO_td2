package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.Position;
import javafx.scene.image.ImageView;

public class SpriteDust extends SpriteDecor {
    public SpriteDust(Position pos) {
        img = new ImageView(ImageResource.imageDust);
        updateLocation(pos);
    }
}
