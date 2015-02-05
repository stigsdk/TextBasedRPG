package net.sornsen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;

/**
 * Created by Admin on 03-02-2015.
 */
public class TileMap {

    private int x;
    private int y;

    private int tileSize;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;

    private int minX;
    private int minY;
    private int maxX = 0;
    private int maxY = 0;

    public TileMap(String s, int tileSize) {
        this.tileSize = tileSize;

        try {
            BufferedReader br = new BufferedReader(new FileReader(s));

            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());

            map = new int[mapHeight][mapWidth];

            minX = GamePanel.WIDTH - mapWidth * tileSize;
            minY = GamePanel.HEIGHT -  mapHeight * tileSize;

            String delimeters = " ";
            for (int row = 0; row < mapHeight; row++)
            {
                String line = br.readLine();
                String[] tokens = line.split(delimeters);
                for (int col = 0; col < mapWidth; col++)
                {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        }
        catch (Exception ex) {
            Main.WriteText(ex.getMessage());
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public int getColTile(int x) {
        return x / tileSize;
    }

    public int getRowTile(int y) {
        return y / tileSize;
    }

    public int getTile(int row, int col)
    {
        return map[row][col];
    }
    public int getTileSize() {
        return tileSize;
    }
    public void setX(int i) {
        x = i;

        if(x < minX) {
            x = minX;
        }
        if (x > maxX) {
            x = maxX;
        }

    }
    public void setY(int i) {
        y = i;

        if(y < minY) {
            y = minY;
        }
        if (y > maxY) {
            y = maxY;
        }

    }

    public void update() {
    }
    public void draw(Graphics2D g)
    {
        for (int row = 0; row < mapHeight; row++)
        {
            for (int col = 0; col < mapWidth; col++)
            {
                int rc = map[row][col];

                if (rc == 0) {
                    g.setColor(Color.gray);
                }
                if (rc == 1)
                {
                    g.setColor(Color.black);
                }
                if (rc == 2)
                {
                    g.setColor(Color.yellow);
                }
                if (rc == 9)
                {
                    g.setColor(Color.cyan);
                }

                g.fillRect(x + col * tileSize, y + row * tileSize, tileSize, tileSize);
            }
        }
    }
}
