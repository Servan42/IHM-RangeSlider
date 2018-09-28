package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class RangeSliderUI extends BasicSliderUI {
	private enum State { IDLE, HOLD, DRAG }
	
	
	private RangeSlider rs;
	private ChangeListener listener = new ChangeListener() { public void stateChanged(ChangeEvent ce) {Update();} };
	private Rectangle minThumb;
	
	public RangeSliderUI(RangeSlider arg0) {
		super(arg0);
		rs = arg0;
		//rs.addChangeListener(listener);
		minThumb = new Rectangle(10, 20);
	}

	private void Update() {
		System.out.println("NOT IMPLEMENTED YET - ui.RangeSliderUI.Update()");
	}
	
	@Override
	public void paintThumb(Graphics g) {
		super.paintThumb(g);
		
		Rectangle knobBounds = minThumb;
        int w = knobBounds.width;
        int h = knobBounds.height;

        g.translate(knobBounds.x, knobBounds.y);
        
        g.setColor(rs.getBackground());
        
        Boolean paintThumbArrowShape =
                (Boolean)rs.getClientProperty("Slider.paintThumbArrowShape");
        
        int cw = w / 2;
        g.fillRect(1, 1, w-3, h-1-cw);
        Polygon p = new Polygon();
        p.addPoint(1, h-cw);
        p.addPoint(cw-1, h-1);
        p.addPoint(w-2, h-1-cw);
        g.fillPolygon(p);

        g.setColor(getHighlightColor());
        g.drawLine(0, 0, w-2, 0);
        g.drawLine(0, 1, 0, h-1-cw);
        g.drawLine(0, h-cw, cw-1, h-1);

        g.setColor(Color.black);
        g.drawLine(w-1, 0, w-1, h-2-cw);
        g.drawLine(w-1, h-1-cw, w-1-cw, h-1);

        g.setColor(getShadowColor());
        g.drawLine(w-2, 1, w-2, h-2-cw);
        g.drawLine(w-2, h-1-cw, w-1-cw, h-2);
        
        g.translate(-knobBounds.x, -knobBounds.y);
	}
	
	// Used exclusively by setThumbLocation()
    private static Rectangle unionRect2 = new Rectangle();

    public void setMinThumbLocation(int x, int y)  {
        unionRect2.setBounds( minThumb );

        minThumb.setLocation( x, y );

        SwingUtilities.computeUnion( minThumb.x, minThumb.y, minThumb.width, minThumb.height, unionRect2 );
        slider.repaint( unionRect2.x, unionRect2.y, unionRect2.width, unionRect2.height );
    }
    
    @Override
    public void setThumbLocation(int x, int y) {
    	super.setThumbLocation(x, y);
    	setMinThumbLocation(x+5, y);
    }
    
    
    
    
}
