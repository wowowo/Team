package ninemenmorris;

import gamestate.GameStateManager;

import java.awt.event.KeyEvent;

import utility.Background;
import utility.Menu;

public class NMMStartMenu extends Menu{

	public NMMStartMenu(GameStateManager gm) {
		
		super(gm);
		
	}
	
	@Override
	protected void setUpOptions() {
		
		
		options = new String[3];
		options[0] = "Start";
		options[1] = "Load";
		options[2] = "Exit";
		
	}

	@Override
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			
			if(currentChoice < 0)
				currentChoice = options.length - 1;
		}

		else if(k == KeyEvent.VK_DOWN)
			currentChoice = (currentChoice + 1) % options.length;

		else if (k == KeyEvent.VK_ENTER) {

			if(currentChoice == 0)
				gm.changeState(0);
			
			else if (currentChoice == 2)
				System.exit(0);
			
		}	
		
		else if (k == KeyEvent.VK_ESCAPE)
		System.exit(0);
	}

	@Override
	public void init() {
		
		bg = new Background("res/backgrounds/morris_board_100.jpg",600,400);
		
	}




}
