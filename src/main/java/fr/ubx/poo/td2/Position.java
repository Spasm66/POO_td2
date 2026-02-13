package fr.ubx.poo.td2;

public record Position(int x, int y) {
//    public int x() {
//        return y;
//    }
//
//    public int y() {
//        return x;
//    }

//    public void translate(int dx, int dy) {
//        this.x += dx;
//        this.y += dy;
//    }
//    public void translate(int delta) {
//        this.x += delta;
//        this.y += delta;
//    }

    public boolean equals(Position comp) {
        return (comp.y() == this.y() && comp.x() == this.x());
    }
    @Override
    public int hashCode() {
        return (y() * x());
    }
}
