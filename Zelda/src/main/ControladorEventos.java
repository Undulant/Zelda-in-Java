package main;

public class ControladorEventos {
	
	PanelJuego pj;
	RectEvento rectEvento [][][];
	
	int eventoPrevioX, eventoPrevioY;
	boolean canTocarEvento = true;

	public ControladorEventos(PanelJuego pj) {
		
		this.pj = pj;
		
		rectEvento = new RectEvento[pj.maxMap][pj.maxColMundo][pj.maxFilMundo];
		
		int mapa = 0;
		int col = 0;
		int fila = 0;
		
		while(mapa < pj.maxMap && col < pj.maxColMundo && fila < pj.maxFilMundo) {
			
			rectEvento[mapa][col][fila] = new RectEvento();
			rectEvento[mapa][col][fila].x = 23;
			rectEvento[mapa][col][fila].y = 23;
			rectEvento[mapa][col][fila].width = 2;
			rectEvento[mapa][col][fila].height = 2;
			rectEvento[mapa][col][fila].rectEventoDefaultX = rectEvento[mapa][col][fila].x;
			rectEvento[mapa][col][fila].rectEventoDefaultY = rectEvento[mapa][col][fila].y;
			
			col++;
			if(col == pj.maxColMundo) {
				col = 0;
				fila++;
				
				if(fila == pj.maxFilMundo) {
					fila = 0;
					mapa++;
				}
			}
		}
	}
	
	public void revisarEvento() {
		
		int xDistancia = Math.abs(pj.jugador.mundoX - eventoPrevioX);
		int yDistancia = Math.abs(pj.jugador.mundoY - eventoPrevioY);
		int distancia = Math.max(xDistancia, yDistancia);
		if(distancia > pj.tamPantalla) {
			canTocarEvento = true;
		}
		
		if(canTocarEvento == true) {
			
			if(hit(0, 30, 11,"any") == true) {teleport(1, 1, 10);}
			else if(hit(1,1,10,"any") == true) {teleport(0, 30, 11);}
			
			else if(hit(1,9,1,"any") == true) {teleport(2, 9, 22);}
			else if(hit(2,9,22,"any") == true) {teleport(1, 9, 1);}
			
			else if(hit(1,28,22,"any") == true) {teleport(3, 17, 1);}
			else if(hit(3,17, 1,"any") == true) {teleport(1, 28, 22);}
		
		}
	}
	
	public boolean hit(int mapa, int col, int fila, String reqDireccion) {
		
		boolean hit = false;
		
		if(mapa == pj.mapaActual) {
			
			pj.jugador.hitBox.x = pj.jugador.mundoX + pj.jugador.hitBox.x;
			pj.jugador.hitBox.y = pj.jugador.mundoY + pj.jugador.hitBox.y;
			rectEvento[mapa][col][fila].x = col*pj.tamPantalla + rectEvento[mapa][col][fila].x;
			rectEvento[mapa][col][fila].y = fila*pj.tamPantalla + rectEvento[mapa][col][fila].y;
			
			if(pj.jugador.hitBox.intersects(rectEvento[mapa][col][fila]) && rectEvento[mapa][col][fila].eventoHecho == false) {
				if(pj.jugador.direccion.contentEquals(reqDireccion) || reqDireccion.contentEquals("any") ) {
					hit = true;
					
					eventoPrevioX = pj.jugador.mundoX;
					eventoPrevioY = pj.jugador.mundoY;
				}
			}
			
			pj.jugador.hitBox.x = pj.jugador.hitBoxDefaultX;
			pj.jugador.hitBox.y = pj.jugador.hitBoxDefaultY;
			rectEvento[mapa][col][fila].x = rectEvento[mapa][col][fila].rectEventoDefaultX;
			rectEvento[mapa][col][fila].y = rectEvento[mapa][col][fila].rectEventoDefaultY;
			
		}
		
		return hit;
		
	}
	
	public void teleport(int mapa, int col, int fila) {
		
		pj.mapaActual = mapa;
		pj.jugador.mundoX = pj.tamPantalla * col;
		pj.jugador.mundoY = pj.tamPantalla * fila;
		eventoPrevioX = pj.jugador.mundoX;
		eventoPrevioY = pj.jugador.mundoY;
		canTocarEvento = false;
		pj.playSE(3);
		
	}
	
}
