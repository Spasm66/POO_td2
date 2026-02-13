package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.model.Vehicle;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class SpriteVehicle extends Sprite {
    public Vehicle vehi;

    public void animateMove(Position target) {
        // Make the path movement
        Position[] positionPath = vehi.getPathTo(target);

        if (positionPath == null) {
            updateLocation(target);
            vehi.move(target);
        } else {
            Path path = new Path();

            path.getElements().add(new MoveTo(vehi.position.x() * ImageResource.size + ImageResource.size / 2,
                    vehi.position.y() * ImageResource.size + ImageResource.size / 2));
            for (Position pos : positionPath) {
                path.getElements().add(new LineTo(pos.x() * ImageResource.size + ImageResource.size / 2, pos.y() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(300 * vehi.distance(target)));
            ptr.setPath(path);
            ptr.setNode(getImg());

            ptr.setOnFinished(e -> {
                vehi.move(target);
            });
            ptr.play();
        }
    }
}
