//this class tells the gamestate manager what the requested state is
// -- what the state the user has selected in the menus

package com.game.GameState;

//imports
import java.awt.Graphics2D;
import java.awt.event.*;

public abstract class GameStateV1 {
	


	protected GameStateManagerV1 gsm;
	
	
	int requestState;
	
	public void resetRequestState() {
		requestState = -1;
	}
	
	
	public int getRequestState() {
		return requestState;
	}
	
	
	
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void KeyReleased(int k);
	public abstract void mousePressed(MouseEvent me);
	public abstract void mouseReleased(MouseEvent me);
	public abstract void mouseMoved(MouseEvent me);
	public abstract void mouseDragged(MouseEvent me);

	
	

}
