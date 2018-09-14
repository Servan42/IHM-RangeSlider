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
	public void addChangeListener(_ChangeListener x) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMaximum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLowerBound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUpperBound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeChangeListener(_ChangeListener x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaximum(int max) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimum(int min) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLowerBound(int lowerBound) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpperBound(int upperBound) {
		// TODO Auto-generated method stub

	}

}
