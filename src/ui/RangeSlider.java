package ui;

import java.awt.Dimension;

import javax.swing.JSlider;

public class RangeSlider extends JSlider implements _RangeSlider {

	private int max;
	private int min;
	private int lowerBound;
	private int upperBound;

	public RangeSlider(int min, int lowerBound, int upperBound, int max) throws Exception {
		super();
		if (min > max || upperBound > max || upperBound < min) {
			throw new Exception("ERROR : Incorrect Slider values in constructor.");
		}
		this.max = max;
		this.min = min;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.setUI(new RangeSliderUI(this));
		this.setPaintLabels(true);
		this.setPaintTicks(true);
		removeMouseMotionListener(getMouseMotionListeners()[1]);
		removeMouseListener(getMouseListeners()[1]);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getMaximum() {
		return max;
	}

	@Override
	public int getMinimum() {
		return min;
	}

	@Override
	public int getLowerBound() {
		return lowerBound;
	}

	@Override
	public int getUpperBound() {
		return upperBound;
	}

	@Override
	public void setMaximum(int max) {
		if (max >= min)
			this.max = max;
		if (max < upperBound)
			upperBound = max;
		if (max < lowerBound)
			lowerBound = max;
		fireStateChanged();
		repaint();
	}

	@Override
	public void setMinimum(int min) {
		if (min <= max)
			this.min = min;
		if (min > upperBound)
			upperBound = min;
		if (min > lowerBound)
			lowerBound = min;
		fireStateChanged();
		repaint();
	}

	@Override
	public void setLowerBound(int lowerBound) {
		if (lowerBound < min)
			this.lowerBound = min;
		else if (lowerBound > upperBound)
			this.lowerBound = upperBound;
		else
			this.lowerBound = lowerBound;
		fireStateChanged();
		repaint();
	}

	@Override
	public void setUpperBound(int upperBound) {
		if (upperBound > max)
			this.upperBound = max;
		else if (upperBound < lowerBound)
			this.upperBound = lowerBound;
		else
			this.upperBound = upperBound;
		fireStateChanged();
		repaint();
	}

}
