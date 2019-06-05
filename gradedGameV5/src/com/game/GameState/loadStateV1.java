//this class is the pause menu for the user
//it will display options for the user when they press "escape"

package com.game.GameState;

//imports
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.*;
//import class from other folder
import com.game.Main.gamePanelV5;


public class loadStateV1 extends GameStateV1 {
	
	//an array of strings containing the text for the pause menu
	private String[] LoadOptions = {"RESMUME", "QUIT"};
	
	private int selectedOption;
	
	
	public loadStateV1(){
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
		for(int i = 0; i < LoadOptions.length; i++) {
			if(i == selectedOption) g.setColor(Color.RED);
			else g.setColor(Color.BLACK);
		g.drawString(LoadOptions[i], 300, gamePanelV5.height - 600 + i * 60);		
	}
	}
	
	
	
	
	
	//what happens when you actually select a an option
	private void performSelection() {
		//if the first item in array is selected return to the playstate
		if(selectedOption == 0) {
			requestState = GameStateManagerV1.PLAYSTATE;
			
			//if the second item is selected exit the game
		}if(selectedOption == 1) {
			//EXIT
			System.exit(0);
			
			
				}
	}

	
	
	//menu input with keystrokes 
	public void keyPressed(int k) {
		
		//navigating the menu with Arrow keys or W,S keys
		if (k == KeyEvent.VK_DOWN){
			//if the user pressed down add one to the selected option
			selectedOption++;
			if(selectedOption == LoadOptions.length) selectedOption = 0;
					
		}else if (k == KeyEvent.VK_S){
			selectedOption++;
			if(selectedOption == LoadOptions.length) selectedOption = 0;
		}
		//if the user pressed up take away one from the selected option
		if (k == KeyEvent.VK_UP){
			selectedOption--;
			if(selectedOption == LoadOptions.length) selectedOption = -1;
					
		}else if (k == KeyEvent.VK_W){
			selectedOption--;
			if(selectedOption == LoadOptions.length) selectedOption = -1;
		}
		
			
		//if the user presses enter the run the performSelection Method
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