package fr.ubx.poo.td2;

public class Robot extends Vehicle {

    public Robot(String name, double energy, double cost) {
        this.name = name;
        this.position = new Position(4, 4);
        this.energy = energy;
        this.cost = cost;
    }

    @Override
    // TODO
    // Manhattan distance between the robot and the target
    public int distance(Position target) {
        return (Math.abs(getPosition().getX() - target.getX()) + Math.abs(getPosition().getY() - target.getY()));
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
            x += stepX;
            for (; x != (endX + stepX); x += stepX) {
                path[count] = new Position(x, y);
                count++;
            }
        }
        else if (y != endY) {
            y += stepY;
            for (; y != (endY + stepY); y += stepY) {
                path[count] = new Position(x, y);
                count++;
            }
        }
        return (path);
    }
}
