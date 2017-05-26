import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.Graphics2D;

public class healthBarNewton extends GRect {
    public healthBarNewton(double arg0, double arg1, double arg2, double arg3) {
        super(arg0, arg1, arg2, arg3);
        GRect backRectNewt = new GRect (100,100, 100, 30);
        backRectNewt.setFillColor(java.awt.Color.RED);
        backRectNewt.sendToBack();
        System.out.println("Newton healthNewt bar print");
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
