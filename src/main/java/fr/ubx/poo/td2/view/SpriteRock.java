package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.Position;
import javafx.scene.image.ImageView;

public class SpriteRock extends SpriteDecor{
    public SpriteRock(Position pos) {
        img = new ImageView(ImageResource.imageRock);
        updateLocation(pos);
    }
}
