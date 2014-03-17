package ninemenmorris;

import gamestate.GameState;
import gamestate.GameStateManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TurnState extends GameState {
	
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private int startingY;
	private int currentPiece = -1;
	private int x,y;
	private int returnX,returnY;
	private boolean finished;
	private boolean takePiece;
	

	public TurnState(GameStateManager gm, Color color, int y) {
		super(gm);
		
		
		this.startingY = y;
		
		for(int i = 0; i < 9; i++)
			pieces.add(new Piece(5 + i * 35, startingY, color));
	}

	@Override
	public void draw(Graphics2D g) {
		
		for (Piece p : pieces)
			p.draw(g);
		
	}

	@Override
	public void update() {

		
	}

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

		if(currentPiece >= 0) {
			
			pieces.get(currentPiece).setX(x - 10);
			pieces.get(currentPiece).setY(y - 10);

		}
			
	}

	public void mouseReleased(int x, int y,int b) {
		
		
		if(Board.validMove(x,y,returnX,returnY))
			
			if(Board.newMill())
				takePiece = true;
			else {
				finished = true;
				takePiece = false;
			}
		
		else {
			
			pieces.get(currentPiece).setX(returnX);
			pieces.get(currentPiece).setY(returnY);

		}
		
		
		
		currentPiece = -1;
		
	}

	@Override
	public void mousePressed(int x, int y, int b) {
		
		
		Rectangle rect = new Rectangle(x, y, 10, 10);
		for(int i = 0 ; i < pieces.size(); i++)
			if(rect.intersects(pieces.get(i).getRect())) {
				currentPiece = i;
				returnX = pieces.get(i).getX();
				returnY = pieces.get(i).getY();
			}
		
		
	}

	@Override
	public void init() {
		
	}

	public boolean isFinished() {
		return finished;
	}
	
	public void setFinished() {
		finished = true;
	}
	
	public boolean toTake() {
		return takePiece;
	}
	
	public void took() {
		takePiece = true;
	}

	public void removePiece(int i) {
		pieces.remove(i);
	}

	public int pos(int x, int y) {
		
		Rectangle rect = new Rectangle(x, y, 10, 10);
		for(int i = 0 ; i < pieces.size(); i++)
			if(rect.intersects(pieces.get(i).getRect())) {
				return i;
			}
		
		return -1;
	}


}
