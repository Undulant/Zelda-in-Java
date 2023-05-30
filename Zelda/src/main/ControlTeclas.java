package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlTeclas implements KeyListener{
	
	PanelJuego pj;
	public boolean upPresiono, downPresiono, leftPresiono, rightPresiono;

	public ControlTeclas(PanelJuego pj) {
		this.pj = pj;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int controles = e.getKeyCode();

		
		if(pj.estadoJuego == pj.estadoMenu) {
			
			if(controles == KeyEvent.VK_W || controles == KeyEvent.VK_UP) {
				pj.ui.flechaSeleccion--;
				if(pj.ui.flechaSeleccion < 0) {
					pj.ui.flechaSeleccion = 2;
				}
			}
			if(controles == KeyEvent.VK_S || controles == KeyEvent.VK_DOWN) {
				pj.ui.flechaSeleccion++;
				if(pj.ui.flechaSeleccion > 2) {
					pj.ui.flechaSeleccion = 0;
				}
			}
			if(controles == KeyEvent.VK_ENTER) {
				if(pj.ui.flechaSeleccion == 0) {
					pj.estadoJuego = pj.estadoJugar;
				}
				if(pj.ui.flechaSeleccion == 1) {
					//AGREGAR MAS TARDE
				}
				if(pj.ui.flechaSeleccion == 2) {
					System.exit(0);
				}
			}
		}
		
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
