//this class will call most of the other classes to actually run the game
//this is where the whole game is brought together

package com.game.GameState;

//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

//import classes from different folders
import com.game.Main.gamePanelV5;
import com.game.MovingObjects.BoxV1;
import com.game.MovingObjects.EnemyV1;
import com.game.MovingObjects.PlayerV5;
import com.game.TileMap.TileMapV5;

public class PlayStateV1 extends GameStateV1{
	
	
	//mouse locations
	private int mx = -100;
	private int my = -100;
	
	
	//player attributes
	private boolean playerdead = true;
	private int playerhealth = 10;
	
	
	//enemy attributes
	private boolean edead = true;
	private boolean edead2 = true;
	private boolean edead3 = true;
	private boolean edead4 = true;
	
	private int ehealth = 10;
	private int ehealth2 = 10;
	private int ehealth3= 10;
	private int ehealth4 = 10;
	
	
	
	private PlayerV5 player;
	private TileMapV5 TileMapV5;

	
	
	
	//enemies
	private EnemyV1 enemy;
	private EnemyV1 enemy2;
	private EnemyV1 enemy3;
	private EnemyV1 enemy4;
	
	
	//boxes
	private BoxV1 crate;
	private BoxV1 crate2;
	private BoxV1 crate3;
	private BoxV1 crate4;
	
	
	//if a level is complete change this to true
	private boolean comp1 = false;
	private boolean comp2 = false;
	private boolean comp3 = false;
	private boolean comp4 = false;
	private boolean comp5 = false;
	
	//booleans to make sure the boxes are in position
	private boolean b1in = false;
	private boolean b2in = false;
	private boolean b3in = false;
	private boolean b4in = false;
	private boolean in = false;

	
	
	//method for telling if a level is complete
	private  boolean level1 = true;
	private  boolean level2 = true;
	private  boolean level3 = true;
	private  boolean level4 = true;
	private  boolean level5 = true;
	
	
	private boolean firing;
		
	
	public PlayStateV1(){
		
		
		
		//load the first level
		//level 1 = true anyway, but it needs to be set to false later for level 2 to load.
		if (level1 = true){
		level1();


		}

	}


	public void update() {
		
		
		
		//updating the enemies position
		enemy.update();
		enemy2.update();
		enemy3.update();
		enemy4.update();
		
		//updating the crates position
		crate.update();
		crate2.update();
		crate3.update();
		crate4.update();
		
		//update the player position
		player.update();
		
		//x and y coordinates of the player
		int px = (int) player.getx();
		int py = (int) player.gety();
		
		
		
		/////ENEMY COORDINATES//////
		
		//first enemy x and y coordinates 
		int ex = (int) enemy.getx();
		int ey = (int) enemy.gety();
		
		//second enemy x and y coordinates 
		int ex2 = (int) enemy2.getx();
		int ey2 = (int) enemy2.gety();
		
		//third enemy x and y coordinates 
		int ex3 = (int) enemy3.getx();
		int ey3 = (int) enemy3.gety();
		
		//fourth enemy x and y coordinates 
		int ex4 = (int) enemy4.getx();
		int ey4 = (int) enemy4.gety();
		
		
			
		///////BOX COORDINATES///////
		
		//x and y coordinates of the first box
		int bx = (int) crate.getx();
		int by = (int) crate.gety();
		
		//x and y coordinates of the second box
		int bx2 = (int) crate2.getx();
		int by2 = (int) crate2.gety();
		
		//x and y coordinates of the third box
		int bx3 = (int) crate3.getx();
		int by3 = (int) crate3.gety();
		
		//x and y coordinates of the fourth box
		int bx4 = (int) crate4.getx();
		int by4 = (int) crate4.gety();
	
	
		////////ENEMY EDGES///////////
		
		//finding the edges of the first enemy
		int el = ex - 22 / 2;
		int er = ex + 22 / 2;
		int et = ey - 22 / 2;
		int eb = ey + 22 / 2;
		
		//finding the edges of the second enemy
		int el2 = ex2 - 22 / 2;
		int er2 = ex2 + 22 / 2;
		int et2 = ey2 - 22 / 2;
		int eb2 = ey2 + 22 / 2;
		
		//finding the edges of the third enemy
		int el3 = ex3 - 22 / 2;
		int er3 = ex3 + 22 / 2;
		int et3 = ey3 - 22 / 2;
		int eb3 = ey3 + 22 / 2;
		
		//finding the edges of the fourth enemy
		int el4 = ex4 - 22 / 2;
		int er4 = ex4 + 22 / 2;
		int et4 = ey4 - 22 / 2;
		int eb4 = ey4 + 22 / 2;
		
		
		
		///////////BOX EDGES///////////
		
		
		//finding the edges of the first box
		int bl = bx - 22 / 2;
		int br = bx + 22 / 2;
		int bt = by - 22 / 2;
		int bb = by + 22 / 2;
		
		//finding the edges of the second box
		int bl2 = bx2 - 22 / 2;
		int br2 = bx2 + 22 / 2;
		int bt2 = by2 - 22 / 2;
		int bb2 = by2 + 22 / 2;
		
		//finding the edges of the third box
		int bl3 = bx3 - 22 / 2;
		int br3 = bx3 + 22 / 2;
		int bt3 = by3 - 22 / 2;
		int bb3 = by3+ 22 / 2;
		
		//finding the edges of the fourth box
		int bl4 = bx4 - 22 / 2;
		int br4 = bx4 + 22 / 2;
		int bt4 = by4 - 22 / 2;
		int bb4 = by4 + 22 / 2;

		
		//when the mouse is in the enemy and the player is shooting take health away
		//enemy 1
		if(mx >= el && mx <= er && my >= et && my <= eb && firing == true) {
		ehealth = ehealth - 5;
		if (ehealth == 0){
			edead = false;

			
		}		
		}
		
		//enemy 2
		if(mx >= el2 && mx <= er2 && my >= et2 && my <= eb2 && firing == true) {
		ehealth2 = ehealth2 - 5;
		if (ehealth2 == 0){
			edead2 = false;

			
		}		
		}
		
		//enemy 3
		if(mx >= el3 && mx <= er3 && my >= et3 && my <= eb3 && firing == true) {
		ehealth3 = ehealth3 - 5;
		if (ehealth3 == 0){
			edead3 = false;

		}		
		}
		
		//enemy 4
		if(mx >= el4 && mx <= er4 && my >= et4 && my <= eb4 && firing == true) {
		ehealth4 = ehealth4 - 5;
		if (ehealth4 == 0){
			edead4 = false;

		}		
		}
		
		//when the player is inside the enemy take 2 points away from the player health 
		//until the player has no health then set playerdead to false
		//when the player is in enemy 1
		if(px >= el && px <= er && py >= et && py <= eb) {
		playerhealth = playerhealth - 2;
		if(playerhealth == 0){
			playerdead = false;
			
		}
		}
		//when the player is in enemy 2
		if(px >= el2 && px <= er2 && py >= et2 && py <= eb2) {
		playerhealth = playerhealth - 2;
		if(playerhealth == 0){
			playerdead = false;
			
		}
		}
		//when the player is in enemy 3
		if(px >= el3 && px <= er3 && py >= et3 && py <= eb3) {
		playerhealth = playerhealth - 2;
		if(playerhealth == 0){
			playerdead = false;
			
		}
		}
		//when the player is in enemy 4
		if(px >= el4 && px <= er4 && py >= et4 && py <= eb4) {
		playerhealth = playerhealth - 2;
			if(playerhealth == 0){
			playerdead = false;
			
		}
		}
		

		//if the player is inside the box
		//move the box in the opposite direction that the player entered into it		
		//moving the first box in all directions
		if(px >= bl && px <= br && py >= bt && py <= bb) {
			if (px - 5 <= bl){	
				crate.setRight(true);
								
								
			}else if (px + 5 >= br){
				crate.setLeft(true);
			
			} else if (py - 5 <= bt){
				crate.setDown(true);
				
			
			}else if (py + 5 >= bb ){
				crate.setUp(true);
			
				
			}
			
		}
		
		//moving the second box in all directions
		if(px >= bl2 && px <= br2 && py >= bt2 && py <= bb2) {
			if (px - 5 <= bl2){	
				crate2.setRight(true);
				
						
			}else if (px + 5 >= br2){
				crate2.setLeft(true);
			

			} else if (py - 5 <= bt2 ){
				crate2.setDown(true);
			
				
			}else if (py + 5 >= bb2 ){
				crate2.setUp(true);
			

			}
			
		}
		
		//moving the third box in all directions
		if(px >= bl3 && px <= br3 && py >= bt3 && py <= bb3) {
			if (px - 5 <= bl3){	
				crate3.setRight(true);
				
				
			}else if (px + 5 >= br3){
				crate3.setLeft(true);
			

			} else if (py - 5 <= bt3 ){
				crate3.setDown(true);
			
				
			}else if (py + 5 >= bb3 ){
				crate3.setUp(true);
		
				
			}
			
		}
		
		
		//moving the fourth box in all directions
		if(px >= bl4 && px <= br4 && py >= bt4 && py <= bb4) {
			if (px - 5 <= bl4){	
				crate4.setRight(true);
			
				
			}else if (px + 5 >= br4){
				crate4.setLeft(true);
			

			} else if (py - 5 <= bt4 ){
				crate4.setDown(true);
			
				
			}else if (py + 5 >= bb4){
				crate4.setUp(true);
				
				
			}
			
		}
		
		//if the level is leave1
		if (level1 == false){
			//checking if the boxes are in the position
			//any box can go in any position
			//the coordinates correspond to the position of the ovals drawn onto the map
			//if the box is inside them set the boolean to true
			if (bx > 580  && by < 167 || bx < 66 && by < 163 || bx < 66 && by > 505 || bx > 580 && by> 505){
				b1in = true;
			}if (bx2 > 580  && by2 < 167 || bx2 < 66 && by2 < 163 || bx2 < 66 && by2 > 505 || bx2 > 580 && by2> 505){
				b2in = true;
			}if (bx3 > 580  && by3 < 167 || bx3 < 66 && by3 < 163 || bx3 < 66 && by3 > 505 || bx3 > 580 && by3> 505){
				b3in = true;
			}if (bx4 > 580  && by4 < 167 || bx4 < 66 && by4 < 163 || bx4 < 66 && by4 > 505 || bx4 > 580 && by4> 505){
				b4in = true;
				//once all boxes are in position set in to true and the player can now progress to the next level.
			}if (b1in == true && b2in ==true && b3in ==true && b4in ==true){
				in = true;
				
			}	
		
		}if (level2 == false){
			if 	(bx < 260  && by < 70 || bx > 730 && by < 70 || bx > 925  && by < 130 || bx > 925 && by < 357){
				b1in = true;
			}if (bx2 < 260  && by2 < 70 || bx2 > 730 && by2 < 70 || bx2 > 925  && by2 < 130 || bx2 > 925 && by2< 357){
				b2in = true;
			}if (bx3 < 260  && by3 < 70 || bx3 > 730 && by3 < 70 || bx3 > 925  && by3 < 130 || bx3 > 925 && by3< 357){
				b3in = true;
			}if (bx4 < 260  && by4 < 70 || bx4 > 730 && by4 < 70 || bx4 > 925  && by4 < 130 || bx4 > 925 && by4< 357){
				b4in = true;
			}if (b1in == true && b2in ==true && b3in ==true && b4in ==true){
				in = true;
				
			}	
		
		}if (level3 == false){
			if (bx < 163  && by < 70 || bx > 480 && by < 70 || bx < 160 && by > 607 || bx > 480 && by> 607){
				b1in = true;
			}if (bx2 < 163  && by2 < 70 || bx2 > 480 && by2 < 70 || bx2 < 160 && by2 > 607 || bx2 > 480 && by2> 607){
				b2in = true;
			}if (bx3 < 163  && by3 < 70 || bx3 > 480 && by3 < 70 || bx3 < 160 && by3 > 607 || bx3 > 480 && by3> 607){
				b3in = true;
			}if (bx4 < 163  && by4 < 70 || bx4 > 480 && by4 < 70 || bx4 < 160 && by4 > 607 || bx4 > 480 && by4> 607){
				b4in = true;
			}if (b1in == true && b2in ==true && b3in ==true && b4in ==true){
				in = true;
				
			}	
				//finish this
		}		if (level4 == false){
			if (bx < 197 && by < 513 || bx < 197 && by < 163 || bx < 197 && by <513 || bx < 197 && by> 505){
				b1in = true;
			}if (bx2 < 197  && by2 < 513 || bx2 < 197 && by2 < 513 || bx2 < 197 && by2 <513 || bx2 < 197 && by2<513){
				b2in = true;
			}if (bx3 < 197  && by3 < 513 || bx3 < 197 && by3 < 513 || bx3 < 197 && by3 <513|| bx3 < 197 && by3<513){
				b3in = true;
			}if (bx4 < 197 && by4 < 513 || bx4 < 197 && by4 < 513 || bx4 < 197 && by4 <513 || bx4 < 197 && by4<513){
				b4in = true;
			}if (b1in == true && b2in ==true && b3in ==true && b4in ==true){
				in = true;
				
			}	
		
		}if (level5 == false){
			if (bx <260  && by < 70 || bx >385 && by < 70 || bx < 484 && by <70 || bx > 405 && by<70){
				b1in = true;
			}if (bx2 <260  && by2 < 70 || bx2 >385 && by2 < 70 || bx2 < 484 && by2 <70 || bx2 > 405 && by2<70){
				b2in = true;
			}if (bx3 <260  && by3 < 70 || bx3 >385 && by3 < 70 || bx3 < 484 && by3 <70 || bx3 > 405 && by3<70){
				b3in = true;
			}if (bx4 <260  && by4 < 70 || bx4 >385 && by4 < 70 || bx4 < 484 && by4 <70 || bx4 > 405 && by4<70){
				b4in = true;
			}if (b1in == true && b2in ==true && b3in ==true && b4in ==true){
				in = true;
				
			}	
			

			
		
		}
		
		//if the player reaches the x and y coordinates and level 1 is the current level
		//load the next level - level 2
		if (px >= 363 && py >= 558 && level1 == false && in == true ){
			level2();
			
			
		}
		
		//if the player reaches the x and y coordinates and level 2 is the current level
		//load the next level - level 3
		else if (px >= 428 && py >= 811 && level2 == false && in == true ){
			level3();
		
		}
		//if the player reaches the x and y coordinates and level 3 is the current level
		//load the next level - level 4
		else if (px >= 530 && py >= 300 && level3 == false && in == true ){
			level4();

		
	}
		//if the player reaches the x and y coordinates and level 4 is the current level
		//load the next level - level 5
		else if (px >= 135 && py >= 825 && level4 == false && in == true ){
			level5();

			
		//if the player reaches the x and y coordinates and level 5 is the current level display game complete message 
		}else if (px >= 830 && py >= 273 && level5 == false && in == true ){
			//if the player reaches the end of level 5 display congratulation message then quit game
			JOptionPane.showMessageDialog(null, "Congratulations, you finished the game!");
			System.exit(0);
				
			
			
		}
		
	}


	public void draw(Graphics2D g) {
		
		//filling the window white and setting the size
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gamePanelV5.width, gamePanelV5.height);
		;
		//drawing all the map items onto the map
		TileMapV5.draw(g);
		crate.draw(g);
		crate2.draw(g);
		crate3.draw(g);
		crate4.draw(g);
		
		//if the player is not dead then draw the player
		//if the player is dead quit the game and display a message 
		if (playerdead == true){
			player.draw(g);
						
		}else{
			//if the player dies reset the current level reset the player attributes and draw them again.
			JOptionPane.showMessageDialog(null, "YOU DIED!");
			if (comp1 == true){
				level1();
				playerdead = true;
				player.draw(g);
				playerhealth = 10;
			} if (comp2 == true){
				level2();
				playerdead = true;
				player.draw(g);
				playerhealth = 10;
			
			}if (comp3 == true){
				level3();
				playerdead = true;
				player.draw(g);
				playerhealth = 10;
				
			}if (comp4 == true){
				level4();
				playerdead = true;
				player.draw(g);
				playerhealth = 10;
				
			}if (comp5 == true){
				level5();
				playerdead = true;
				player.draw(g);
				playerhealth = 10;
				
			}
	
	
	
			
	    }
		
		//if the enemies are not dead then draw then to the screen
		//else don't draw them
		if (edead == true){enemy.draw(g);}	
		if (edead2 == true){enemy2.draw(g);}	
		if (edead3 == true){enemy3.draw(g);}	
		if (edead4 == true){enemy4.draw(g);}	
		
		//if the player has killed the enemy then reset there position to 0,0
		//which is off the map.
		//this stops the enemies x and y still being in the map and still being able to kill the player
		if (edead == false){enemy.setPosition(0, 0);}
		if (edead2 == false){enemy2.setPosition(0, 0);}
		if (edead3 == false){enemy3.setPosition(0, 0);}
		if (edead4 == false){enemy4.setPosition(0, 0);}

	
		
		//if the player is shooting
	if (firing == true){
		
		//draws a line from the player to the mouse
			g.setColor(new Color(100, 0, 0));
			g.drawLine(player.getx(),player.gety() ,mx,my);

			//set firing to false - removes the line that was previously drawn
			firing = false;						
		}


	
		//drawing ovals on the maps with the x and y coordinates and the width and height  
		if (level1 ==false){
			g.setColor(new Color(225, 0, 0));
			g.drawOval(580, 129, 32, 32);
			g.drawOval(32, 129, 32, 32);
			g.drawOval(32, 512, 32, 32);
			g.drawOval(580, 515, 32, 32);
		}if(level2 == false){
			g.setColor(new Color(225, 0, 0));
			g.drawOval(930, 323, 32, 32);
			g.drawOval(928, 96, 32, 32);
			g.drawOval(225, 34, 32, 32);
			g.drawOval(733, 34, 32, 32);
		}if(level3 == false){
			g.setColor(new Color(225, 0, 0));
			g.drawOval(480, 609, 32, 32);
			g.drawOval(480, 38, 32, 32);
			g.drawOval(130, 38, 32, 32);
			g.drawOval(130, 609, 32, 32);
		}if(level4 == false){
			g.setColor(new Color(225, 0, 0));
			g.drawOval(160, 385, 32, 32);
			g.drawOval(160, 420, 32, 32);
			g.drawOval(160, 450, 32, 32);
			g.drawOval(160, 480, 32, 32);
		}if(level5 == false){
			g.setColor(new Color(225, 0, 0));
			g.drawOval(227, 35, 32, 32);
			g.drawOval(385, 35, 32, 32);
			g.drawOval(452, 35, 32, 32);
			g.drawOval(638, 35, 32, 32);

		}
		
		//drawing the cursor
		g.setColor(new Color(225, 0, 0));
		g.drawLine(mx - 5, my, mx - 15, my);
		g.drawLine(mx + 5, my, mx + 15, my);
		g.drawLine(mx, my - 5, mx, my - 15);
		g.drawLine(mx, my + 5, mx, my + 15);
		
		
		//displays a red line along the bottom of the screen
		//which gets shorter the more health the player loses.
		g.drawString("health", 720, 890);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		if(playerhealth == 10){
		g.drawLine(720,900 ,900,900);
		}else if (playerhealth == 8){
		g.drawLine(720,900 ,880,900);
		}else if(playerhealth == 6){
		g.drawLine(720,900 ,830,900);	
		}else if(playerhealth == 4){
		g.drawLine(720,900 ,800,900);
		}else if(playerhealth == 2){
		g.drawLine(720,900 ,780,900);
		}else if(playerhealth == 0){
		g.drawLine(720,900 ,720,900);
		}
	
	}
	
	//player movement 
	///enemy moves in the opposite direction of the player
	public void keyTyped(KeyEvent key){}
	
	//if the player presses A move the player and move the enemies in diffrent directions
	//if the player moves at all stop the boxes from moving.
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_A) {
			
			player.setLeft(true);
		
			enemy.setRight(true);
			enemy2.setLeft(true);
			enemy3.setUp(true);
			enemy4.setRight(true);
			
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
			

		}
		if(k == KeyEvent.VK_D) {
			player.setRight(true);
			
			enemy.setLeft(true);
			enemy2.setRight(true);
			enemy3.setDown(true);
			enemy4.setLeft(true);
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		if(k == KeyEvent.VK_W) {
			player.setUp(true);
				
			enemy.setDown(true);
			enemy2.setUp(true);
			enemy3.setRight(true);
			enemy4.setDown(true);
			
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		if(k == KeyEvent.VK_S) {
			player.setDown(true);
					
			enemy.setUp(true);
			enemy2.setDown(true);
			enemy3.setLeft(true);
			enemy4.setUp(true);
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
						
			
			}
		
		//set the running speed of the player
		if(k == KeyEvent.VK_SHIFT) {
			player.movespeed = 5;
			player.maxspeed = 10;
		}
		//if the player presses escape load the pause menu
		if(k == KeyEvent.VK_ESCAPE) {
			requestState = gsm.LOADSTATE;
			
		}
			
			
		//restart
		if(k == KeyEvent.VK_SPACE) {
			//restart level 1 
			//restarting level1 does not currently work
				level1();
			//if the previous levels have been completed and space bar is pressed reload the current level
			if (comp1 == true && comp2 == true){
				level2();
				
				//if the previous levels have been completed and space bar is pressed reload the current level
			} if (comp1 == true && comp2 == true && comp3 ==true){
				level3();
				
				//if the previous levels have been completed and space bar is pressed reload the current level
			} if(comp1 == true && comp2 == true && comp3 ==true && comp4 == true){
				level4();
				///if the previous levels have been completed and space bar is pressed reload the current level
			} if(comp1 == true && comp2 == true && comp3 ==true && comp4 == true && comp5 == true){
				level5();
				
				
			}
		}

		

	}
	//once the key is released stop the moving action 
	public void KeyReleased(int k) {
		if(k == KeyEvent.VK_A) {
			player.setLeft(false);


			enemy.setRight(false);
			enemy2.setLeft(false);
			enemy3.setUp(false);
			enemy4.setRight(false);
			
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		if(k == KeyEvent.VK_D) {
			player.setRight(false);


			enemy.setLeft(false);
			enemy2.setRight(false);
			enemy3.setDown(false);
			enemy4.setLeft(false);
			
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		if(k == KeyEvent.VK_W) {
			player.setUp(false);


			enemy.setDown(false);
			enemy2.setUp(false);
			enemy3.setRight(false);
			enemy4.setDown(false);
			
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		if(k == KeyEvent.VK_S) {
			player.setDown(false);


			enemy.setUp(false);
			enemy2.setDown(false);
			enemy3.setLeft(false);
			enemy4.setUp(false);
			
			crate.setRight(false);
			crate.setLeft(false);
			crate.setUp(false);
			crate.setDown(false);
			
			crate2.setRight(false);
			crate2.setLeft(false);
			crate2.setUp(false);
			crate2.setDown(false);
			
			crate3.setRight(false);
			crate3.setLeft(false);
			crate3.setUp(false);
			crate3.setDown(false);
			
			crate4.setRight(false);
			crate4.setLeft(false);
			crate4.setUp(false);
			crate4.setDown(false);
		}
		
		if(k == KeyEvent.VK_SHIFT) {
			player.movespeed = 0.5;
			player.maxspeed = 5;
		}

	}
		
		
	//getting the position of the mouse
	//telling the game what to do once the mouse is pressed - fire
	public void mousePressed(MouseEvent me) {
		firing = true;
		mx = me.getX();
		my = me.getY();
		
	}
	public void mouseReleased(MouseEvent me) {
		firing = false;
	}
	public void mouseMoved(MouseEvent me) {
		mx = me.getX();
		my = me.getY();
	}
	public void mouseDragged(MouseEvent me) {
		firing = true;
		mx = me.getX();
		my = me.getY();
	}
	
	
	
	public void level1(){
		//set up level 1
		

		//draw the tile map get the tile images and position the map 
		TileMapV5 = new TileMapV5("src/com/game/TestMap4.txt", 32);
		TileMapV5.loadTiles("src/res/tileset.gif");
		TileMapV5.setPosition(0,0);
		
		

		
		
		//creating enemies
		enemy = new EnemyV1(TileMapV5);
		enemy2 = new EnemyV1(TileMapV5);
		enemy3 = new EnemyV1(TileMapV5);
		enemy4 = new EnemyV1(TileMapV5);
		
		
		
		//setting all the enemies positions
		enemy.setPosition(300, 200);
		enemy2.setPosition(350, 300);
		enemy3.setPosition(400, 400);
		enemy4.setPosition(300, 400);	
		
		
		
		//creating crates
		crate = new BoxV1(TileMapV5);
		crate2 = new BoxV1(TileMapV5);
		crate3 = new BoxV1(TileMapV5);
		crate4 = new BoxV1(TileMapV5);
		
		
		//setting the crates positions
		crate.setPosition(181,110);
		crate2.setPosition(139,110);
		crate3.setPosition(160,110);
		crate4.setPosition(181,140);
		
		
		
		player = new PlayerV5(TileMapV5);
		player.setPosition(171,59);
	

		comp1 = true;
		level1 = false;
		
		//resetting all the boxes
		b1in=false;
		b2in=false;
		b3in=false;
		b4in=false;
		in = false;

		
	}
	public void level2(){
		//set up level 2
		

		
		//reset the values of the items on the map 
		edead = true;
		edead2 = true;
		edead3 = true;
		edead4 = true;
		
		ehealth = 10;
		ehealth2 = 10;
		ehealth3 = 10;
		ehealth4 = 10;
		
		
		level1 = true;
		level2  = false;
		
		//draw the tile map get the tile images
		TileMapV5 = new TileMapV5("src/com/game/Map2.txt", 32);
		TileMapV5.loadTiles("src/res/tileset.gif");
		
		
		
		//creating a new enemy 
		enemy = new EnemyV1(TileMapV5);
		enemy2 = new EnemyV1(TileMapV5);
		enemy3 = new EnemyV1(TileMapV5);
		enemy4 = new EnemyV1(TileMapV5);
		
		//setting the enemies position
		enemy.setPosition(300, 300);
		enemy2.setPosition(350, 300);
		enemy3.setPosition(400, 400);
		enemy4.setPosition(300, 400);
		
		
		//creating new crates
		crate = new BoxV1(TileMapV5);
		crate2 = new BoxV1(TileMapV5);
		crate3 = new BoxV1(TileMapV5);
		crate4 = new BoxV1(TileMapV5);
		
		//setting the crates position
		crate.setPosition(404, 551);
		crate2.setPosition(439, 551);
		crate3.setPosition(470, 551);
		crate4.setPosition(500, 551);
		

		//creating a player and the players position
		player = new PlayerV5(TileMapV5);
		player.setPosition(150,300);
		
		
		comp2 = true;
		
		//resetting all the boxes
		b1in=false;
		b2in=false;
		b3in=false;
		b4in=false;
		in = false;
		
		
	}
	private void level3(){
		//set up level 3
		
		//resetting all the values 
		edead = true;
		edead2 = true;
		edead3 = true;
		edead4 = true;
		ehealth = 10;
		ehealth2 = 10;
		ehealth3 = 10;
		ehealth4 = 10;
		
		level2 = true;
	
	
		//draw the tile map get the tile images
		TileMapV5 = new TileMapV5("src/com/game/Map3.txt", 32);
		TileMapV5.loadTiles("src/res/tileset.gif");
		
		
		//creating new enemies
		enemy = new EnemyV1(TileMapV5);
		enemy2 = new EnemyV1(TileMapV5);
		enemy3 = new EnemyV1(TileMapV5);
		enemy4 = new EnemyV1(TileMapV5);
		
		//setting the new enemies positions
		enemy.setPosition(200, 200);
		enemy2.setPosition(350, 300);
		enemy3.setPosition(400, 400);
		enemy4.setPosition(300, 400);
		
		//creating new boxes
		crate = new BoxV1(TileMapV5);
		crate2 = new BoxV1(TileMapV5);
		crate3 = new BoxV1(TileMapV5);
		crate4 = new BoxV1(TileMapV5);
					
		
		//setting the new boxes positions
		crate.setPosition(112, 269);
		crate2.setPosition(112, 306);
		crate3.setPosition(112, 340);
		crate4.setPosition(112, 373);

		//creating a new player and setting the position
		player = new PlayerV5(TileMapV5);
		player.setPosition(50,300);
		
		level3 = false;
		comp3 = true;
		//resetting all the boxes
		b1in=false;
		b2in=false;
		b3in=false;
		b4in=false;
		in = false;
	}
	private void level4(){
		
		//resetting the map objects		
		edead = true;
		edead2 = true;
		edead3 = true;
		edead4 = true;
		
		ehealth = 10;
		ehealth2 = 10;
		ehealth3 = 10;
		ehealth4 = 10;
		
		
		level3 = true;
		level4 = false;
	
		//draw the tile map get the tile images  
		TileMapV5 = new TileMapV5("src/com/game/Map4.txt", 32);
		TileMapV5.loadTiles("src/res/tileset.gif");
		

		
		//creating new enemies
		enemy = new EnemyV1(TileMapV5);
		enemy2 = new EnemyV1(TileMapV5);
		enemy3 = new EnemyV1(TileMapV5);
		enemy4 = new EnemyV1(TileMapV5);	
		
		//setting the new postions of the enemies 	
		enemy.setPosition(400, 400);
		enemy2.setPosition(350, 400);
		enemy3.setPosition(400, 400);
		enemy4.setPosition(300, 400);
		

		//creating new boxes
		crate = new BoxV1(TileMapV5);
		crate2 = new BoxV1(TileMapV5);
		crate3 = new BoxV1(TileMapV5);
		crate4 = new BoxV1(TileMapV5);
		
		//setting the boxes position
		crate.setPosition(747, 276);
		crate2.setPosition(786, 274);
		crate3.setPosition(816, 274);
		crate4.setPosition(747, 356);
		

		//creating a new player and setting the position
		player = new PlayerV5(TileMapV5);
		player.setPosition(926,123);
		
		
		comp4 = true;
		
		//resetting all the boxes
		b1in=false;
		b2in=false;
		b3in=false;
		b4in=false;
		in = false;
	}
	private void level5(){

		//resetting the map objects
		edead = true;
		edead2 = true;
		edead3 = true;
		edead4 = true;
		
		ehealth = 10;
		ehealth2 = 10;
		ehealth3 = 10;
		ehealth4 = 10;
		
		
		level4 = true;
		
		
		//draw the tile map get the tile images 
		TileMapV5 = new TileMapV5("src/com/game/Map5.txt", 32);
		TileMapV5.loadTiles("src/res/tileset.gif");
		
		
		//creating new enemies
		enemy = new EnemyV1(TileMapV5);
		enemy2 = new EnemyV1(TileMapV5);
		enemy3 = new EnemyV1(TileMapV5);
		enemy4 = new EnemyV1(TileMapV5);
		
		//setting the position of the enemies
		enemy.setPosition(400, 400);
		enemy2.setPosition(350, 300);
		enemy3.setPosition(400, 400);
		enemy4.setPosition(300, 400);
		
		//creating new boxes
		crate = new BoxV1(TileMapV5);
		crate2 = new BoxV1(TileMapV5);
		crate3 = new BoxV1(TileMapV5);
		crate4 = new BoxV1(TileMapV5);
		
		//setting the position of the boxes
		crate.setPosition(235, 660);
		crate2.setPosition(252, 660);
		crate3.setPosition(314, 660);
		crate4.setPosition(356, 660);
		
		

		//creaing a new player and setting the position
		player = new PlayerV5(TileMapV5);
		player.setPosition(135,112);
		level5 = false;
				
		
		comp5 = true;
		
		//resetting all the boxes
		b1in=false;
		b2in=false;
		b3in=false;
		b4in=false;
		in = false;
		
		
		
		
	}
	
	
	
	
}

