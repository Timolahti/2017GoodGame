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

public class Game
{
	public static void main(String[] args) 
	{
		int width = 1280;
		int height = 720;
		
	    GCanvas gc = new GCanvas();
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        
        frame.getContentPane().add(BorderLayout.CENTER, gc);
        GImage startScreen = new GImage("start.png");
        gc.add(startScreen);
        frame.show();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
	}
}
