package fr.ubx.poo.td2;

public class Robot {
    final double cost;
    String name;
    Position position;
    double energy;


    public Robot(String name, double energy, double cost) {
        this.name = name;
        this.position = new Position(4, 4);
        this.energy = energy;
        this.cost = cost;
    }

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
        return (Math.abs(getPosition().getX() - target.getX()) + Math.abs(getPosition().getY() - target.getY()));
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
    }

    // TODO
    // Calculate the path between the robot and the target to be reached
    Position[] getPathTo(Position target) {
        Position[] path = new Position[distance(target)];
        int count = 0;
        int startX = getPosition().getX();
        int endX =  target.getX();
        int stepX = (startX <= endX) ? 1 : -1;
        int startY = getPosition().getY();
        int endY =  target.getY();
        int stepY = (startY <= endY) ? 1 : -1;
        int x = startX;
        int y = startY;
        while (x != endX && y != endY) {
            x += stepX;
            path[count] = new Position(x, y);
            count++;
            y += stepY;
            path[count] = new Position(x, y);
            count ++;
        }
        if (x != endX) {
            System.out.println("ok_x");
            x += stepX;
            for (; x != (endX + stepX); x += stepX) {
                path[count] = new Position(x, y);
                count++;
            }
        }
        else if (y != endY) {
            System.out.println("ok_y");
            y += stepY;
            for (; y != (endY + stepY); y += stepY) {
                path[count] = new Position(x, y);
                count++;
            }
        }
        return (path);
    }
}
