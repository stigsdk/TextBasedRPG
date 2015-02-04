package net.sornsen;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 * Created by Admin on 03-02-2015.
 */
public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH  = 800;
    public static final int HEIGHT = 720;

    private Thread thread;
    private boolean running;

    private BufferedImage image;
    private Graphics2D g2d;

    private int fps = 30;
    private int targetTime = 1000 / fps;

    private TileMap tileMap;

    public GamePanel()
    {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if (thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {
        init();

        long startTime;
        long urdTime;
        long waitTime;

        while (running)
        {
            startTime = System.nanoTime();

            update();
            render();
            draw();

            urdTime  = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - urdTime;

            try{
                Thread.sleep(waitTime);
            }
            catch (Exception ex) {

            }
        }
    }

    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) image.getGraphics();

        tileMap = new TileMap("Maps//Map1.txt", 20);
    }

    private void update() {
        tileMap.update();
    }

    private void render() {
        tileMap.draw(g2d);
    }

    private void draw() {
        Graphics g = getGraphics();
        g.drawImage(image, 0,0, null);

    }
}
