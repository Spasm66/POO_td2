package fr.ubx.poo.td2.model;

import fr.ubx.poo.td2.Position;

public class Drone extends Vehicle {

    public Drone(String name, double energy, double cost) {
        this.name = name;
        this.position = new Position(0, 0);
        this.energy = energy;
        this.cost = cost;
    }

    @Override
    // TODO
    // Manhattan distance between the robot and the target
    public int distance(Position target) {
        return (int) (Math.sqrt(Math.abs(getPosition().y() - target.y()) + Math.abs(getPosition().x() - target.x())));
    }

    // TODO
    // Calculate the path between the robot and the target to be reached
    @Override
    public Position[] getPathTo(Position target) {
        Position[] path = new Position[1];
        path[0] = new Position(target.x(), target.y());
        return (path);
    }
}
