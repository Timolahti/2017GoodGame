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
	private static GImage background = new GImage("Background.jpg");
	private static Player newt = new Player("Newt.png", 70, 250);
	private static Player leib = new Player("Leib.png", 1100, 250);
	
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 750;
		int count = 0;
		
		KeyListener listener = new KeyListener() {	//key control commands
			
		    public void keyPressed(KeyEvent e) {
		    	int id = e.getID();	//this is all to test the key listeners
		        String keyString;
		        if (id == KeyEvent.KEY_PRESSED) {
		            char c = e.getKeyChar();
		            keyString = "key character = '" + c + "'";
		            if (e.equals('e')) {
		            }
		        }
		        else keyString = "";
		        System.out.println(keyString);
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
        
        gc.add(newt);
        gc.add(leib);
        
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
        
        //spacebar start code
        startScreen.pause(2000);
        
        while (count > 0) {
        	setOpacity(startScreen, count*5);
        	gc.add(startScreen);
        	startScreen.pause(50);
        	count--;
        }
        
        gc.remove(startScreen);
        
        gc.add(background);

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

