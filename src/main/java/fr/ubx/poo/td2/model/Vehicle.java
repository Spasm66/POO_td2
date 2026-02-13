package fr.ubx.poo.td2.model;

import fr.ubx.poo.td2.Position;

public abstract class Vehicle {
    double cost;
    String name;
    public Position position;
    public double energy;

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
    public abstract int distance(Position target);

    // TODO
    // Can the robot move to the target position?
    public boolean canMove(Position target) {
        return distance(target) <= range();
    }

    // TODO
    // Actions to perform when the robot moves to the target: update the robot's coordinates, remaining energy, etc.
    public void move(Position target) {
        if (canMove(target)) {
            energy -= distance(target) * cost;
            position = new Position(target.x(),target.y());
        }
        System.out.println("Move completed: " + this);
    }

    // TODO
    // Calculate the path between the robot and the target to be reached
    public abstract Position[] getPathTo(Position target);

    @Override
    public String toString() {
        return (getClass().getSimpleName() + " " + getName() + " : energy:=" + energy);
    }
}
