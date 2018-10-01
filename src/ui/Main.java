package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	
	public static final boolean debug = true;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("RangeSlider");
		frame.setSize(500, 100);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		JPanel p = new JPanel();
		// p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setLayout(new BorderLayout());
		JLabel label = new JLabel("Test");
		p.add(label, BorderLayout.SOUTH);
		label.setText("Current value");

		try {
			RangeSlider slider = new RangeSlider(0, 30, 10, 20);
			slider.setValue(0);

			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(5);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					label.setText("min/low/up/max: " + slider.getMinimum() + " / " + slider.getLowerBound() + " / " + slider.getUpperBound() + " / " + slider.getMaximum());
				}
			});
			
			p.add(slider);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		frame.getContentPane().add(p);
		frame.setVisible(true);
	}
}
