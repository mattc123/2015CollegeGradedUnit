//this class adds displays the game into the jframe

package com.game.Main;

//imports
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
//import class from other folder
import com.game.GameState.GameStateManagerV1;



//gamePanel inherits from JPanel.....................listeners listen for Key and Mouse input
public class gamePanelV5 extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	
	private static final long serialVersionUID = 1L;
	
	//map width and height
	public static final int width = 1000;
	public static final int height = 1000;
	

	
	private Thread thread;
	private boolean running;
	
	private GameStateManagerV1 gsm;
	
	private BufferedImage image;
	private Graphics2D g;
	
	//setting the fps for the game
	private int FPS = 30;
	private int targettime = 1000/FPS;//how many times the  game will update a second (30)
	

	//CONSTRUCTER
	public gamePanelV5(){
		super();
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
		
			
	}
	public void addNotify(){
		//override "addNotify"
		super.addNotify();
		//starts a new thread
		if(thread == null){
			thread = new Thread(this);
			thread.start();
			
						
		}
		//adds input listeners
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
			}
	//every time the game starts
	public void run(){
		
		init();	
		long startTime;
		long urdTime;
		long waitTime;
		
		while(running){
			startTime = System.nanoTime();
			//run these methods 30 times every second
			update();
			render();
			draw();
			
			urdTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targettime - urdTime;
			
			try{
				Thread.sleep(waitTime);//stops the thread for the duration of "waitTime"
								
			}
			catch(Exception e) {
							
			}
			
			
		}
		
		
		
	}
	

	//initilize
	public void init(){
		running = true;
		
		
		image = new BufferedImage (width, height,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image. getGraphics();
		
		gsm = new GameStateManagerV1();
		
		
		

	}
	
	

	//update the player and the map
	private void update(){
		gsm.update();
		
	}
	//render the player and the buffer
	private void render(){
		
		//set the background colour as white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		//draws things from the  game state manager to the screen
		// menustate, playstate and loadstate
		gsm.draw(g);
		
		

		
	}
	//draw the player and map from the buffer
	private void draw(){
		Graphics g2 = getGraphics();
		g2.drawImage(image,  0 , 0, null);
		g2.dispose();
		


	}
	
	
	//input from keystrokes
	public void keyTyped(KeyEvent key){}
	
	public void keyPressed(KeyEvent key){
		
		try {
			gsm.keyPressed(key.getKeyCode());
		}
		catch(Exception e) {}
		
		


		
		
	}
	public void keyReleased(KeyEvent key){
	
		try {
			gsm.keyReleased(key.getKeyCode());
		}
		catch(Exception e) {}
		

		
	}
		
	
	//mouse input 
	public void mouseClicked(MouseEvent me) {}
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {
		
		try{
		gsm.mousePressed(me);
		}catch(Exception e) {}
		
	}
		
	public void mouseDragged(MouseEvent me) {
	
		try{
		gsm.mouseDragged(me);
		}catch(Exception e){}
	}
	
	
	public void mouseMoved(MouseEvent me) {	
		try{
		gsm.mouseMoved(me);
		}catch(Exception e){}
		
	}
	public void mouseReleased(MouseEvent me) {
		try{
		gsm.mouseReleased(me);
		}catch(Exception e){}
	}
	
	



}
