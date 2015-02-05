package net.sornsen;

import java.awt.*;
import java.util.Random;

/**
 * Created by Admin on 04-02-2015.
 */
public class PlayerTile {
    private double x;
    private double y;
    private double dx;
    private double dy;

    private int width;
    private int height;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private double moveSpeed;
    private double maxSpeed;
    private double stopSpeed;

    private TileMap tileMap;

    private boolean topLeft;
    private boolean topRight;
    private boolean bottomLeft;
    private boolean bottomRight;
    private Player player = new Player("Stig", 100, 1);

    public PlayerTile(TileMap tm)
    {
        tileMap = tm;
        x = 170;
        y = 660;
        width = 40;
        height = 40;

        moveSpeed = 1.5;
        maxSpeed = 3.0;
        stopSpeed = 0.1;
    }

    public void setLeft(boolean b) {left = b;}
    public void setRight(boolean b) {right = b;}
    public void setUp(boolean b) {up = b;}
    public void setDown(boolean b) {down = b;}

    private void calculateCorners(double x, double y)
    {
        int leftTile = tileMap.getColTile((int) (x - width / 2));
        int rightTile = tileMap.getColTile((int) (x + width / 2) -1);
        int topTile = tileMap.getRowTile((int) (y - height / 2));
        int bottomTile = tileMap.getRowTile((int) (y + height / 2) -1);
        topLeft = tileMap.getTile(topTile, leftTile) == 0;
        topRight = tileMap.getTile(topTile, rightTile) == 0;
        bottomLeft = tileMap.getTile(bottomTile, leftTile) == 0;
        bottomRight = tileMap.getTile(bottomTile, rightTile) == 0;

    }
    public void update()
    {
        // determine next position
        if (left)
        {
            dx -= moveSpeed;
            if (dx < -maxSpeed)
            {
                dx = -maxSpeed;
            }
        }
        else if(right) {
            dx += moveSpeed;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        }
        else {
            if (dx > 0)
            {
                dx -= stopSpeed;
                if (dx < 0) {
                    dx = 0;
                }
            }
            else if (dx <0 ) {
                dx += stopSpeed;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }

        if (up)
        {
            dy -= moveSpeed;
            if (dy < -maxSpeed)
            {
                dy = -maxSpeed;
            }
        }
        else if(down) {
            dy += moveSpeed;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        }
        else {
            if (dy > 0)
            {
                dy -= stopSpeed;
                if (dy < 0) {
                    dy = 0;
                }
            }
            else if (dy <0 ) {
                dy += stopSpeed;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }

        // battle generation
        if (left || right || up || down)
        {
            // monster encounter generation
            Random rand1 = new Random();
            int randNbr1 = rand1.nextInt(900) + 1;
            if (randNbr1 < 5)
            {
                GamePanel.running = false;

                int enemyLevel = player.GetLevel();

                // auto generate monster
                Enemy mob1 = new Enemy("Zombie", 10, 1);


                Battle battle1 = new Battle(player, mob1);
                if (player.GetHealth() > 0) {
                    GamePanel.running = true;
                }
            }
            Random rand2 = new Random();
            int randNbr2 = rand1.nextInt(300) + 1;
            if (randNbr2 < 5)
            {
                player.Heal();
            }

        }

        // check collisions

        int currCol = tileMap.getColTile((int) x);
        int currRow = tileMap.getRowTile((int) y);

        double tox = x + dx;
        double toy = y + dy;

        double tempx = x;
        double tempy = y;

        calculateCorners(x, toy);
        if (dy < 0) {
            if(topLeft || topRight) {
                dy = 0;
                tempy = currRow * tileMap.getTileSize() + height / 2;
            }
            else {
                tempy += dy;
            }
        }
        if (dy > 0) {
            if (bottomLeft || bottomRight) {
                dy = 0;
                tempy = (currRow + 1) * tileMap.getTileSize() - height / 2;
            }
            else {
                tempy += dy;
            }
        }
        calculateCorners(tox, y);

        if (dx < 0) {
            if (topLeft || bottomLeft) {
                dx = 0;
                tempx = currCol * tileMap.getTileSize() + width / 2;
            }
            else {
                tempx += dx;
            }
        }
        if (dx > 0) {
            if (topRight || bottomRight) {
                dx = 0;
                tempx = (currCol +1 ) * tileMap.getTileSize() - width / 2;
            }
            else {
                tempx += dx;
            }
        }

        x = tempx;
        y = tempy;

        // move the map
        tileMap.setX((int) (GamePanel.WIDTH / 2 - x));
        tileMap.setY((int) (GamePanel.HEIGHT / 2 - y));
    }

    public void draw(Graphics2D g)
    {
        int tx = tileMap.getX();
        int ty = tileMap.getY();

        g.setColor(Color.RED);
        g.fillRect(
                (int) (tx + x - width / 2),
                (int) (ty + y - height / 2),
                width,
                height
        );
    }
}
