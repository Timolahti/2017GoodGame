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
    private static double heightHealthBars = 30;
    private static double changeHealthBarWidth = 40;
    private static boolean newtIsPunching = false;
    private static boolean leibIsPunching = false;
    private static boolean start = false;
    
	private static GImage background = new GImage("Background.jpg");
	private static Player newt = new Player("Newt.png");
	private static Player leib = new Player("Leib.png");
	private static GRect redRectNewt = new GRect (100,75, 400, heightHealthBars);
	private static GRect redRectLib = new GRect (780, 75, 400, heightHealthBars);
	private static GRect greenRectNewt = new GRect (100,75,400,heightHealthBars);
	//change starting position LIA!!!!!!!!!!!
	private static GRect greenRectLib = new GRect (780,75,400,heightHealthBars);

	
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 750;
		int count = 0;
		
		KeyListener listener = new KeyListener() {	//key control commands
			
		    public void keyPressed(KeyEvent e) {
		    	
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				int id = e.getKeyCode();	//this is all to test the key listeners
		    	System.out.println("thingu is " + e.getKeyChar());
		    	start = true;
		    	if (id == KeyEvent.VK_D) {
		    		newt.setLocation(newt.getX() + 10, newt.getY());
		        	newt.pause(5);
		    	}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

		};
		
	    GCanvas gc = new GCanvas();
	    gc.setBackground(java.awt.Color.BLACK);
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        
        frame.getContentPane().add(BorderLayout.CENTER, gc);
        GImage startScreen = new GImage("start.png");

        
        frame.show();
        gc.setFocusable(true);
        gc.setFocusTraversalKeysEnabled(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        gc.addKeyListener(listener);
        
        newt.setInitialLocation(70, 250);
        leib.setInitialLocation(1100, 250);

        
        while (count < 51) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.sendToBack();
        	startScreen.pause(50);
        	count++;
        }
        


        while (start == false) {
        	startScreen.pause(10);
        }

        
        while (count > 0) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.sendToBack();
        	startScreen.pause(50);
        	count--;
        }
        
        gc.remove(startScreen);
        gc.add(newt);
        gc.add(leib);
        
        gc.add(background);
        background.sendToBack();

        //making a newton bar --> the red background bar that 
        //stays the same throughout the game
        redRectNewt.setFilled(true);
        redRectNewt.setVisible(true);
        redRectNewt.setFillColor(java.awt.Color.RED);
        redRectNewt.sendToFront();
        gc.add(redRectNewt);
        System.out.println("printing: red newt bar");
        
        //making a libniez bar ---> the red background bar that
        //stays the same throughout the game
        redRectLib.setFilled(true);
        redRectLib.setVisible(true);
        redRectLib.setFillColor(java.awt.Color.RED);
        redRectLib.sendToFront();
        gc.add(redRectLib);
        System.out.println("printing: red lieb bar");

        //making newt green bar
        greenRectNewt.setFilled(true);
        greenRectNewt.setVisible(true);
        greenRectNewt.setFillColor(java.awt.Color.GREEN);
        greenRectNewt.sendToFront();
        gc.add(greenRectNewt);
        System.out.println("printing: green newt bar ");
        
        //making lieb green bar
        greenRectLib.setFilled(true);
        greenRectLib.setVisible(true);
        greenRectLib.setFillColor(java.awt.Color.GREEN);
        greenRectLib.sendToFront();
        gc.add(greenRectLib);
        System.out.println("printing: green lib bar");
        
        gc.add(new GImage("0.png", 100, 75));
	}
	
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
	
	public static void lowerHealthNewt()
	{
	    
	}
	
	public static void lowerHealthLib()
	{
	    
	}
}

