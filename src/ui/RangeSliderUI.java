package ui;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI {
	private RangeSlider rs;
	private ChangeListener listener = new ChangeListener() { public void stateChanged(ChangeEvent ce) {Update();} };
	
	public RangeSliderUI(RangeSlider arg0) {
		super(arg0);
		rs = arg0;
		rs.addChangeListener(listener);
	}

	private void Update() {
		
	}
}
