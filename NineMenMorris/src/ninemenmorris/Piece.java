package ninemenmorris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.Drawable;

/**
 * Class for the basic piece and all the information,
 * it will store
 * @author User
 *
 */
public class Piece implements Drawable {

	private int x,y,w,h;
	
	private Color color;
	
	public Piece(int x, int y, Color color) {
		this.setX(x);
		this.setY(y);
		this.setW(30);
		this.setH(30);
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillOval(x, y, w, h);
		
	}

	@Override
	public void update() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	
	public Rectangle getRect() {
		
		return new Rectangle(x, y, w, h);
	}
	

}
