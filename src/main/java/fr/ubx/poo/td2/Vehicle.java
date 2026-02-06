package fr.ubx.poo.td2;

public class Vehicle {
    double cost;
    String name;
    Position position;
    double energy;

    public Position getPosition() {
        return (this.position);
    }
    public String getName() {
        return name;
    }

    // TODO
    // Robot's range of action
    int range() {
        return (int)(energy / cost);
    }

    // TODO
    // Manhattan distance between the robot and the target
    public int distance(Position target) {
        return (0);
    }

    // TODO
    // Can the robot move to the target position?
    boolean canMove(Position target) {
        return distance(target) <= range();
    }

    // TODO
    // Actions to perform when the robot moves to the target: update the robot's coordinates, remaining energy, etc.
    void move(Position target) {
        if (canMove(target)) {
            energy -= distance(target) * cost;
            position.translate(target.getX() - position.getX(), target.getY() - position.getY());
        }
        System.out.println("Move completed: " + this);
    }

    // TODO
    // Calculate the path between the robot and the target to be reached
    Position[] getPathTo(Position target) {
        return (null);
    }

    @Override
    public String toString() {
        return (getClass().getSimpleName() + " " + getName() + " : energy:=" + energy);
    }
}
