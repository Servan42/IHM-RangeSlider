package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import fc.Home;

public class Map extends JPanel {
	ArrayList<Home> quartier;

	public Map(ArrayList<Home> quartier) {
		this.quartier = quartier;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(new Color(255, 0, 0));
		for (Home maison : quartier) {
			if(maison.getRoomNumber() < sliderRoom.getLowerBound() || maison.getRoomNumber() > sliderRoom.getUpperBound() || maison.getPrice()() < sliderPrice.getLowerBound() || maison.getPrice() < sliderPrice.getUpperBound())
				continue;
			
			g.fillOval(maison.getPosX()*this.getWidth()/Main.perimetre, maison.getPosY()*this.getHeight()/Main.perimetre, 10, 10);
		}
	}
}
