package game.snake;

import java.awt.Point;

public class Cell {

    final static int EMPTY = 0, FOOD = -1, SNAKE = -2, BORDER = -3;
    final int i, j;
    Point Coordinates;
    int type;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
        this.Coordinates = new Point(i * 10, j * 10);
    }
}
