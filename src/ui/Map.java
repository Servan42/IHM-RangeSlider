package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fc.Home;

import fc.Home;

public class Map extends JPanel {
	ArrayList<Home> quartier;
	RangeSlider sliderRoom;
	RangeSlider sliderPrice;

	public Map(ArrayList<Home> quartier, RangeSlider sliderRoom, RangeSlider sliderPrice) {
		this.quartier = quartier;
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

	@Override
	public void paintComponent(Graphics g) {
		if (Main.debug)
			System.out.println("-> On passe dans la methode Map.paintComponent().");

		g.setColor(new Color(4,139,34));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(new Color(40,20,10));
		for (Home maison : quartier) {
			if (maison.getRoomNumber() < sliderRoom.getLowerBound()
					|| maison.getRoomNumber() > sliderRoom.getUpperBound()
					|| maison.getPrice() < sliderPrice.getLowerBound()
					|| maison.getPrice() > sliderPrice.getUpperBound())
				continue;
			
			g.fillOval(maison.getPosX() * this.getWidth() / Home.perimetre,
					maison.getPosY() * this.getHeight() / Home.perimetre, 10, 10);
		}
	}
}
