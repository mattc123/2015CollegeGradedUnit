//this class will deal with the navigation of menus in the game

package com.game.GameState;


//imports
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Graphics2D;


public class GameStateManagerV1 {
	

	//create an  arraylist of gamestates
	private ArrayList<GameStateV1> gamestates;
	private int currentState;
	
	//giving values to the different states
	public static final int MENUSTATE = 0;
	public static final int PLAYSTATE = 1;
	public static final int LOADSTATE = 2;
	
	public GameStateManagerV1(){
		
		//creating a new array list
		gamestates = new ArrayList<GameStateV1>();
		
		//adding the states to the array list called gamestates
		gamestates.add(new MenuStateV1());
		gamestates.add(new PlayStateV1());
		gamestates.add(new loadStateV1());
		
		//setting the current state 
		currentState = MENUSTATE;
		
		
		
	}
	//sets the current state i.e. "menustate", "playstate" or "loadstate"
	public void setCurrentState(int i){
		currentState = i;
		
	}
	
	public void update(){
		//cycling through the arraylist to find the current state.
		gamestates.get(currentState).update();
		int rs = gamestates.get(currentState).getRequestState();
		if(rs > 0 && rs != currentState) {
			currentState = rs;
			gamestates.get(currentState).resetRequestState();
		}
		
		
	}//draws the current state to the game window
	public void draw(Graphics2D g){
		gamestates.get(currentState).draw(g);
	}
	
	//input from the keyboard
	public void keyPressed (int k){
		gamestates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k){
		gamestates.get(currentState).KeyReleased(k);
	}
	
	
	//mouse input
	
	//what happens when the mouse is pressed
	public void mousePressed(MouseEvent me) {
		gamestates.get(currentState).mousePressed(me);
	}
	//what happens when the mouse is released
	public void mouseReleased(MouseEvent me) {
		gamestates.get(currentState).mouseReleased(me);
	}
	//what happens when the mouse is moved
	public void mouseMoved(MouseEvent me) {
		gamestates.get(currentState).mouseMoved(me);
	}
	//what happens when the mouse is dragged
	public void mouseDragged(MouseEvent me) {
		gamestates.get(currentState).mouseDragged(me);
	}
	
}
	
	
	