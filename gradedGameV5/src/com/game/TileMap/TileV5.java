//gives the tiles created in TileMapV5 attributes
package com.game.TileMap;

//imports
import java.awt.image.*;



public class TileV5 {
	
	
	private BufferedImage image;
	private boolean blocked;//if the player can pass through a tile
	
	public TileV5(BufferedImage image, boolean blocked){
		this.image = image;
		this.blocked = blocked;
			
	}
	
	//getters
	public BufferedImage getImage(){
		return image;
	}
	public boolean isBlocked(){
		return blocked;
		}

}
