package game.snake;

public class Game {

    public static void main(String[] a) {
        Grid myGrid = new Grid(50, 50);
        Snake mySnake = new Snake(myGrid.cells[5][5]);
        myGrid.setSnake(mySnake);
        SnakeController game = new SnakeController(mySnake, myGrid);

    }
}
