package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Map extends JPanel {
	
	public Map() {
		
	}
	
	public void paintComponent(Graphics g){
	    g.setColor(new Color(0,0,0));
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    g.setColor(new Color(255, 0, 0));
	    g.fillOval(20, 20, 75, 75);
	    g.fillOval(60, 60, 75, 75);
	  } 
}
