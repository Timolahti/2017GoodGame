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

public class Game extends acm.program.GraphicsProgram
{
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 720;
		int count = 0;
		
	    GCanvas gc = new GCanvas();
	    gc.setBackground(java.awt.Color.BLACK);
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        
        frame.getContentPane().add(BorderLayout.CENTER, gc);
        GImage startScreen = new GImage("start.png");
        
        frame.show();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
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
	
	private class newton extends GImage
	{

		public newton(Image image, double x, double y) {
			super(image, x, y);
			// TODO Auto-generated constructor stub
		}
		//main class for player character, contains movements, fighting and health
	}
	
	private class leibniz extends newton 
	{

		public leibniz(Image image, double x, double y) {
			super(image, x, y);
			// TODO Auto-generated constructor stub
		}
		//overrides newton presets for starting direction, placement and assets but is otherwise the same 
	}
	
	private class healthbar extends GObject
	{

		@Override
		public GRectangle getBounds() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected void paint2d(Graphics2D g) {
			// TODO Auto-generated method stub
			
		}
		//Contains the 
	}
}
