package fr.ubx.poo.td2.model;

import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.World;

public class Robot extends Vehicle {
    World world;

    public Robot(String name, double energy, double cost, World w) {
        this.name = name;
        this.position = new Position(4, 4);
        this.energy = energy;
        this.cost = cost;
        this.world = w;
    }

    @Override
    // TODO
    // Manhattan distance between the robot and the target
    public int distance(Position target) {
        return (Math.abs(getPosition().y() - target.y()) + Math.abs(getPosition().x() - target.x()));
    }

    // TODO
    @Override
    // Calculate the path between the robot and the target to be reached
    public Position[] getPathTo(Position target) {
        
        Position[] path = new Position[distance(target)];
        int count = 0;
        int startX = getPosition().x();
        int endX =  target.x();
        int stepX = (startX <= endX) ? 1 : -1;
        int startY = getPosition().y();
        int endY =  target.y();
        int stepY = (startY <= endY) ? 1 : -1;
        int x = startX;
        int y = startY;
        while (x != endX && y != endY) {

            x += stepX;
            if (world.tab[y][x] == 1)
                break;
            path[count] = new Position(x, y);
            count++;
            y += stepY;
            if (world.tab[y][x] == 1)
                break;
            path[count] = new Position(x, y);
            count ++;
        }
        if (x != endX && world.tab[y][x] != 1)  {
            x += stepX;
            for (; x != (endX + stepX); x += stepX) {
                if (world.tab[y][x] == 1)
                    break;
                path[count] = new Position(x, y);
                count++;
            }
        }
        else if (y != endY && world.tab[y][x] != 1) {
            y += stepY;
            for (; y != (endY + stepY); y += stepY) {
                if (world.tab[y][x] == 1)
                    break;
                path[count] = new Position(x, y);
                count++;
            }
        }
        return (path);
    }
}
