
import java.awt.*;

/**
 * Created by henning on 15-04-15.
 */
public class Game {
    private Point position;
    public int radius;
    private boolean movingUp;
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;
    private int speed;      // Player speed in pixels / second

    public Game() {
        this.position = new Point(222, 333);
        this.radius = 20;
        this.movingDown = false;
        this.movingUp = false;
        this.movingLeft = false;
        this.movingRight = false;
        this.speed = 200;
    }

    /**
     * Update the game model based on time passed since last update
     * @param updateTime    Time since last update
     */
    public void update(double updateTime) {
        double dx = 0;
        double dy = 0;
        double movement = this.speed * updateTime * 0.001;       // Convert milliseconds to seconds
        if ((movingLeft || movingRight) && (!movingLeft || !movingRight)) {
            dx = (movingLeft ? -movement : movement);
        }
        if ((movingUp || movingDown) && !(movingUp && movingDown)) {
            dy = (movingUp ? -movement : movement);
        }
        this.position.translate((int) dx, (int) dy);
    }

    public Point getPosition() {
        return position;
    }

    /**
     * Update which directions the player is trying to move in
     */
    public void move(String dir, boolean val) {
        switch (dir){
            case "UP":
                movingUp = val;
                break;
            case "DOWN":
                movingDown = val;
                break;
            case "LEFT":
                movingLeft = val;
                break;
            case "RIGHT":
                movingRight = val;
                break;
        }
    }
}