package ui;

import javax.swing.JSlider;

public class RangeSlider extends JSlider implements _RangeSlider {

	private int max;
	private int min;
	private int lowerBound;
	private int upperBound;
	
	public RangeSlider(int min, int max, int lowerBound, int upperBound) throws Exception{
		if(min > max || upperBound > max || upperBound < min){
			throw new Exception("Incorrect Slider values in constructor.");
		}
		this.max = max;
		this.min = min;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
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
	public void setMaximum(int max) throws Exception {
		if (max < min)
			throw new Exception("INCORRECT_MAX_GIVEN");

		this.max = max;
		if (max < upperBound)
			upperBound = max;
		if (max < lowerBound)
			lowerBound = max;
	}

	@Override
	public void setMinimum(int min) throws Exception {
		if (min > max)
			throw new Exception("INCORRECT_MIN_GIVEN");

		this.min = min;
		if (min > upperBound)
			upperBound = min;
		if (min > lowerBound)
			lowerBound = min;
	}

	@Override
	public void setLowerBound(int lowerBound) {
		if (lowerBound < min)
			this.lowerBound = min;
		else if (lowerBound > upperBound)
			this.lowerBound = upperBound;
		else
			this.lowerBound = lowerBound;
	}

	@Override
	public void setUpperBound(int upperBound) {
		if (upperBound > max)
			this.upperBound = max;
		else if (upperBound < lowerBound)
			this.upperBound = lowerBound;
		else
			this.upperBound = upperBound;
	}

}
