package ninemenmorris;

import java.awt.Graphics2D;
import java.util.ArrayList;


import gamestate.GameState;
import gamestate.GameStateManager;

import utility.Background;

/**
 * Holds information about everytihng in the game :
 * pieces, rows, ...
 * and draws everything
 * @author User
 *
 */
public class InGameState extends GameState {
	
	private Background bg = new Background("res/boards/unnamed.png",400,600);
	private GameState currentGameState;
	private boolean playerOneTurn = false;
	private TurnState playerOne ;
	private TurnState playerTwo;
	
	//not implemented
	private BoardGrid grid = new BoardGrid();
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public InGameState(GameStateManager gm, int w, int h) {
		super(gm);
	}

	/**
	 * draw everything on the screen in the game
	 */
	public void draw(Graphics2D g) {

		bg.draw(g);
	}

	/**
	 * update things such as piece positions,
	 * checking for three in a row ...
	 */
	public void update() {

		
	}
	
	// what to do if key is pressed, or mouse is clicked

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClick(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseRelease(int b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int x, int y, int b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
