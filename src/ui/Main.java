package ui;

import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("RangeSlider");
		frame.setSize(800, 600);
		frame.getContentPane().add(new RangeSlider());
		frame.setVisible(true);
	}
}
