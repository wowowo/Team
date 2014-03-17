package utility;

import gamestate.GameState;
import gamestate.GameStateManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.TileObserver;

import ninemenmorris.InGameState;

import main.Game;

/**
 * Template class for a start menu;
 * Change the default variable values in the init() method;
 * Background has to be specified, otherwise override draw;
 * Have to implement key pressed, to specify functionality;
 * @author User
 *
 */
public abstract class Menu extends GameState {

	protected Background bg;
	
	//title variables
	protected String title = "Default Title";
	protected Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	protected Color titleColor = Color.YELLOW;
	protected int titleT = 200,titleL = 70;
	
	//options variables
	protected String[] options;
	protected int currentChoice;
	protected Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 20);
	protected Color color = Color.BLACK;
	protected Color selectColor = Color.RED;
	protected int optionsT = 300, optionsL = 100, optionsPad = 20;
	
	
	/**
	 * At least one options in the menu is required
	 * @param gm - the game manager responsible for this game state
	 * @param options - the options that the state will display
	 */
	public Menu(GameStateManager gm) {
		
		super(gm);
		setUpOptions();
		
	}

	/**
	 * set the options variable here
	 */
	protected abstract void setUpOptions();

	public void draw(Graphics2D g) {
		
		bg.draw(g);
		
		g.setFont(titleFont);
		g.setColor(titleColor);
		g.drawString(title, titleT, titleL);
		
		g.setFont(font);

		for(int i = 0; i < options.length; i++) {
			
			g.setColor(color);
			
			if(i == currentChoice)
				g.setColor(selectColor);
			
			g.drawString(options[i], optionsT, optionsL + i * optionsPad);
			
		}

		
	}

	public void update() {

		
	}

	/**
	 * specify options behavior here
	 */
	@Override
	public abstract void keyPressed(int k) ;

	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public void mouseClick(int x, int y) {
		
	}

	@Override
	public void mouseReleased(int x, int y, int b) {
		
	}

	@Override
	public void mousePressed(int x, int y, int b) {
		
	}

	/**
	 * specify variable values here
	 */
	@Override
	public abstract void init() ;

}
