package ninemenmorris;

import java.util.ArrayList;

import gamestate.GameState;
import gamestate.GameStateManager;

import javax.swing.JFrame;
import main.Game;

public class Start {
	
	/**
	 * Create a Jframe and add the game to it
	 * @param args
	 */
	public static void main(String[] args) {

		GameStateManager nmm = new GameStateManager();
		nmm.addState(new NMMStartMenu(nmm));
		nmm.addState(new InGameState(nmm));
		nmm.changeState(0);
		
		JFrame frame = new JFrame();
		frame.setContentPane(new Game(nmm,600,400));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
