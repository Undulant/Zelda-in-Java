package main;

import Objeto.OBJ_Cofre;
import Objeto.OBJ_Llave;

public class AssetSetter {
	
	PanelJuego pj;
	
	public AssetSetter(PanelJuego pj) {
		this.pj = pj;
	}
	
	public void setObjeto() {
		
		pj.obj[0] = new OBJ_Llave();
		pj.obj[0].mundoX = 4 * pj.tamPantalla;
		pj.obj[0].mundoY = 4 * pj.tamPantalla;
		
		pj.obj[1] = new OBJ_Llave();
		pj.obj[1].mundoX = 5 * pj.tamPantalla;
		pj.obj[1].mundoY = 5 * pj.tamPantalla;
		
		pj.obj[2] = new OBJ_Cofre();
		pj.obj[2].mundoX = 5 * pj.tamPantalla;
		pj.obj[2].mundoY = 8 * pj.tamPantalla;
	}
}