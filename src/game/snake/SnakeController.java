package game.snake;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeController extends JFrame {

    private Snake snake;
    private Grid board;

    public SnakeController(Snake snake, Grid board) {
        this.snake = snake;
        this.board = board;
        // add grid to frame
        this.add(this.board, BorderLayout.CENTER);

        this.setTitle("Snake");
        this.setSize(500, 500); // or whatever size you need
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // start snake
        Timer timer = new Timer(100, this.board);
        timer.start();
    }

}
