package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fc.Home;

public class Main {

	public static final boolean debug = true;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("RangeSlider");
		frame.setSize(800, 600);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// CREATING THE OBJECTS
		ArrayList<Home> homeList = new ArrayList<Home>();
		for (int i = 0; i < 100; i++) {
			homeList.add(new Home());
		}
		JLabel label = new JLabel("Test");
		label.setText("Current value");
		try {
			RangeSlider sliderRoom = new RangeSlider(0, 2, 8, 10);
			sliderRoom.setMinorTickSpacing(1);
			sliderRoom.setMajorTickSpacing(5);
			sliderRoom.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					label.setText("min/low/up/max: " + sliderRoom.getMinimum() + " / " + sliderRoom.getLowerBound()
							+ " / " + sliderRoom.getUpperBound() + " / " + sliderRoom.getMaximum());
				}
			});

			RangeSlider sliderPrice = new RangeSlider(0, 100000, 900000, 1000000);
			sliderPrice.setMinorTickSpacing(100000);
			sliderPrice.setMajorTickSpacing(500000);

			Map map = new Map(homeList, sliderRoom, sliderPrice);

			// ORGANIZING THE INTERFACE
			JPanel sliderPanel = new JPanel();
			sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

			JPanel mainBP = new JPanel();
			mainBP.setLayout(new BorderLayout());

			sliderPanel.add(sliderRoom);
			// sliderPanel.add(Box.createRigidArea(new Dimension(10,5)));
			sliderPanel.add(sliderPrice);
			mainBP.add(label, BorderLayout.SOUTH);
			mainBP.add(sliderPanel, BorderLayout.LINE_END);
			mainBP.add(map);

			frame.getContentPane().add(mainBP);
			frame.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
