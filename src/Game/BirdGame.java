package Game;

import java.awt.BorderLayout;

import Game.MyPanel;
import javax.swing.JFrame;


public class BirdGame extends JFrame{
	private MyPanel myPanel;
	
	
	public BirdGame() {
		
		setLayout(new BorderLayout());
		
		myPanel = new MyPanel();
		add(myPanel,BorderLayout.CENTER);
		
		setTitle("BirdGame");
		setSize(600, 480);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

		
	

	public static void main(String[] args) {
		new BirdGame();

	}

}
