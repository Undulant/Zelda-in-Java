package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class OBJ_Corazon extends SuperObjeto {
	
	PanelJuego pj;
	
	public OBJ_Corazon(PanelJuego pj) {
		
		this.pj = pj;
		
		nombre = "Corazon";
		try {
			
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/Corazon .png"));
			imagen2 = ImageIO.read(getClass().getResourceAsStream("/Objetos/Medio_Corazon.png"));
			imagen3 = ImageIO.read(getClass().getResourceAsStream("/Objetos/Corazon_Vacio.png"));
			imagen = uTool.scaleImage(imagen, pj.tamPantalla, pj.tamPantalla);
			imagen2 = uTool.scaleImage(imagen2, pj.tamPantalla, pj.tamPantalla);
			imagen3 = uTool.scaleImage(imagen3, pj.tamPantalla, pj.tamPantalla);

			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
