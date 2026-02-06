package fr.ubx.poo.td2;

public class Position {
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int x;
    public int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void translate(int delta) {
        this.x += delta;
        this.y += delta;
    }

    public boolean equals(Position comp) {
        return (comp.getX() == this.getX() && comp.getY() == this.getY());
    }
    @Override
    public int hashCode() {
        return (getX() * getY());
    }
}
