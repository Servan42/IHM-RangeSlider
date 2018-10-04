package ui;

import java.awt.BorderLayout;
import java.awt.Container;
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

	public static final boolean debug = false;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Home Seeker");
		frame.setSize(800, 600);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// CREATING THE OBJECTS
		ArrayList<Home> homeList = new ArrayList<Home>();
		for (int i = 0; i < 1000; i++) {
			homeList.add(new Home());
		}
		
		JLabel labelRoom = new JLabel("Between 2 and 8 rooms.");
		JLabel labelPrice = new JLabel("Between 100000 and 900000€.");
		try {
			RangeSlider sliderRoom = new RangeSlider(0, 2, 8, 10);
			sliderRoom.setMinorTickSpacing(1);
			sliderRoom.setMajorTickSpacing(5);
			sliderRoom.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					labelRoom.setText("Between " + sliderRoom.getLowerBound() + " and " + sliderRoom.getUpperBound() + " rooms.");
				}
			});

			RangeSlider sliderPrice = new RangeSlider(0, 100000, 900000, 1000000);
			sliderPrice.setMinorTickSpacing(100000);
			sliderPrice.setMajorTickSpacing(500000);
			sliderPrice.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					labelPrice.setText("Between " + sliderPrice.getLowerBound() + " and " + sliderPrice.getUpperBound() + "€.");
				}
			});

			Map map = new Map(homeList, sliderRoom, sliderPrice);

			// ORGANIZING THE INTERFACE
			JPanel mainBP = new JPanel();
			JPanel roomControlPanel = new JPanel();
			JPanel priceControlPanel = new JPanel();
			JPanel controlPanel = new JPanel();
			
			mainBP.setLayout(new BorderLayout());
			roomControlPanel.setLayout(new BoxLayout(roomControlPanel, BoxLayout.Y_AXIS));
			roomControlPanel.setPreferredSize(new Dimension(frame.getWidth()/2, 90));
			priceControlPanel.setLayout(new BoxLayout(priceControlPanel, BoxLayout.Y_AXIS));
			priceControlPanel.setPreferredSize(new Dimension(frame.getWidth()/2, 90));
			controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

			roomControlPanel.add(Box.createVerticalStrut(10));
			roomControlPanel.add(sliderRoom);
			roomControlPanel.add(Box.createVerticalStrut(10));
			roomControlPanel.add(labelRoom);
			roomControlPanel.add(Box.createVerticalStrut(10));
			
			priceControlPanel.add(Box.createVerticalStrut(10));
			priceControlPanel.add(sliderPrice);
			priceControlPanel.add(Box.createVerticalStrut(10));
			priceControlPanel.add(labelPrice);
			priceControlPanel.add(Box.createVerticalStrut(10));
			
			controlPanel.add(Box.createHorizontalStrut(10));
			controlPanel.add(roomControlPanel);
			controlPanel.add(Box.createHorizontalStrut(30));
			controlPanel.add(priceControlPanel);
			controlPanel.add(Box.createHorizontalStrut(10));
			
			mainBP.add(controlPanel, BorderLayout.SOUTH);
			mainBP.add(map);

			frame.getContentPane().add(mainBP);
			frame.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
