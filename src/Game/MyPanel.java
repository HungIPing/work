package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel implements ActionListener {
    private BufferedImage Bird, background;
    private int Birdh, Birdw, Birdx, Birdy, initialVelocityY;
    private double gravity, currentVelocityY;
    private Timer timer;
    
    

    public MyPanel() {

        try {
            BufferedImage originalBird = ImageIO.read(new File("picture/bird.png"));

            int newWidth = 100;
            int newHeight = 100;

            Bird = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = Bird.createGraphics();
            g2d.drawImage(originalBird, 0, 0, newWidth, newHeight, null);
            g2d.dispose();

            background = ImageIO.read(new File("picture/background1.png"));
            Birdh = Bird.getHeight();
            Birdw = Bird.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Birdx = 250;
        Birdy = 120;
        initialVelocityY = -2;
        gravity = 0.08;
        currentVelocityY = 0.1;

        timer = new Timer(10, this);
        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentVelocityY = initialVelocityY;
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Birdy += currentVelocityY;
        currentVelocityY += gravity;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(Bird, Birdx, Birdy, null);
    }

    public Dimension getPreferredSize() {
        return new Dimension();
    }
}