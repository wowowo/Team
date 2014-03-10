package gamestate;

/**
 * Interface that marks an object as
 * one that will be drawn to the screen
 * @author User
 *
 */
public interface Drawable {
	
	public abstract void draw(java.awt.Graphics2D g);
	
	public abstract void update();

}
