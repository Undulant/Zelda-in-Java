package main;

import Entidades.Entidad;

public class AdministradorColision {
	
	PanelJuego pj;
	
	public AdministradorColision(PanelJuego pj) {
		this.pj = pj;
	}
	
	public void revisarTile(Entidad entidad) {
		
		int entidadLeftMundoX = entidad.mundoX + entidad.hitBox.x;
		int entidadRightMundoX = entidad.mundoX + entidad.hitBox.x + entidad.hitBox.width;
		int entidadTopMundoY = entidad.mundoY + entidad.hitBox.y;
		int entidadBottomMundoY = entidad.mundoY + entidad.hitBox.y + entidad.hitBox.height;
		
		int entidadLeftCol = entidadLeftMundoX/pj.tamPantalla;
		int entidadRightCol = entidadRightMundoX/pj.tamPantalla;
		int entidadTopFila = entidadTopMundoY/pj.tamPantalla;
		int entidadBottomFila = entidadBottomMundoY/pj.tamPantalla;
		
		int tileNum1, tileNum2;
		
		switch(entidad.direccion) {
		case "arriba":
			entidadTopFila = (entidadTopMundoY - entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[pj.mapaActual][entidadLeftCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[pj.mapaActual][entidadRightCol][entidadTopFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "abajo":
			entidadBottomFila = (entidadBottomMundoY + entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[pj.mapaActual][entidadLeftCol][entidadBottomFila];
			tileNum2 = pj.tileM.numTileMap[pj.mapaActual][entidadRightCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "izquierda":
			entidadLeftCol = (entidadLeftMundoX - entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[pj.mapaActual][entidadLeftCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[pj.mapaActual][entidadLeftCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "derecha":
			entidadRightCol = (entidadRightMundoX + entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[pj.mapaActual][entidadRightCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[pj.mapaActual][entidadRightCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		}
	}
	
	public int revisarObjeto(Entidad entidad, boolean jugador) {
		
		int index = 999;
		
		for(int i = 0; i < pj.obj.length; i++) {
			
			if(pj.obj[i] != null) {
				
				//OBTIENE LA POSICION DE LA HIT BOX DE LA ENTIDAD
				entidad.hitBox.x = entidad.mundoX + entidad.hitBox.x;
				entidad.hitBox.y = entidad.mundoY + entidad.hitBox.y;
				
				//OBTIENE LA POSICION DE LA HIT BOX DEL OBJETO
				pj.obj[i].hitBox.x = pj.obj[i].mundoX + pj.obj[i].hitBox.x;
				pj.obj[i].hitBox.y = pj.obj[i].mundoY + pj.obj[i].hitBox.y;
				
				switch(entidad.direccion) {
				case "arriba":
					entidad.hitBox.y -= entidad.velocidad;
					if(entidad.hitBox.intersects(pj.obj[i].hitBox)) {
						if(pj.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "abajo":
					entidad.hitBox.y += entidad.velocidad;
					if(entidad.hitBox.intersects(pj.obj[i].hitBox)) {
						if(pj.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "izquierda":
					entidad.hitBox.x -= entidad.velocidad;
					if(entidad.hitBox.intersects(pj.obj[i].hitBox)) {
						if(pj.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				case "derecha":
					entidad.hitBox.x += entidad.velocidad;
					if(entidad.hitBox.intersects(pj.obj[i].hitBox)) {
						if(pj.obj[i].colision == true) {
							entidad.colisionOn = true;
						}
						if(jugador == true) {
							index = i;
						}
					}
					break;
				}
				entidad.hitBox.x = entidad.hitBoxDefaultX;
				entidad.hitBox.y = entidad.hitBoxDefaultY;
				pj.obj[i].hitBox.x = pj.obj[i].hitBoxDefaultX;
				pj.obj[i].hitBox.y = pj.obj[i].hitBoxDefaultY;

			}
		}
		
		return index;
		
	}
}
