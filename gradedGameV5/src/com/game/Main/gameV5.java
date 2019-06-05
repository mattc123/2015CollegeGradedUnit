//this class sets up the jframe as the game window 
package com.game.Main;



//imports
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class gameV5 {
	
	public static void main(String[] args){
		
		//creates the new cursor
		BufferedImage cursorimg= new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
	
		
		//setting up the window
		JFrame gamewin = new JFrame("Graded Unit Game");
		
		//tells the game to close when the close window is pressed
		gamewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//fills the window with the content of the gamePanelV5 class
		gamewin.setContentPane(new gamePanelV5());
		
		//deals with the size of the window 
		gamewin.pack();
		
		//makes the window actually visible
		gamewin.setVisible(true);
		
		//hides the cursor- unfortunately it hides it for the main menu as well
		gamewin.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursorimg, new Point(0, 0), "Cursor"));
		
		
	}

}
