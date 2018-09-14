package ui;

import java.awt.event.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("RangeSlider");
		frame.setSize(800, 600);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		try {
			frame.getContentPane().add(new RangeSlider(0,10,5,6));
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setVisible(true);
	}
}
