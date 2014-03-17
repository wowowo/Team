package entities;

import gamestate.Drawable;
import gamestate.GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

import utility.Animation;

public abstract class Entity implements Drawable {
	
	protected ArrayList<Animation> animations = new ArrayList<Animation>();
	protected int currentAnimation;
	protected int x,y,w,h;
	protected GameState gameState;
	
	
	public Entity(GameState gameState) {
		
		this.gameState = gameState;
		
	}
	
	
	
	public void addAnimation(Animation a ) {
		
		animations.add(a);
		
	}
	
	public void startAnimation(int i) {
		
		animations.get(i).start();
		
	}
	
	
	public void draw(Graphics2D g) {
		
		g.drawImage(animations.get(currentAnimation).getFrame(), x, y, null);
		
	}
	

}
