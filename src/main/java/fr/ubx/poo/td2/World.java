package fr.ubx.poo.td2;

import fr.ubx.poo.td2.view.DecorFactory;
import fr.ubx.poo.td2.view.View;

public class World {
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;
    public int[][] tab;

    public World(View v,int width, int height, int percentageRock, int percentageDust) {
        tab = new int[height][];
        for (int i = 0; i< height; i++){
            int[] row =  new int[width];
            for (int j = 0; j < width; j++) {
                row[j] = EMPTY;
            }
            tab[i] = row;
        }
        int nb_case = width * height;
        int nb_rock = (int) ((nb_case * percentageRock) / 100);
        int i = 0;
        while (i < nb_rock) {
            Position pos = Position.random(width, height);
            if (tab[pos.y()][pos.x()] == EMPTY) {
                tab[pos.y()][pos.x()] = ROCK;
                v.getPane().getChildren().addAll(DecorFactory.create(pos, ROCK).getImg());
                i++;
            }
        }
        int nb_dust = (nb_case * percentageDust) / 100;
        i = 0;
        while (i < nb_dust) {
            Position pos = Position.random(width, height);
            if (tab[pos.y()][pos.x()] == EMPTY) {
                tab[pos.y()][pos.x()] = DUST;
                v.getPane().getChildren().addAll(DecorFactory.create(pos, DUST).getImg());
                i++;
            }
        }
    }
    public int get(Position position) {
        return (tab[position.y()][position.x()]);
    }
    public void set(Position position, int kind) {
        tab[position.y()][position.y()] = kind;
    }
}
