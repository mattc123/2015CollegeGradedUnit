//this is the first screen the user will see
//it will allow the user to either quit the game or continue to the playstate (new game)

package com.game.GameState;

//imports
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;

//import class from different folder
import com.game.Main.gamePanelV5;


public class MenuStateV1 extends GameStateV1 {
	

	//an array of strings containing the text for the main menu
	private String[] menuOptions = {"New Game", "Quit"};
	
	private int selectedOption;
	
	
	public MenuStateV1(){
		//set the default selected option
		selectedOption = 0;
		
	}

		
	
	
	public void update() {}	
	public void draw(Graphics2D g) {
		
	
		
		//drawing the background and setting the size of the screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gamePanelV5.width, gamePanelV5.height);
		
		//cycling through the string array and drawing the items
		//setting the font,colour and the position of the array items 
		g.setFont(new Font("Arial", Font.PLAIN, 60));
		for(int i = 0; i < menuOptions.length; i++) {
			if(i == selectedOption) g.setColor(Color.RED);
			else g.setColor(Color.BLACK);
		g.drawString(menuOptions[i], 300, gamePanelV5.height - 600 + i * 60);		
	}
	}
	
	
	
	
	
	//what happens when you actually select a an option
	private void performSelection() {
		if(selectedOption == 0) {
			// new game
			requestState = GameStateManagerV1.PLAYSTATE;
		}
		if(selectedOption == 1) {
			System.exit(0);
		}
	}

	

	public void keyPressed(int k) {
		
		//navigating the menu with Arrow keys or W,S keys
		//if the user pressed down add one to the selected option
		if (k == KeyEvent.VK_DOWN){
			selectedOption++;
			if(selectedOption == menuOptions.length) selectedOption = 0;
					
		}else if (k == KeyEvent.VK_S){
			selectedOption++;
			if(selectedOption == menuOptions.length) selectedOption = 0;
		}
		//if the user pressed up take away one from the selected option
		
		if (k == KeyEvent.VK_UP){
			selectedOption--;
			if(selectedOption == menuOptions.length) selectedOption = -1;
					
		}else if (k == KeyEvent.VK_W){
			selectedOption--;
			if(selectedOption == menuOptions.length) selectedOption = -1;
		}
		
			
		//if the user presses enter user will be taken to the gamestate the selected item was on
		if (k == KeyEvent.VK_ENTER){
			performSelection();
			
		}
	}

	public void KeyReleased(int k) {}

	//mouse input - mouse has been removed from the menu's
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
	public void mouseMoved(MouseEvent me) {}
	public void mouseDragged(MouseEvent me) {}


}
