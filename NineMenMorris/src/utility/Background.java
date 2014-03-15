package utility;

import gamestate.Drawable;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Game;

/**
 * A class that loads and strecthes or shrinks an image, so it
 * fits entire windows. Used as background
 * @author User
 *
 */
public class Background implements Drawable{
	
	private BufferedImage bg;
	private int x,y,width,height;
	
	public Background(String s,int w, int h) {
		
		width = w;
		height = h;
		try {
			bg = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Stretch to fit the entire window
		 */
		width = bg.getWidth() + width - bg.getWidth();
		height = bg.getHeight() + height - bg.getHeight();
		
	}
	
	/**
	 * 
	 * move the bg to the right or left
	 */
	public void update() {
		
		x++; y++;
		
	}
	
	/**
	 * draw on the buffer
	 */
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, width, height, null);
		
	}

}