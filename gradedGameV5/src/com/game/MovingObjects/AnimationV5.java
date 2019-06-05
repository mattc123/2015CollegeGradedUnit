//this class deals with animating the player 

package com.game.MovingObjects;

//imports
import java.awt.image.*;


public class AnimationV5 {

	private BufferedImage[] frames; //store the current action - walking down, left,right.....
	private int currentFrame;
	
	//sets the time each anaimation will play for
	private long startTime;
	private long delay;
	
	
	public AnimationV5(){}
	
	
	public void setFrames(BufferedImage[] images){
		//frames is the current image in the buffered image array 
		this.frames = images;
		if (currentFrame >= frames.length) currentFrame = 0;
		currentFrame = 0;
		
		
	}
	public void setDelay(long d){
		//delay between each frame 
		delay =d;
		
	}
	
	public void update(){
		
		if(delay == - 1) return;
		
		long elapsed = (System.nanoTime() - startTime)/1000000;//Milliseconds
		if (elapsed > delay){
			//if the time elapsed is greater than the delay time get the next frame
			currentFrame++;
			startTime = System.nanoTime();
					
		}
		if(currentFrame == frames.length){
			//sets the current frame
			currentFrame = 0;			
		}
		
		
		
	}
	
	

	public int getCurrentFrame() {
		return currentFrame;
	}
	
	public BufferedImage getImage() {
		return frames[currentFrame];
	}
	
	
	
	
}
