package game.snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Grid extends JPanel implements KeyListener, ActionListener {

    private Snake snake;
    final int NUMBEROFRAWS;
    private boolean gameOver;
    final int NUMBEROFCOL;
    private int direction;
    Cell[][] cells;

    public Grid(int rowCount, int columnCount) {
        NUMBEROFRAWS = rowCount;
        NUMBEROFCOL = columnCount;
        this.direction = snake.DIRECTION_NONE;
        this.initGrid();
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

    }

    private void initGrid() {
        cells = new Cell[NUMBEROFRAWS][NUMBEROFCOL];
        for (int row = 0; row < NUMBEROFRAWS; row++) {
            for (int column = 0; column < NUMBEROFCOL; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
        for (int row = 0; row < NUMBEROFRAWS; row++) {
            cells[row][0].type = Cell.BORDER;
            cells[row][NUMBEROFCOL - 1].type = Cell.BORDER;

        }
        for (int col = 0; col < NUMBEROFCOL; col++) {
            cells[0][col].type = Cell.BORDER;
            cells[NUMBEROFRAWS - 1][col].type = Cell.BORDER;

        }
    }

    public void setSnake(Snake inputSnake) {
        this.snake = inputSnake;
        //Create a food on the same raw as the snake
        this.cells[this.snake.head.i + 20][this.snake.head.j].type = Cell.FOOD;
        //Place food 2
        this.cells[this.snake.head.i + 20][this.snake.head.j + 10].type = Cell.FOOD;
        //Place food 3
        this.cells[this.snake.head.i][this.snake.head.j + 20].type = Cell.FOOD;
        //Place food 4
        this.cells[this.snake.head.i + 5][this.snake.head.j + 30].type = Cell.FOOD;

    }

    public void generateFood() {
        int row = (int) (Math.random() * NUMBEROFRAWS - 1);
        int column = (int) (Math.random() * NUMBEROFCOL - 1);

        cells[row][column].type = Cell.FOOD;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void update() {

        if (!gameOver) {

            if (direction != snake.DIRECTION_NONE) {

                Cell nextCell = getNextCell(snake.head);

                if ((snake.checkSelfCrash(nextCell)) || (snake.checkBorderCrash(nextCell))) {
                    setDirection(snake.DIRECTION_NONE);

                    gameOver = true;
                } else {
                    if (nextCell.type == Cell.FOOD) {

                        snake.grow();
                        this.generateFood();
                    }
                    snake.move(nextCell);

                }
            }
        }
    }

    private Cell getNextCell(Cell currentPosition) {
        int row = currentPosition.i;
        int col = currentPosition.j;

        if (direction == snake.DIRECTION_RIGHT) {
            row++;
        } else if (direction == snake.DIRECTION_LEFT) {
            row--;
        } else if (direction == snake.DIRECTION_UP) {
            col--;
        } else if (direction == snake.DIRECTION_DOWN) {
            col++;
        }

        Cell nextCell = this.cells[row][col];

        return nextCell;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        this.update();
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && (this.direction != snake.DIRECTION_RIGHT)) {
            this.direction = snake.DIRECTION_LEFT;

        }

        if (key == KeyEvent.VK_RIGHT) {
            this.direction = snake.DIRECTION_RIGHT;

        }

        if (key == KeyEvent.VK_UP) {
            this.direction = snake.DIRECTION_UP;

        }

        if (key == KeyEvent.VK_DOWN) {
            this.direction = snake.DIRECTION_DOWN;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (this.direction != snake.DIRECTION_RIGHT)) {
            this.direction = snake.DIRECTION_LEFT;

        }
        if (key == KeyEvent.VK_RIGHT) {
            this.direction = snake.DIRECTION_RIGHT;

        }

        if (key == KeyEvent.VK_UP) {
            this.direction = snake.DIRECTION_UP;

        }

        if (key == KeyEvent.VK_DOWN) {
            this.direction = snake.DIRECTION_DOWN;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (this.direction != snake.DIRECTION_RIGHT)) {
            this.direction = snake.DIRECTION_LEFT;

        }
        if (key == KeyEvent.VK_RIGHT) {
            this.direction = snake.DIRECTION_RIGHT;

        }

        if (key == KeyEvent.VK_UP) {
            this.direction = snake.DIRECTION_UP;

        }

        if (key == KeyEvent.VK_DOWN) {
            this.direction = snake.DIRECTION_DOWN;

        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (int ma = 0; ma < cells.length; ma++) {
            for (int mb = 0; mb < cells[ma].length; mb++) {
                if (cells[ma][mb].type == Cell.SNAKE) {
                    g.fill3DRect(cells[ma][mb].Coordinates.x, cells[ma][mb].Coordinates.y, 20, 20, true);
                }
                if (cells[ma][mb].type == Cell.FOOD) {
                    g.fill3DRect(cells[ma][mb].Coordinates.x, cells[ma][mb].Coordinates.y, 20, 20, true);
                }
                if (cells[ma][mb].type == Cell.BORDER) {
                    g.fill3DRect(cells[ma][mb].Coordinates.x, cells[ma][mb].Coordinates.y, 5, 5, true);
                }

            }
        }

    }

}
