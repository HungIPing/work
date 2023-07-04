package Game;

import java.awt.BorderLayout;

import Game.MyPanel;
import Game.MyPillar;
import javax.swing.JFrame;



public class BirdGame extends JFrame{
	private MyPanel myPanel;
	private MyPillar myPillar;

	
	public BirdGame() {
        setLayout(new BorderLayout());

        myPanel = new MyPanel();
        add(myPanel, BorderLayout.CENTER);
        
 //       myPillar = new MyPillar();
 //       add(myPillar,BorderLayout.NORTH);
        
       
		
		setTitle("BirdGame");
		setSize(750, 630);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

		
	

	public static void main(String[] args) {
		new BirdGame();
	

	}

}


