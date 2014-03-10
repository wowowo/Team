package gamestate;

/**
 * Abstraction of what every game state should have.
 * (Specifies the interface GameStateManager will use)
 * @author User
 *
 */
public abstract class GameState implements Drawable{
	
	protected GameStateManager gm;
	
	public GameState(GameStateManager gm) {
		
		this.gm = gm;
		
	}

	public abstract void keyPressed(int k);

	public abstract void keyReleased(int k);

	public abstract void mouseClick(int x, int y);
	
	public abstract void mouseRelease(int b);
	
	public abstract void mousePressed(int x, int y, int b);
	
	public abstract void init();

}
