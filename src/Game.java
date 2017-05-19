import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator
import java.applet.*;      // AudioClip
import java.awt.*;         // Color
import java.awt.event.*;   // MouseEvent

import javax.swing.JFrame;

public class Game
{
	public static void main(String[] args) 
	{
	    GCanvas gc = new GCanvas();
        JFrame frame = new JFrame();
        frame.getContentPane().add(BorderLayout.CENTER, gc);
        GRect square = new GRect(100, 100, 200, 200);
        square.setFilled(true);
        square.setColor(Color.RED);
        gc.add(square);
        frame.show();
	}
}
