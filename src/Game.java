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
	private static Player newt = new Player("Newt.png", 300, 480);
	private static Player leib = new Player("Leib.png", 1280 - 300, 480);
	
	private static boolean newtIsPunching = false;
	private static boolean leibIsPunching = false;
	private static boolean start = false;
	
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 750;
		int count = 0;
		
		KeyListener listener = new KeyListener() {	//key control commands
			
		    public void keyPressed(KeyEvent e) {
		    	int id = e.getKeyCode();	//this is all to test the key listeners
//		        if (id == KeyEvent.VK_E) {
//		        	
//		        }
		    	switch (id) {
		    		case KeyEvent.VK_SPACE: start = true;
			    	case KeyEvent.VK_A: newt.move(-5);
			    	case KeyEvent.VK_D: newt.move(5);
			    	case KeyEvent.VK_W: newt.jump(""); //jump image in making
			    	case KeyEvent.VK_S: {
			    		newt.setImage(""); //crouching image still in making
			    	}
			    	case KeyEvent.VK_F: {
			    		newt.punch("", newtIsPunching); //punch image in making
			    		
			    	}
		    	}
		    }

			@Override
			public void keyTyped(KeyEvent e) {
				// Ignore
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Ignore
				
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
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        gc.addKeyListener(listener);
        
        gc.add(newt);
        gc.add(leib);
        
        while (count < 51) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.pause(50);
        	count++;
        }
        
        while (start == false) {
        	startScreen.pause(1);
        }
        
        while (count > 0) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.pause(50);
        	count--;
        }
        
        gc.remove(startScreen);
        
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
	
}

