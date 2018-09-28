package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


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

			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			JLabel label = new JLabel("Test");
			p.add(label);
			label.setText("Coucou");
			
			try {
				RangeSlider slider = new RangeSlider(0,30,10,20);
				slider.addChangeListener(new ChangeListener() {
					
					public void stateChanged(ChangeEvent e) {
						label.setText(new Integer(slider.getValue()).toString());
						
					}
				});
				
				p.add(slider);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.getContentPane().add(p);

		
		
		frame.setVisible(true);
	}
}
