package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlTeclas implements KeyListener{
	
	public boolean upPresiono, downPresiono, leftPresiono, rightPresiono;

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		int controles = e.getKeyCode();
		
		if(controles == KeyEvent.VK_W) {
			upPresiono = true;		}
		if(controles == KeyEvent.VK_S) {
			downPresiono = true;
		}
		if(controles == KeyEvent.VK_A) {
			leftPresiono = true;
		}
		if(controles == KeyEvent.VK_D) {
			rightPresiono = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int controles = e.getKeyCode();
	
		if(controles == KeyEvent.VK_W) {
			upPresiono = false;
		}
		if(controles == KeyEvent.VK_S) {
			downPresiono = false;
		}
		if(controles == KeyEvent.VK_A) {
			leftPresiono = false;
		}
		if(controles == KeyEvent.VK_D) {
			rightPresiono = false;
		}
		
	}

}
