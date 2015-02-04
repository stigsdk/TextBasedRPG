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

    public TileMap(String s, int tileSize) {
        this.tileSize = tileSize;

        try {
            BufferedReader br = new BufferedReader(new FileReader(s));

            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());

            map = new int[mapHeight][mapWidth];

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
