//this class inherits from the Movingthings class
//and create the crates that the player will push around
package com.game.MovingObjects;


//imports
import java.awt.*;
//import classes from other folder
import com.game.TileMap.TileMapV5;



public class BoxV1 extends MovingthingsV1 {
	
	
	//widths and height the the box  
	private int width;
	private int height;


	public BoxV1(TileMapV5 tm){
		super(tm);
				
		//height of box
		width = 22;
		height = 22;
		
		
		//box attributes
		movespeed = 0.5;
		maxspeed = 5;
		stopSpeed = 1;

		
	}
	
	
	
	public void update(){
		//find next position and moving the box
		
		checkMapCollision();
		setPosition(tempx,tempy);
		
		//set animations
		
		
		if(left) {
			dx -= movespeed;//if box is moving left take away from move speed 
			if(dx < -maxspeed) {//box cannot move to next tile faster than max speed
				dx = -maxspeed;
			}
		}
		else if(right) {
			dx += movespeed;//same as moving left but adding instead of taking away.
			if(dx > maxspeed) {
				dx = maxspeed;
			}
		}
		//if the box is not moving left or fight stop the player and set the destination x to 0
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		
		if(up) {
			dy -= movespeed;//move the box along the Yaxis to move up
			if(dy < -maxspeed) {
				dy = -maxspeed;
			}
		}
		else if(down) {//move the box along the Yaxis to move down
			dy += movespeed;
			if(dy > maxspeed) {
				dy = maxspeed;
			}
		}
		//if the box is not moving up or down stop the player and set the destination y to 0
		else {
			if(dy > 0) {
				dy -= stopSpeed;
				if(dy < 0) {
					dy = 0;
				}
			}
			else if(dy < 0) {
				dy += stopSpeed;
				if(dy > 0) {
					dy = 0;
				}
			}
		}
		
	
			
			
		
	}
	public void draw(Graphics2D g){
		
		int tx = tileMap.getXpos();
		int ty = tileMap.getYpos();
		
		//set the boxes map position
		setMapPos();
	

		
		//draw Box as a blue square
		g.setColor(Color.BLUE);
		g.fillRect((int) (tx + x - width / 2), (int) (ty + y - height / 2), width, height);
		
		
		

		
		
	}
	
	
}

