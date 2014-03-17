package gamestate;


import java.util.ArrayList;

/**
 * Class that is the link between the animator and the 
 * current state the game is in. Kinda like the 
 * object controller in the MVC. It passes the input it gets to the
 * correct state.
 * @author User
 *
 */
public class GameStateManager {
	
	private int currentState;
	private ArrayList<GameState> states = new ArrayList<GameState>();
	
	
	/**
	 * since we have two states, can use 
	 * temp to switch between menu and game
	 * @param gameState
	 */
	public void changeState(int i) {
		
		currentState = i;
		states.get(currentState).init();
		
	}
	
	/**
	 * add  a new state to the list
	 * @param state
	 */
	public void addState(GameState state) {
		
		states.add(state);
		
	}
	

	/**
	 * draw the current state to the buffer
	 * @param g
	 */
	public void draw(java.awt.Graphics2D g) {
		
		states.get(currentState).draw(g);
		
	}

	/**
	 * update the current state
	 */
	public void update() {
		
		states.get(currentState).update();
		
	}
	
	//pass the input to the current state
	
	public void keyPressed(int k) {
		
		states.get(currentState).keyPressed(k);
		
	}
	
	public void keyReleased(int k) {
		
		states.get(currentState).keyReleased(k);

	}
	
	public void mouseClick(int x, int y) {
		
		states.get(currentState).mouseClick(x, y);
		
	}
	
	public void mouseReleased(int b, int i, int j) {
		
		states.get(currentState).mouseReleased(b, i, b);
		
	}
	
	public void mousePressed(int x, int y, int b) {
		
		states.get(currentState).mousePressed(x, y, b);
		
	}

}
