package ui;

public interface _RangeSlider {

	public void addChangeListener(_ChangeListener x);

	public int getMaximum();

	public int getMinimum();

	public int getLowerBound();

	public int getUpperBound();

	public void removeChangeListener(_ChangeListener x);

	public void setMaximum(int max);

	public void setMinimum(int min);

	public void setLowerBound(int lowerBound);

	public void setUpperBound(int upperBound);

}
