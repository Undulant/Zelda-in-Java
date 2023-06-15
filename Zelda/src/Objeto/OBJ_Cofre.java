package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class OBJ_Cofre extends SuperObjeto{
	
	PanelJuego pj;
	
	public OBJ_Cofre(PanelJuego pj) {
		
		this.pj = pj;
		
		nombre = "Cofre";
		try {
			
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/Cofre.png"));
			uTool.scaleImage(imagen, pj.tamPantalla, pj.tamPantalla);
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		colision = true;
	}

}
