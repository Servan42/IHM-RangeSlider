package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fc.Home;

public class Map extends JPanel {

	ArrayList<Home> homeList;
	RangeSlider sliderRoom;
	RangeSlider sliderPrice;

	public Map(ArrayList<Home> homeList, RangeSlider sliderRoom, RangeSlider sliderPrice) {
		this.homeList = homeList;
		this.sliderPrice = sliderPrice;
		this.sliderRoom = sliderRoom;
		this.sliderPrice.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				repaint();
			}
		});
		this.sliderRoom.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		if (Main.debug)
			System.out.println("-> On passe dans la methode Map.paintComponent().");
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(255, 0, 0));
		g.fillOval(20, 20, 75, 75);
		g.fillOval(60, 60, 75, 75);
	}
}
