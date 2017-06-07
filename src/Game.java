import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator

import java.applet.*;      // AudioClip
import java.awt.*;         // Color
import java.awt.event.*;   // MouseEvent
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.sun.prism.paint.Color;

public class Game extends acm.program.GraphicsProgram implements KeyListener
{
	/*
	 * Declaration of private class variables sorted by type
	 */
	
    private static double heightHealthBars = 30;
    private static double changeHealthBarWidth = 40;
    private static double yCoordRect = 75;
    
    private static boolean newtIsPunching = false;
    private static boolean leibIsPunching = false;
    private static boolean start = false;
    private static boolean newtwin = false;
    private static boolean leibwin = false;
    
	private static GImage background = new GImage("Background.jpg");
	private static GImage newtDeriv = new GImage("10.png");
	private static GImage leibDeriv = new GImage("10.png");
	
	private static GCanvas gc = new GCanvas();
	
	private static Player newt = new Player("Newt.png");
	private static Player leib = new Player("Leib.png");
	private static GRect redRectNewt = new GRect (100,yCoordRect, 400, heightHealthBars);
	private static GRect redRectLeib = new GRect (780, yCoordRect, 400, heightHealthBars);
	private static GRect greenRectNewt = new GRect (100,yCoordRect,400,heightHealthBars);
	private static GRect greenRectLeib = new GRect (780,yCoordRect,400,heightHealthBars);

	
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 750;
		int count = 0;
		
		
		KeyListener listener = new KeyListener() {	//key control commands
			
		    public void keyPressed(KeyEvent e) {
		    	int id = e.getKeyCode();
		    	System.out.println("Key pressed: " + e.getKeyChar());
		    	start = true;
		    	
		    		if (KeyEvent.VK_D == id) {	//Moves Newton to the right
		    			newt.move(90, "newt_ready.png");
		    			newt.pause(.01);
		    			}
		    		
		    		if (KeyEvent.VK_A == id) {	//Moves Newton to the left
		    			newt.move(-90, "newt_ready.png");
		    			newt.pause(.01);
		    			}
		    		
		    		if (KeyEvent.VK_F == id ) {	//Attack key for Newton
		    			newt.setImage("newt_attack.png");
		    			newtIsPunching = true;
		    			System.out.println("newt is punching " + newtIsPunching);
		    			
			    			if (newt.intersects(leib) && newtIsPunching == true) {
			    				leib.health--;
			    				lowerHealthLieb(gc);
			    				System.out.println("leib doing the pain " + newt.health);
			    			}
			    			
		    			newtIsPunching = false;
		    			}
		    		
		    		if (KeyEvent.VK_RIGHT == id) { //Moves Leibniz right
		    			leib.move(90, "leib_ready.png");
		    			leib.pause(.01);
		    			}
		    		
		    		if (KeyEvent.VK_LEFT == id) { //Moves Leibniz left
		    			leib.move(-90, "leib_ready.png");
		    			leib.pause(.01);
		    			}
		    		
		    		if (KeyEvent.VK_PERIOD == id ) { //Attack key for Leibniz
		    			leib.setImage("leib_attack.png");
		    			leibIsPunching = true;
		    			System.out.println("leib is punching " + leibIsPunching);
		    			
			    			if (leib.intersects(newt) && leibIsPunching == true) {
			    				newt.health--;
			    				lowerHealthNewt(gc);
			    				System.out.println("newt doing the pain " + leib.health);
			    			}
		    			
		    			leibIsPunching = false;
		    			}
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				//unused
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//unused
			}

		};
		
	    gc.setBackground(java.awt.Color.BLACK);
	    
	    /*
	     * Creating the window as well as setting default operations
	     */
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.getContentPane().add(BorderLayout.CENTER, gc);
        GImage startScreen = new GImage("start.png");
        frame.show();
        gc.setFocusable(true);
        gc.setFocusTraversalKeysEnabled(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        /*
         * Adding key listeners for player control
         */
        gc.addKeyListener(listener);
        
        newt.setInitialLocation(70, 250);
        leib.setInitialLocation(1100, 250);

       /*
        * Fading in of start screen containing background information
        */
        while (count < 51) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.sendToBack();
        	startScreen.pause(50);
        	count++;
        }
        
        /*
         * Waiting for keypress to resume game
         */
        
        while (start == false) {
        	startScreen.pause(10);
        }

        /*
         * Fading out of start screen
         */
        
        while (count > 0) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.sendToBack();
        	startScreen.pause(50);
        	count--;
        }
        
        /*
         * setting background, adding characters
         */
        
        gc.remove(startScreen);
        gc.add(newt);
        gc.add(leib);
        
        gc.add(background);
        background.sendToBack();
        
        /*
         * making a newton health bar --> the red background bar that stays the same throughout the game
         */

        redRectNewt.setFilled(true);
        redRectNewt.setVisible(true);
        redRectNewt.setFillColor(java.awt.Color.RED);
        redRectNewt.sendToFront();
        gc.add(redRectNewt);
        System.out.println("printing: red newt bar");
        
        /*
         * making a libniez bar ---> the red background bar that stays the same throughout the game
         */
        
        redRectLeib.setFilled(true);
        redRectLeib.setVisible(true);
        redRectLeib.setFillColor(java.awt.Color.RED);
        redRectLeib.sendToFront();
        gc.add(redRectLeib);
        System.out.println("printing: red lieb bar");

        /*
         * making Newton green bar
         */
        
        greenRectNewt.setFilled(true);
        greenRectNewt.setVisible(true);
        greenRectNewt.setFillColor(java.awt.Color.GREEN);
        greenRectNewt.sendToFront();
        gc.add(greenRectNewt);
        System.out.println("printing: green newt bar ");
        
        /*
         * making Liebniz green bar
         */
        
        greenRectLeib.setFilled(true);
        greenRectLeib.setVisible(true);
        greenRectLeib.setFillColor(java.awt.Color.GREEN);
        greenRectLeib.sendToFront();
        gc.add(greenRectLeib);
        System.out.println("printing: green lib bar");
        
        gc.add(newtDeriv, 100, 50);
        gc.add(leibDeriv, 780, 50);

        /*
         * This keeps the game running until a player loses, then displays the win message
         */
        
        while (newtwin == false && leibwin == false) {
	        	
	        GLabel leibwins = new GLabel("Leibniz has discovered calculus!");
	        leibwins.setFont(new Font("Sans-Serif", Font.BOLD, 60));
	        leibwins.setColor(java.awt.Color.GREEN);
	        leibwins.setLocation((gc.getWidth() / 2) - (leibwins.getWidth() / 2), (gc.getHeight() / 2) - (leibwins.getHeight() / 2));
	        leibwins.setVisible(true);
	        leibwins.sendToFront();
	        
	        GLabel newtwins = new GLabel("Newton has discovered calculus!");
	        newtwins.setFont(new Font("Sans-Serif", Font.BOLD, 60));
	        newtwins.setColor(java.awt.Color.GREEN);
	        newtwins.setLocation((gc.getWidth() / 2) - (newtwins.getWidth() / 2), (gc.getHeight() / 2) - (newtwins.getHeight() / 2));
	        newtwins.setVisible(true);
	        newtwins.sendToFront();
	        
	        if (leibwin == true) {
	        	gc.add(leibwins);
	        	gc.removeKeyListener(listener);
	        }
	        
	        else if (newtwin == true) {
	        	gc.add(newtwins);
	        	gc.removeKeyListener(listener);
	        } 
        
        }
		
	}
	
	/*
	 * Modifys the opactity of the image
	 */
	
	public static void setOpacity(GImage source, int alpha) {
		int[][] pixels = source.getPixelArray();
		
		int[][] newpixels = new int[pixels.length][pixels[0].length];
		
		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < pixels[r].length; c++) {
				try {
					int red = GImage.getRed(pixels[r][c]);
					int blue = GImage.getBlue(pixels[r][c]);
					int green = GImage.getGreen(pixels[r][c]);
					
					newpixels[r][c] = GImage.createRGBPixel(red, green, blue, alpha);
				}
				catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		source.setPixelArray(newpixels);
	}
	
	public static void lowerHealthNewt(GCanvas gc)
	{
	    //changes the size of the green health bar
	    System.out.println("Running: lowerHealthNewt");
	    greenRectNewt.setSize(greenRectNewt.getWidth() -changeHealthBarWidth, heightHealthBars );
	    gc.add(greenRectNewt);
	    //changes the picture of the derivative
	    if (newt.getHealth() == 9)
	    {
	       newtDeriv.setImage("9.png");
	       gc.add(newtDeriv); 
	    }
	    else if (newt.getHealth()==8)
	    {
	       newtDeriv.setImage("8.png");
	       gc.add(newtDeriv);   
	    }
	    else if (newt.getHealth()==7)
	    {
	       newtDeriv.setImage("7.png");
	       gc.add(newtDeriv); 
	    }
	    else if (newt.getHealth()==6)
	    {
	       newtDeriv.setImage("6.png");
	       gc.add(newtDeriv); 
	    }
	    else if (newt.getHealth()==5)
        {
           newtDeriv.setImage("5.png");
           gc.add(newtDeriv); 
        }
	    else if (newt.getHealth()==4)
        {
           newtDeriv.setImage("4.png");
           gc.add(newtDeriv); 
        }
	    else if (newt.getHealth()==3)
        {
           newtDeriv.setImage("3.png");
           gc.add(newtDeriv); 
        }
	    else if (newt.getHealth()==2)
        {
           newtDeriv.setImage("2.png");
           gc.add(newtDeriv); 
        }
	    else if (newt.getHealth()==1)
        {
           newtDeriv.setImage("1.png");
           gc.add(newtDeriv); 
        }
	    else if (newt.getHealth()==0)
        {
           newtDeriv.setImage("0.png");
           gc.add(newtDeriv); 
           leibwin = true;
        }
	}
	
	public static void lowerHealthLieb(GCanvas gc)
	{
	    //changes health bar lieb to slower
	    System.out.println("Running: lowerHealthLieb");
        greenRectLeib.setSize(greenRectLeib.getWidth() -changeHealthBarWidth, heightHealthBars );
        greenRectLeib.setLocation(greenRectLeib.getX() + changeHealthBarWidth,yCoordRect);
        gc.add(greenRectLeib);
        //changes leib derivative
        if (leib.getHealth() ==9)
        {
            leibDeriv.setImage("9.png");
            gc.add(leibDeriv); 
        }
        else if (leib.getHealth()==8)
        {
             leibDeriv.setImage("8.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==7)
        {
             leibDeriv.setImage("7.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==6)
        {
             leibDeriv.setImage("6.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==5)
        {
             leibDeriv.setImage("5.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==4)
        {
             leibDeriv.setImage("4.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==3)
        {
             leibDeriv.setImage("3.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==2)
        {
             leibDeriv.setImage("2.png");
             gc.add(leibDeriv);
        }
        else if (leib.getHealth()==1)
        {
             leibDeriv.setImage("1.png");
             gc.add(leibDeriv);
        }else if (leib.getHealth()==0)
        {
            leibDeriv.setImage("0.png");
            gc.add(leibDeriv);
            newtwin = true;
       }
	}
}

