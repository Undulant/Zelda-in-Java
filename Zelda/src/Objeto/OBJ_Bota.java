package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bota extends SuperObjeto{
	
	public OBJ_Bota() {
		
		nombre = "Bota";
		try {
			
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/Bota.png"));
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		colision = true;
	}

}
