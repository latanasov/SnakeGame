package game.snake;

import java.util.LinkedList;

public class Snake {

    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    LinkedList<Cell> snakePartList = new LinkedList<>();
    public Cell head;

    public Snake(Cell initPos) {
        head = initPos;

        snakePartList.add(head);
    }

    public void grow() {
        snakePartList.add(head);
    }

    public void move(Cell nextCell) {
        Cell tail = snakePartList.removeLast();
        tail.type = Cell.EMPTY;

        head = nextCell;
        head.type = head.SNAKE;

        snakePartList.addFirst(head);
        System.out.println(snakePartList);
    }

    public boolean checkSelfCrash(Cell nextCell) {
        for (Cell cell : snakePartList) {
            if (cell == nextCell) {
                return true;
            }
        }

        return false;
    }

    public boolean checkBorderCrash(Cell nextCell) {
        if (nextCell.type == Cell.BORDER) {
            return true;
        }

        return false;
    }

}
