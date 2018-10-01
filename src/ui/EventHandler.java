//package ui;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//
//public class EventHandler implements MouseListener, MouseMotionListener {
//	private enum State {
//		IDLE, HOLD, DRAG
//	}
//
//	private State state = State.IDLE;
//
//	@Override
//	public void mousePressed(MouseEvent arg0) {
//		switch (state) {
//		case IDLE:
//			if(Main.debug) System.out.println("IDLE+PRESSED");
//			// TP BORNE CORRESPONDANTE + VALEUR
//			// ASSIGNER BORNE SAISIE
//			state = State.HOLD;
//			break;
//		default:
//			;
//		}
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent arg0) {
//		switch (state) {
//		case HOLD:
//			if(Main.debug)  System.out.println("HOLD+RELEASED");
//			state = State.IDLE;
//			break;
//		case DRAG:
//			if(Main.debug)  System.out.println("DRAG+RELEASED");
//			state = State.IDLE;
//			break;
//		default:
//			;
//		}
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		mouseMoved(e);
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		switch (state) {
//		case HOLD:
//			if(Main.debug)  System.out.println("HOLD+MOVED");
//			// BOUGER BORNE SAISIE + VALEUR
//			state = State.DRAG;
//			break;
//		case DRAG:
//			if(Main.debug)  System.out.println("DRAG+MOVED");
//			// BOUGER BORNE SAISIE + VALEUR
//			break;
//		default:
//			;
//		}
//	}
//	
//	@Override
//	public void mouseClicked(MouseEvent arg0) {
//		if(Main.debug) System.out.println("EventHandler.mouseClicked() not implemented.");
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent arg0) {
//		if(Main.debug) System.out.println("EventHandler.mouseEntered() not implemented.");
//	}
//
//	@Override
//	public void mouseExited(MouseEvent arg0) {
//		if(Main.debug) System.out.println("EventHandler.mouseExited() not implemented.");
//	}
//
//}
