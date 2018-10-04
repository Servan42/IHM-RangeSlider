package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fc.Home;

public class Main {

	public static final boolean debug = true;
	public static int perimetre = 500;
	private static ArrayList<Home> homeList = new ArrayList<Home>();

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
		JLabel label = new JLabel("Test");
		label.setText("Current value");
		try {
			RangeSlider slider1 = new RangeSlider(0, 2, 8, 10);
			slider1.setPreferredSize(new Dimension(10, 10));
			slider1.setPaintTicks(true);
			slider1.setPaintLabels(true);
			slider1.setMinorTickSpacing(1);
			slider1.setMajorTickSpacing(5);
			slider1.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					label.setText("min/low/up/max: " + slider1.getMinimum() + " / " + slider1.getLowerBound() + " / "
							+ slider1.getUpperBound() + " / " + slider1.getMaximum());
				}
			});

			RangeSlider slider2 = new RangeSlider(0, 100000, 900000, 1000000);
			slider2.setPaintTicks(true);
			slider2.setPaintLabels(true);
			slider2.setMinorTickSpacing(100000);
			slider2.setMajorTickSpacing(500000);

			// ORGANIZING THE INTERFACE
			JPanel sliderPanel = new JPanel();
			sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

			JPanel mainBP = new JPanel();
			mainBP.setLayout(new BorderLayout());

			sliderPanel.add(slider1);
			sliderPanel.add(slider2);

			mainBP.add(label, BorderLayout.SOUTH);
			mainBP.add(sliderPanel, BorderLayout.LINE_END);

			for (int i = 0; i < 100; i++) {
				homeList.add(new Home());
			}
			mainBP.add(new Map(homeList));

			frame.getContentPane().add(mainBP);
			frame.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
