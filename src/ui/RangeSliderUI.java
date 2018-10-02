package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI {
	private enum State {
		IDLE, HOLD, DRAG
	}

	private RangeSlider rs;

	private Rectangle lowerThumb;
	private Rectangle upperThumb;

	public RangeSliderUI(RangeSlider arg0) {
		super(arg0);
		rs = arg0;
		EventHandler handler = new EventHandler();
		rs.addMouseListener(handler);
		rs.addMouseMotionListener(handler);
		lowerThumb = new Rectangle(10, 20);
		upperThumb = new Rectangle(10, 20);
	}

	@Override
	protected void calculateThumbLocation() {
		int lowerPosition = xPositionForValue(rs.getUpperBound());
		int upperPosition = xPositionForValue(rs.getLowerBound());

		lowerThumb.x = lowerPosition - (lowerThumb.width / 2);
		lowerThumb.y = trackRect.y;

		upperThumb.x = upperPosition - (upperThumb.width / 2);
		upperThumb.y = trackRect.y;
	}

	@Override
	public void paintThumb(Graphics g) {
		if (Main.debug)
			System.out.println("-> On passe dans la methode RangeSliderUI.paintThumb()");

		paintOneThumb(g, lowerThumb);
		paintOneThumb(g, upperThumb);
	}

	private void paintOneThumb(Graphics g, Rectangle thumb) {
		Rectangle knobBounds = thumb;
		int w = knobBounds.width;
		int h = knobBounds.height;

		g.translate(knobBounds.x, knobBounds.y);

		g.setColor(rs.getBackground());

		Boolean paintThumbArrowShape = (Boolean) rs.getClientProperty("Slider.paintThumbArrowShape");

		int cw = w / 2;
		g.fillRect(1, 1, w - 3, h - 1 - cw);
		Polygon p = new Polygon();
		p.addPoint(1, h - cw);
		p.addPoint(cw - 1, h - 1);
		p.addPoint(w - 2, h - 1 - cw);
		g.fillPolygon(p);

		g.setColor(getHighlightColor());
		g.drawLine(0, 0, w - 2, 0);
		g.drawLine(0, 1, 0, h - 1 - cw);
		g.drawLine(0, h - cw, cw - 1, h - 1);

		g.setColor(Color.black);
		g.drawLine(w - 1, 0, w - 1, h - 2 - cw);
		g.drawLine(w - 1, h - 1 - cw, w - 1 - cw, h - 1);

		g.setColor(getShadowColor());
		g.drawLine(w - 2, 1, w - 2, h - 2 - cw);
		g.drawLine(w - 2, h - 1 - cw, w - 1 - cw, h - 2);

		g.translate(-knobBounds.x, -knobBounds.y);
	}

	@Override
	public void calculateTrackRect() {
		// YO SERVAN, LA-DEDANS çA CALCULE LA TAILLE DE LA TRACK, BON COURAGE
		////
		////
		////
		////
		// STP LIS çA, ET SI TU PREFERES ON PEUT Y TRAVAILLER CE SOIR
		
		int centerSpacing = thumbRect.height;
        if ( slider.getPaintTicks() ) centerSpacing += getTickLength();
        if ( slider.getPaintLabels() ) centerSpacing += getHeightOfTallestLabel();
        trackRect.x = contentRect.x + trackBuffer;
        trackRect.y = contentRect.y + (contentRect.height - centerSpacing - 1)/2;
        trackRect.width = contentRect.width - (trackBuffer * 2);
        trackRect.height = thumbRect.height;
	}
	
	// Used exclusively by setXThumbLocation()
	private static Rectangle unionRect2 = new Rectangle();
	private static Rectangle unionRect3 = new Rectangle();

	public void setLowerThumbLocation(int x, int y) {
		unionRect2.setBounds(lowerThumb);

		lowerThumb.setLocation(x, y);

		SwingUtilities.computeUnion(lowerThumb.x, lowerThumb.y, lowerThumb.width, lowerThumb.height, unionRect2);
		slider.repaint(unionRect2.x, unionRect2.y, unionRect2.width, unionRect2.height);
	}

	public void setUpperThumbLocation(int x, int y) {
		unionRect3.setBounds(upperThumb);

		upperThumb.setLocation(x, y);

		SwingUtilities.computeUnion(upperThumb.x, upperThumb.y, upperThumb.width, upperThumb.height, unionRect3);
		slider.repaint(unionRect3.x, unionRect3.y, unionRect3.width, unionRect3.height);
	}

	public class EventHandler implements MouseListener, MouseMotionListener {

		private State state = State.IDLE;
		private boolean heldCursor; // True: Upper Cursor | False: Lower Cursor.

		public EventHandler() {
			rs.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					calculateThumbLocation();
					rs.repaint();
				}
			});
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			switch (state) {
			case IDLE:
				if (Main.debug)
					System.out.println("IDLE+PRESSED");
				// TP BORNE CORRESPONDANTE + VALEUR
				int valueClicked = valueForXPosition(arg0.getX());
				if (Main.debug)
					System.out.println("EventHandler.mousePressed.valueClicked : " + valueClicked);
				heldCursor = Math.abs(valueClicked - rs.getUpperBound()) < Math.abs(valueClicked - rs.getLowerBound());
				// ASSIGNER BORNE SAISIE
				if (heldCursor)
					rs.setUpperBound(valueClicked);
				else
					rs.setLowerBound(valueClicked);
				state = State.HOLD;
				break;
			default:
				;
			}

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			switch (state) {
			case HOLD:
				if (Main.debug)
					System.out.println("HOLD+RELEASED");
				state = State.IDLE;
				break;
			case DRAG:
				if (Main.debug)
					System.out.println("DRAG+RELEASED");
				state = State.IDLE;
				break;
			default:
				;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mouseMoved(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			switch (state) {
			case HOLD:
				if (Main.debug)
					System.out.println("HOLD+MOVED");
				// BOUGER BORNE SAISIE + VALEUR
				state = State.DRAG;
				//break;
			case DRAG:
				if (Main.debug)
					System.out.println("DRAG+MOVED");
				// BOUGER BORNE SAISIE + VALEUR
				int mousePos = valueForXPosition(e.getX());
				if (heldCursor)
					rs.setUpperBound(mousePos);
				else
					rs.setLowerBound(mousePos);
				break;
			default:
				;
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (Main.debug)
				System.out.println("EventHandler.mouseClicked() not implemented.");

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			if (Main.debug)
				System.out.println("EventHandler.mouseEntered() not implemented.");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if (Main.debug)
				System.out.println("EventHandler.mouseExited() not implemented.");
		}

	}
}
