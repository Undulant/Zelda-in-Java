package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class OBJ_Llave extends SuperObjeto{
	
	PanelJuego pj;
	
	public OBJ_Llave(PanelJuego pj) {
		
		this.pj = pj;
		
		nombre = "Llave";
		try {
			
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/Llave.png"));
			uTool.scaleImage(imagen, pj.tamPantalla, pj.tamPantalla);
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
