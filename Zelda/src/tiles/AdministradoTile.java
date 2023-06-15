package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PanelJuego;
import main.UtilityTool;

public class AdministradoTile {
	int juego;
	String mensajes;
	PanelJuego pj;
	public Tile[] tile;
	public int numTileMap[][][]; 
	
	public AdministradoTile(PanelJuego pj) {
		
		this.pj = pj;
		
		tile = new Tile[49];
		numTileMap = new int[pj.maxMap][pj.maxColMundo][pj.maxFilMundo];
		
		getImagenTile();
		cargaMapa("/maps/Prueba_Mundo.txt", 0);
		cargaMapa("/maps/Mapa_Camino.txt", 1);
		cargaMapa("/maps/Mapa_Bosque.txt", 2);
		cargaMapa("/maps/Mapa_Boss.txt", 3);
	}
	
	public void getImagenTile() {
		
			
			setup(0, "PISO 2", false);
			setup(1, "PISO 1", false);
			setup(2, "CASA LINK ABAJO IZQUIERDA", true);
			setup(3, "CASA LINK ABAJO CENTRO", true);
			setup(4, "CASA LINK ABAJO DERECHApng", true);
			setup(5, "CASA LINK MEDIO IZQUIERDA", true);
			setup(6, "CASA LINK MEDIO CENTROpng", true);
			setup(7, "CASA LINK MEDIO DERECHApng", true);
			setup(8, "CASA LINK ARRIBA IZQUIERDA", true);
			setup(9, "CASA LINK ARRIBA CENTROpng", true);
			setup(10, "CASA LINK ARRIBA DERECHA", true);
			setup(11, "CAMINO 1", false);
			setup(12, "CAMINO 3", false);
			setup(13, "Arbol_Left_Abajo", true);
			setup(14, "Arbol_Right_Abajo", true);
			setup(15, "Arbol_Left_Arriba", true);
			setup(16, "Arbol_Right_Arriba", true);
			setup(17, "Arbusto", true);
			setup(18, "Pared_Abajo", true);
			setup(19, "Pared_Arriba", true);
			setup(20, "CAMINO 8", false);
			setup(21, "CAMINO 9", false);
			setup(22, "W_Pasto", false);
			setup(23, "A_Pasto", false);
			setup(24, "S_Pasto", false);
			setup(25, "D_Pasto", false);
			setup(26, "Lago_26", true);
			setup(27, "Lago_27", true);
			setup(28, "Lago_28", false);
			setup(29, "Lago_29", true);
			setup(30, "Lago_30", true);
			setup(31, "Lago_31", true);
			setup(32, "Lago_32", false);
			setup(33, "Lago_33", true);
			setup(34, "Lago_34", true);
			setup(35, "Lago_35", true);
			setup(36, "Lago_36", false);
			setup(37, "Lago_37", true);
			setup(38, "CAMINO 10", false);
			setup(39, "CAMINO 11", false);
			setup(40, "CAMINO 5", false);
			setup(41, "ARBUSTO IZQUIERDA", true);
			setup(42, "ARBUSTO MEDIO", true);
			setup(43, "ARBUSTO DERECHA", true);
			setup(44, "ENEMIGO CANGREJO", true);
			setup(45, "ENEMIGO CANGREJO2", true);
			setup(46, "ENEMIGO COBRA", true);
			setup(47, "ENEMIGO COBRA2", true);
			setup(48, "Cofre", true);

			
	
	}
	
	public void setup(int index, String imagenName, boolean colision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			
			tile[index] = new Tile();
			tile[index].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imagenName +".png"));
			tile[index].imagen = uTool.scaleImage(tile[index].imagen, pj.tamPantalla, pj.tamPantalla);
			tile[index].colision = colision;
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void cargaMapa(String rutaArchivo, int map) {
		
		try {
			//EXPORTA EL MAPA
			InputStream is = getClass().getResourceAsStream(rutaArchivo);
			//LEE EL MAPA
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int fil = 0;
			
			while(col < pj.maxColMundo && fil < pj.maxFilMundo) {
				
				String linea = br.readLine();
				
				while(col < pj.maxColMundo) {
					
					String numeros[] = linea.split(" ");
					
					int num = Integer.parseInt(numeros[col]);
					
					numTileMap[map][col][fil] = num;
					col++;
				}
				if(col == pj.maxColMundo) {
					col = 0;
					fil++;
				}
			}
			br.close();
		}
		catch(Exception e) {
			
		}
		
		
		
	}
	
	public void dibuja(Graphics2D g2) {
		
		//g2.drawImage(tile[0].imagen, 0, 0, pj.tamPantalla, pj.tamPantalla, null);
		
		int colMundo = 0;
		int filMundo = 0;

		while(colMundo < pj.maxColMundo && filMundo < pj.maxFilMundo) {
			
			int numTile = numTileMap[pj.mapaActual][colMundo][filMundo];
			
			int mundoX = colMundo * pj.tamPantalla;
			int mundoY = filMundo * pj.tamPantalla;
			int camaraX = mundoX - pj.jugador.mundoX + pj.jugador.camaraX;
			int camaraY = mundoY - pj.jugador.mundoY + pj.jugador.camaraY;
			

			if(mundoX + pj.tamPantalla > pj.jugador.mundoX - pj.jugador.camaraX &&
			   mundoX - pj.tamPantalla < pj.jugador.mundoX + pj.jugador.camaraX &&
			   mundoY + pj.tamPantalla > pj.jugador.mundoY - pj.jugador.camaraY &&
			   mundoY - pj.tamPantalla < pj.jugador.mundoY + pj.jugador.camaraY) {
			
			g2.drawImage(tile[numTile].imagen, camaraX, camaraY, null);
			
			}
			
			
			colMundo++;
			
			if(colMundo == pj.maxColMundo) {
				colMundo = 0;
				filMundo++;
			}
		}

	}
	
}
