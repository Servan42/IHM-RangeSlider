package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI {
	private RangeSlider rs;
	private ChangeListener listener = new ChangeListener() { public void stateChanged(ChangeEvent ce) {Update();} };
	private Rectangle minThumb;
	
	public RangeSliderUI(RangeSlider arg0) {
		super(arg0);
		rs = arg0;
		//rs.addChangeListener(listener);
		minThumb = new Rectangle();
	}

	private void Update() {
		System.out.println("NOT IMPLEMENTED YET - ui.RangeSliderUI.Update()");
	}
	
	@Override
	public void paintThumb(Graphics g) {
		super.paintThumb(g);
		
	}
}
