import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.Graphics2D;

public class healthBarNewton extends GRect {
    public healthBarNewton(double arg0, double arg1, double arg2, double arg3) {
        super(arg0, arg1, arg2, arg3);
        GRect backRect = new GRect (100,100, 100, 30);
        backRect.setFillColor(java.awt.Color.RED);
        // TODO Auto-generated constructor stub
    }

    @Override
    public GRectangle getBounds() {
        // TODO Auto-generated method stub
        return null;
    }
    
    

    @Override
    protected void paint2d(Graphics2D g) {
        // TODO Auto-generated method stub
        
    }
}
