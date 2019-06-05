//super class which all moving objects in the game will inherit from

package com.game.MovingObjects;

//imports classes from different folders
import com.game.TileMap.TileMapV5;
import com.game.MovingObjects.AnimationV5;

public abstract class MovingthingsV1 {
	
	
	//tiles
	protected TileMapV5 tileMap;
	protected int tileSize;
	
	protected double xmap;
	protected double ymap;
	
	//object position
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	
	//dimensions
	protected int width;
	protected int height;
	
	
	//collisions
	protected int coliswidth = 22;
	protected int colisheight = 22;
	
	//more collisions
	protected int currentRow;
	protected int currentCol;
	protected double destx;
	protected double desty;
	protected double tempx;
	protected double tempy;
	
	
	//check the 4 corners of a tile to determine if its a wall or not
	protected boolean topleft;
	protected boolean topright;
	protected boolean bottomright;
	protected boolean bottomleft;

	
	
	//animation
	protected AnimationV5 animation;
	protected int currentAction;
	protected boolean facingleft;
	
	
	//movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	
	//image movement
	protected boolean attacking;
	public double movespeed;
	public double maxspeed;
	protected double stopSpeed;
	
	
	//CONSTRUCTOR
	public MovingthingsV1(TileMapV5 tm){
		
		tileMap = tm;
		tileSize = tm.getTileSize();
		
		
				
	}
	

	
	public void FindCorners(double x, double y) {
		
		//finding the boundary's of the map.	
		int leftTile = (int)(x - coliswidth / 2) / tileSize;
        int rightTile = (int)(x + coliswidth / 2 - 1) / tileSize;
        int topTile = (int)(y - colisheight / 2) / tileSize; 
        int bottomTile = (int)(y + colisheight / 2 - 1) / tileSize;

        
        
        
        
		//stop the player from moving through the edge tiles.
 		topleft = tileMap.isBlocked(topTile, leftTile);
		topright = tileMap.isBlocked(topTile, rightTile);
		bottomleft = tileMap.isBlocked(bottomTile, leftTile);
		bottomright = tileMap.isBlocked(bottomTile, rightTile);
	}
	
	
	
	
	public void checkMapCollision(){
		//check what type of tile the moving object has his
		
		
		//getting the row and column that the moving object is on
		currentCol = tileMap.getColTile((int)x);
		currentRow = tileMap.getRowTile((int)y);
		
		//next position for the moving objects
		destx = x + dx;
		desty = y + dy;
		
		//temporary x and y coordinates 
		tempx = x;
		tempy = y;
		
		//finding the corners of tiles
		FindCorners(x,desty);

		//if dy is less than 0 the player has hit the right side of the object 
		if(dy < 0) {
			if(topleft || topright) {
				//set the dy to 0 to stop the player
				dy = 0;
				
				tempy = currentRow * tileSize + colisheight / 2;
			}
			else {
				//else move the player along the dy
				tempy += dy;
			}
		}
		//if dy is greater than 0 the player has hit the left side of the object 
		if(dy > 0) {
			if(bottomleft || bottomright) {
				//set the dy to 0 to stop the player
				dy = 0;

				tempy = (currentRow + 1) * tileSize - colisheight / 2;
			}
			else {
				//else move the player along the dy
				tempy += dy;
			}
		}
		
		
		
		FindCorners(destx, y);
		
		//if dx is less than 0 the player has hit the top side of the object 
		if(dx < 0) {
			if(topleft || bottomleft) {
				//set the dx to 0 to stop the player
				dx = 0;
				tempx = (currentCol) * tileSize + coliswidth / 2;
			}
			else {
				//else move the player along the dx
				tempx += dx;
			}
		}
		
		
		
		//if dx is greater than 0 the player has hit the bottom side of the object 
		if(dx > 0) {
			if(topright || bottomright) {
				//set the dx to 0 to stop the player
				dx = 0;
				tempx = (currentCol + 1) * tileSize - coliswidth / 2;
			}
			else {
				//else move the player along the dy
				tempx += dx;
			}
		}
		
			
		
	}
	
	
	//GETTERS
	public int getx(){return (int)x;}
	public int gety(){return (int)y;}
	
	public int getwidth(){return width;}
	public int getheight(){return height;}
	
	public int getcoliswidth(){return coliswidth;}
	public int getcolisheight(){return colisheight;}
	
	
	
	
	//SETTERS
	public void setPosition(double x, double y){
		
		this.x = x;
		this.y = y;
		
	}
	public void setVector(double dx, double dy){
		
		this.dx = dx;
		this.dy = dy;
		
	}
	
	public void setMapPos(){
		xmap = tileMap.getXpos();
		ymap = tileMap.getYpos();
		
	}
	
	public void setLeft(boolean b){
		left = b;
	}
	public void setRight(boolean b){
		right = b;
	}
	public void setDown(boolean b){
		down = b;
	}
	public void setUp(boolean b){
		up = b;
	}

	
	

}

