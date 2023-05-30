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
			tileNum1 = pj.tileM.numTileMap[entidadLeftCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[entidadRightCol][entidadTopFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "abajo":
			entidadBottomFila = (entidadBottomMundoY + entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[entidadLeftCol][entidadBottomFila];
			tileNum2 = pj.tileM.numTileMap[entidadRightCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "izquierda":
			entidadLeftCol = (entidadLeftMundoX - entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[entidadLeftCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[entidadLeftCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		case "derecha":
			entidadRightCol = (entidadRightMundoX + entidad.velocidad)/pj.tamPantalla;
			tileNum1 = pj.tileM.numTileMap[entidadRightCol][entidadTopFila];
			tileNum2 = pj.tileM.numTileMap[entidadRightCol][entidadBottomFila];
			if(pj.tileM.tile[tileNum1].colision == true || pj.tileM.tile[tileNum2].colision == true) {
				entidad.colisionOn = true;
			}
			break;
		}
	}
}
