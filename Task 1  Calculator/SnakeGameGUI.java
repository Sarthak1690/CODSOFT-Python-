import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGameGUI extends JFrame implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 20;
    private static final int GRID_SIZE = 20;

    private LinkedList<Point> snake;
    private Point food;
    private char direction;
    private Timer timer;

    public SnakeGameGUI() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        snake = new LinkedList<>();
        direction = 'R';  // Initially, the snake moves to the right.

        initGame();
        initTimer();
        addKeyListener(this);
        setFocusable(true);
    }

    private void initGame() {
        snake.clear();
        snake.add(new Point(5, 5));  // Initial position of the snake
        generateFood();
    }

    private void initTimer() {
        timer = new Timer(150, this);
        timer.start();
    }

    private void generateFood() {
        Random rand = new Random();
        int x, y;

        do {
            x = rand.nextInt(GRID_SIZE);
            y = rand.nextInt(GRID_SIZE);
        } while (snake.contains(new Point(x, y)));

        food = new Point(x, y);
    }

    private void moveSnake() {
        Point head = snake.getFirst();
        Point newHead;

        switch (direction) {
            case 'U':
                newHead = new Point(head.x, (head.y - 1 + GRID_SIZE) % GRID_SIZE);
                break;
            case 'D':
                newHead = new Point(head.x, (head.y + 1) % GRID_SIZE);
                break;
            case 'L':
                newHead = new Point((head.x - 1 + GRID_SIZE) % GRID_SIZE, head.y);
                break;
            case 'R':
                newHead = new Point((head.x + 1) % GRID_SIZE, head.y);
                break;
            default:
                return;
        }

        if (newHead.equals(food)) {
            snake.addFirst(newHead);
            generateFood();
        } else {
            snake.addFirst(newHead);
            snake.removeLast();
        }

        checkCollision();
    }

    private void checkCollision() {
        Point head = snake.getFirst();

        // Check if the snake collides with itself
        if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
            endGame();
        }

        // Check if the snake collides with the border
        if (head.x < 0 || head.x >= GRID_SIZE || head.y < 0 || head.y >= GRID_SIZE) {
            endGame();
        }
    }

    private void endGame() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your score: " + (snake.size() - 1));
        initGame();
        initTimer();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the snake
        for (Point point : snake) {
            g.setColor(Color.GREEN);
            g.fillRect(point.x * TILE_SIZE, point.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(point.x * TILE_SIZE, point.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGameGUI snakeGame = new SnakeGameGUI();
            snakeGame.setVisible(true);
        });
    }
}
    