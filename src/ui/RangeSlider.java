package ui;

import javafx.scene.control.Slider;

public class RangeSlider extends Slider implements _RangeSlider {

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
