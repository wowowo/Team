package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Class that is the link between the animator and the 
 * current state the game is in. Kinda like the 
 * object controller in the MVC. It passes the input it gets to the
 * correct state.
 * @author User
 *
 */
public class GameStateManager {
	
	private GameState currentState;
	private GameState lastState;
	
	
	/**
	 * since we have two states, can use 
	 * temp to switch between menu and game
	 * @param gameState
	 */
	public void changeState(GameState gameState) {
		
		lastState = currentState;
		currentState = gameState;
		currentState.init();
		
	}
	
	/**
	 * go back to last state
	 */
	public void reverseState() {
		
		GameState temp = lastState;
		lastState = currentState;
		currentState = temp;
		
	}
	

	/**
	 * draw the current state to the buffer
	 * @param g
	 */
	public void draw(java.awt.Graphics2D g) {
		
		currentState.draw(g);
		
	}

	/**
	 * update the current state
	 */
	public void update() {
		
		currentState.update();
		
	}
	
	//pass the input to the current state
	
	public void keyPressed(int k) {
		
		currentState.keyPressed(k);
		
	}
	
	public void keyReleased(int k) {
		
		currentState.keyReleased(k);

	}
	
	public void mouseClick(int x, int y) {
		
		currentState.mouseClick(x, y);
		
	}
	
	public void mouseReleased(int b) {
		
		currentState.mouseRelease(b);
		
	}
	
	public void mousePressed(int x, int y, int b) {
		
		currentState.mousePressed(x, y, b);
		
	}

}
