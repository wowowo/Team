package main;

import gamestate.GameStateManager;
import gamestate.StartMenu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The class that handles the drawing, updates and input at the top level.
 * Provides and gets information to a gameState Manager object that is responsible for the lower
 * level stuff.
 * @author User
 *
 */
public class Game extends JPanel implements Runnable, KeyListener, MouseListener {

	/**
	 * Constructor
	 * 
	 * Set the preferred size and request focus
	 */
	public Game() {

		super();
		setPreferredSize(new Dimension(WIDTH , HEIGHT));
		setFocusable(true);
		requestFocus();

	}

	private static final long serialVersionUID = -7600755214008009002L;
	public static final int HEIGHT = 400;
	public static final int WIDTH = 600;

	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private GameStateManager manager;
	private Thread animator;
	private BufferedImage image;
	private Graphics2D g;

	/**
	 * after the component is added create the animator thread,
	 * get all the input events redirected to this class' implementation
	 * start the game
	 */
	public void addNotify() {

		super.addNotify();
		addMouseListener(this);
		addKeyListener(this);
		animator = new Thread(this);
		animator.start();

	}
	
	


	public void stopGame() {

		running = false;

	}

	/**
	 * initialize everything, set the current state to the start menu
	 * while the game is running update and draw
	 * if the game updates in less than 16 milliseconds rest the thread
	 * 16 = 1 second / 60 frames 
	 */
	public void run() {
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		manager = new GameStateManager();
		manager.changeState(new StartMenu(manager));
		
		running = true;

		long startTime;
		long renderTime;

		while (running) {

			startTime = System.currentTimeMillis();

			manager.update();
			manager.draw(g);
			
			Graphics g2 = this.getGraphics();
			g2.drawImage(image, 0, 0, WIDTH , HEIGHT, null);
			g2.dispose();

			renderTime = System.currentTimeMillis() - startTime;

			if (renderTime < 16) {
				try {
					Thread.sleep(16 - renderTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/**
	 * Create a Jframe and add the game to it
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setContentPane(new Game());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// INPUT METHODS
	
	@Override
	public void keyPressed(KeyEvent arg0) {

		manager.keyPressed(arg0.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		manager.keyReleased(arg0.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		manager.mouseClick(e.getX(), e.getY());
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {

		manager.mousePressed(e.getX(), e.getY(), e.getButton());
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {

		manager.mouseReleased(e.getButton());

	}


}