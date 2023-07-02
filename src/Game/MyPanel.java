package Game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	private BufferedImage Bird, background;
	private int Birdh, Birdw, Birdx, Birdy, initialVelocityY;
	private double gravity, currentVelocityY;
	private Timer timer;

	public MyPanel() {

		try {
			Bird = ImageIO.read(new File("picture/bird.png"));

			background = ImageIO.read(new File("picture/background1.png"));
			Birdh = Bird.getHeight();
			Birdw = Bird.getWidth();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Birdx = 0;
		Birdy = 140;
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
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		    
		BufferedImage transparentBird = new BufferedImage(Birdw, Birdh, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = transparentBird.createGraphics();
		g2d.setComposite(AlphaComposite.Clear);
		g2d.fillRect(0, 0, Birdw, Birdh);		
		g2d.setComposite(AlphaComposite.SrcOver);
		g2d.drawImage(Bird, 0, 0, null);
		g2d.dispose();
		g.drawImage(transparentBird, Birdx, Birdy, null);
		


	}

	public Dimension getPreferredSize() {
		return new Dimension();

	}
}
