package ui;

public interface _RangeSlider {

	public int getMaximum();

	public int getMinimum();

	public int getLowerBound();

	public int getUpperBound();

	public void setMaximum(int max) throws Exception;

	public void setMinimum(int min) throws Exception;

	public void setLowerBound(int lowerBound);

	public void setUpperBound(int upperBound);

}
