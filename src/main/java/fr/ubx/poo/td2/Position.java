package fr.ubx.poo.td2;
import java.util.Random;

public record Position(int x, int y) {


    public boolean equals(Position comp) {
        return (comp.y() == this.y() && comp.x() == this.x());
    }
    @Override
    public int hashCode() {
        return (y() * x());
    }

    static Position random(int width, int height) {
        Random random = new Random();
        int r1 = random.nextInt(width);
        int r2 = random.nextInt(height);
        return new Position(r1, r2);
    }
}
