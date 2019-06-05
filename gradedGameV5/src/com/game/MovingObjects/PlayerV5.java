//the class that creates the player

package com.game.MovingObjects;


//imports
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;




//import classes from other folders
import com.game.MovingObjects.AnimationV5;
import com.game.TileMap.TileMapV5;



public class PlayerV5 extends MovingthingsV1 {
	
	
	//widths and height of tiles NOT pixels
	private int width;
	private int height;

	
	
	//setting the animations
	private AnimationV5 animation;
	private BufferedImage[] idle;
	private BufferedImage[] walking;
	private BufferedImage[] walkingdown;
	private BufferedImage[] walkingup;

	//tell which wa the player is facing to flip the image
	private boolean facingLeft;
	


	
	
	
	public PlayerV5(TileMapV5 tm){
		super(tm);
				
		//height of player
		width = 22;
		height = 22;
		
		
		//player attributes
		movespeed = 0.5;
		maxspeed = 5;
		stopSpeed = 1;

			
		
	
		try{
			
			idle = new BufferedImage[1];
			walkingdown = new BufferedImage[4];
			walkingup = new BufferedImage[4];
			walking = new BufferedImage[4];
		
			
			
			//player is not moving - idle
			idle[0] = ImageIO.read(new File("src/res/PlayerIdle.gif"));

			
			//walking left and right
			BufferedImage image = ImageIO.read(new File("src/res/PLayerWalk.gif"));
			
			for (int i = 0; i < walking.length; i++){
				walking[i] = image.getSubimage(i * width + 1,0,width,height);
			}
			
			//moving down
			BufferedImage imagedown = ImageIO.read(new File("src/res/PLayerWalkDown.gif"));
			
			for (int i = 0; i < walkingdown.length; i++){
				walkingdown[i] = imagedown.getSubimage(i * width + 1,0,width,height);
			}
			

			//moving up
			BufferedImage imageup = ImageIO.read(new File("src/res/PLayerWalkUp.gif"));
			
			for (int i = 0; i < walkingup.length; i++){
				walkingup[i] = imageup.getSubimage(i * width + 1,0,width,height);
			}
			
				
			
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//set the default animation - null pointer exception given if i dont.
		animation = new AnimationV5();
		animation.setFrames(idle);
		animation.setDelay(100);		
		facingLeft = false;

		
		
	}
	

	public void update(){
		//find next position and moving the player

		checkMapCollision();
		setPosition(tempx,tempy);
		
		
		//set animations
	
		
		if(left) {
			dx -= movespeed;//if player is moving left take away from move speed 
			if(dx < -maxspeed) {//player cannot move to next tile faster than max speed
				dx = -maxspeed;
			}
		}
		else if(right) {
			dx += movespeed;//same as moving left but adding instead of taking away.
			if(dx > maxspeed) {
				dx = maxspeed;
			}
		}
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
			dy -= movespeed;//move the player along the Yaxis to move up
			if(dy < -maxspeed) {
				dy = -maxspeed;
			}
		}
		else if(down) {//move the player along the Yaxis to move down
			dy += movespeed;
			if(dy > maxspeed) {
				dy = maxspeed;
			}
		}
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
		
		
			
			//sprite animation
			//set the player animations for moving left, right, down and up as well as idle
			if (left || right){
				
				animation.setFrames(walking);
				animation.setDelay(100);
				}
			else if	 (down){
				
				animation.setFrames(walkingdown);
				animation.setDelay(100);
				}
			else if (up){
				
				animation.setFrames(walkingup);
				animation.setDelay(100);
				
			}
		
			
			else 		
			{
				animation.setFrames(idle);
				animation.setDelay(-1);
							
			}
			
			
			
			//update the player animation
			animation.update();
			
			
			//check if the player is looking left or right
			if (dx <  0){
				facingLeft = true;
			}
			if( dx > 0){
				facingLeft = false;
			}
	
	

			
			
			
	}
	public void draw(Graphics2D g){

		//setting the positon of the player
		setMapPos();

		
	
		//rotating the pictures depending which way the player is facing
		if (facingLeft){
			g.drawImage(animation.getImage(), (int)(xmap + x - width / 2), (int)(ymap + y - height / 2),null);
						
		}
		if(facingLeft == false){
			g.drawImage(animation.getImage(), (int)(xmap + x - width / 2 + width), (int)(ymap + y - height / 2),-width,height,null);
			
		}
		
		
	}
	
	
}

