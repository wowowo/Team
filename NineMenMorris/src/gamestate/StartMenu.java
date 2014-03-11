package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import utility.Background;
/**
 * Initial menu. Draws background
 * @author User
 *
 */
public class StartMenu extends GameState {

	private Background bg;
	private String[] options = {"Start! ", "Exit!"};
	private int currentChoice;
	
	
	public StartMenu(GameStateManager gm) {
		
		super(gm);
		
	}

	
	public void draw(Graphics2D g) {
		
		bg.draw(g);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.YELLOW);
		g.drawString("NMM", 200, 70);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));

		for(int i = 0; i < options.length; i++) {
			
			g.setColor(Color.BLACK);
			
			if(i == currentChoice)
				g.setColor(Color.RED);
			
			g.drawString(options[i], 300, 100 + i * 20);
			
		}

		
	}

	
	public void update() {

		
	}

	@Override
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_UP)
			currentChoice--;
		
		else if(k == KeyEvent.VK_DOWN)
			currentChoice = (currentChoice + 1) % options.length;
		
		else if (k == KeyEvent.VK_ENTER) {
			
			if(currentChoice == 0)
				gm.changeState(new InGameState(gm));
			
		else if (k == KeyEvent.VK_ESCAPE)
			System.exit(0);
		}
		
		
	}

	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public void mouseClick(int x, int y) {
		
	}

	@Override
	public void mouseRelease(int b) {
		
	}

	@Override
	public void mousePressed(int x, int y, int b) {
		
	}

	@Override
	public void init() {
		
		bg = new Background("res/backgrounds/morris_board_100.jpg");

	}

}
