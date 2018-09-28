package ui;

import java.awt.event.MouseEvent;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class Handler {
	private enum State { IDLE, HOLD, DRAG }
	
	private State state;
	private RangeSlider rangeSlider;
	private boolean heldBound; // true = max, false = min
	
	public void Handle(MouseEvent e) {
		switch(state) {
		case IDLE:
			switch(e.getID()) {
			case MouseEvent.MOUSE_PRESSED:
				// TP BORNE CORRESPONDANTE + VALEUR
				// ASSIGNER BORNE SAISIE
				state = State.HOLD;
				break;
			default:;
			}
			break;
		case HOLD:
			switch(e.getID()) {
			case MouseEvent.MOUSE_MOVED:
				// BOUGER BORNE SAISIE + VALEUR
				state = State.DRAG;
				break;
			case MouseEvent.MOUSE_RELEASED:
				state = State.IDLE;
			default:;
			}
			break;
		case DRAG:
			switch(e.getID()) {
			case MouseEvent.MOUSE_MOVED:
				// BOUGER BORNE SAISIE + VALEUR
				break;
			case MouseEvent.MOUSE_RELEASED:
				state = State.IDLE;
			default:;
			}
			break;
		default:;
		}
	}
	
}
