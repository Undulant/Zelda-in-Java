package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class OBJ_Bota extends SuperObjeto{
	
	PanelJuego pj;
	
	public OBJ_Bota(PanelJuego pj) {
		
		this.pj = pj;
		
		nombre = "Bota";
		try {
			
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/Bota.png"));
			uTool.scaleImage(imagen, pj.tamPantalla, pj.tamPantalla);
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		colision = true;
	}

}
