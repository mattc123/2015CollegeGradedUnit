//creates the tiles which are displayed on the map
package com.game.TileMap;

//imports
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

//import classes from different folders
import com.game.Main.gamePanelV5;



public class TileMapV5 {
	
	
	//position
	private int x;
	private int y;
	
	
	private int width;
	private int height;
	
	//bounds of the scrolling
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double scrolling;
	
	
	
	private int tileSize;
	private int[][] map;//2d array
	private int mapWidth;
	private int mapHeight;
	
	
	private BufferedImage tileset;
	private TileV5[][] tiles;
	
	
	
	
	//constructor
	public TileMapV5(String s, int tileSize){
		this.tileSize = tileSize;
		scrolling = 0.07;
		
		try{


			BufferedReader br = new BufferedReader(new FileReader(s));
			
			//find the width and height of the map from file.
			mapWidth = Integer.parseInt(br.readLine());
			mapHeight = Integer.parseInt(br.readLine());
			
			//finding the width and height of the map in tiles not pixels
			width = mapWidth * tileSize;
			height = mapHeight * tileSize;
			
			//setting the width and height to the 2d array.			
			map = new int[mapHeight][mapWidth];
			
			
			
			
			//set the bounds of the map
			xmin = gamePanelV5.width - width;
			xmax = 0;
			ymin = gamePanelV5.height - height;
			ymax = 0;
			
			
			// set delimited to any white space.
			String delimiters = "\\s+";
			
			//drawing the map to the jframe by row and column
			for( int row = 0; row < mapHeight; row++){
				String line = br.readLine();
				String[] tokens = line.split(delimiters);
				for ( int col = 0; col < mapWidth; col++){
					map[row][col] = Integer.parseInt(tokens[col]);
					
				}
			}
			//close the BufferedReader
			br.close();		
			
		} 
		
		catch (Exception e){}
		
		
		
	}
	
	
	
	public void loadTiles(String  s){
		try{
			//reading the tiles in from the file
			tileset = ImageIO.read(new File(s));
			int numTilesAcross = (tileset.getWidth() + 1)/(tileSize + 1);
			tiles = new TileV5[2][numTilesAcross];
			
			BufferedImage subimage;
			for(int col = 0; col< numTilesAcross; col++){
				subimage = tileset.getSubimage(col*tileSize + col,0, tileSize,tileSize);
				tiles[0][col] = new TileV5(subimage, false);
				subimage = tileset.getSubimage(col*tileSize + col, tileSize + 1,tileSize,tileSize);
				tiles[1][col] = new TileV5(subimage, true);
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	//getters and setters
	public int getXpos(){
		return x;
	}
	public int getYpos(){
		return y;
	}
	
	public int getColTile(int x){
		return x / tileSize;
		
		
	}
	public int getRowTile(int y){
		return y / tileSize;
		
	}
	
	public int getTile(int row, int col){
		return map[row][col];
	}
	public int getTileSize(){
		return tileSize;
	}
	
		public boolean isBlocked(int row, int col){
		//telling if the position the moving object is on is blocked or not
		
		int currentpos = map[row][col];
		int curr = currentpos / tiles[0].length;
		int curc = currentpos % tiles[0].length;
		return tiles[curr][curc].isBlocked();
		
		
	}
	
	public void setPosition (double x, double y){
		this.x += (x-this.x)* scrolling;
		this.y +=(y-this.x)* scrolling;
		
		fixBounds();
		
		
		
		
	}
	
	
	private void fixBounds(){
		//bounds of the map scrolling
		if (x < xmin) x = xmin;
		if (y < ymin) y = ymin;
		if (x > xmax) x = xmax;
		if (y > ymax) y = ymax;
		
		
	}
	
	
	public void setXpos(int i){
		x = i;
		fixBounds();
	}
	public void setYpos(int d){
		y = d;
		fixBounds();
	}
	

	public void update(){}
	public void draw(Graphics2D g){
		//drawing the map to the game window.
		//for each row in the map draw a column 
		for (int row = 0; row < mapHeight; row ++){
			for (int col = 0; col < mapWidth; col++){
				
				int currentpos =  map[row][col];
				
				
				int curr = currentpos / tiles[0].length;
				// % Divides the left by right and returns the remainder
				int curc = currentpos % tiles[0].length;
				
				//draw by row and column
				g.drawImage(tiles[curr][curc].getImage(),x+col*tileSize, y+row*tileSize,null);
								
				
			}
			
			
		}
		
	}
		
	

	
}
