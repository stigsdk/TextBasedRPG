package net.sornsen;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 * Created by Admin on 03-02-2015.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH  = 800;
    public static final int HEIGHT = 820;

    private Thread thread;
    public static boolean running;

    private BufferedImage image;
    private Graphics2D g2d;

    private int fps = 30;
    private int targetTime = 1000 / fps;

    private TileMap tileMap;
    private PlayerTile playerTile;

    public GamePanel()
    {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        this.addKeyListener(this);

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

        tileMap = new TileMap("C:\\Users\\Admin\\OneDrive\\Documents\\Java Projects\\TextbasedRPG\\src\\net\\sornsen\\Maps\\Map1.txt", 50);
        playerTile = new PlayerTile(tileMap);
    }

    private void update() {
        tileMap.update();
        playerTile.update();
    }

    private void render() {
        tileMap.draw(g2d);
        playerTile.draw(g2d);
    }

    private void draw() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);

    }

    @Override
    public void keyTyped(KeyEvent key) {}

    @Override
    public void keyPressed(KeyEvent key) {

        int code = key.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            playerTile.setLeft(true);
        }
        if (code == KeyEvent.VK_RIGHT) {
            playerTile.setRight(true);
        }

        if (code == KeyEvent.VK_DOWN) {
            playerTile.setDown(true);
        }

        if (code == KeyEvent.VK_UP) {
            playerTile.setUp(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {

        int code = key.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            playerTile.setLeft(false);
        }
        if (code == KeyEvent.VK_RIGHT) {
            playerTile.setRight(false);
        }

        if (code == KeyEvent.VK_DOWN) {
            playerTile.setDown(false);
        }

        if (code == KeyEvent.VK_UP) {
            playerTile.setUp(false);
        }
    }

}
