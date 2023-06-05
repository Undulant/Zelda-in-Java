package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class AdministradoTile {
	
	PanelJuego pj;
	public Tile[] tile;
	public int numTileMap[][];
	
	public AdministradoTile(PanelJuego pj) {
		
		this.pj = pj;
		
		tile = new Tile[25];
		numTileMap = new int[pj.maxColMundo][pj.maxFilMundo];
		
		getImagenTile();
		cargaMapa("/maps/Prueba_Mundo.txt");
	}
	
	public void getImagenTile() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/PISO 2.png"));
			
			tile[1] = new Tile();
			tile[1].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/PISO 1.png"));
			
			tile[2] = new Tile();
			tile[2].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ABAJO IZQUIERDA.png"));
			tile[2].colision = true;
			
			tile[3] = new Tile();
			tile[3].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ABAJO CENTRO.png"));
			tile[3].colision = true;
			
			tile[4] = new Tile();
			tile[4].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ABAJO DERECHApng.png"));
			tile[4].colision = true;
			
			tile[5] = new Tile();
			tile[5].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK MEDIO IZQUIERDA.png"));
			tile[5].colision = true;
			
			tile[6] = new Tile();
			tile[6].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK MEDIO CENTROpng.png"));
			tile[6].colision = true;
			
			tile[7] = new Tile();
			tile[7].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK MEDIO DERECHApng.png"));
			tile[7].colision = true;
			
			tile[8] = new Tile();
			tile[8].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ARRIBA IZQUIERDA.png"));
			tile[8].colision = true;
			
			tile[9] = new Tile();
			tile[9].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ARRIBA CENTROpng.png"));
			tile[9].colision = true;
			
			tile[10] = new Tile();
			tile[10].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CASA LINK ARRIBA DERECHA.png"));
			tile[10].colision = true;
			
			tile[11] = new Tile();
			tile[11].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CAMINO 1.png"));
			
			tile[12] = new Tile();
			tile[12].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/CAMINO 3.png"));
			
			tile[13] = new Tile();
			tile[13].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/Arbol_Left_Abajo.png"));
			tile[13].colision = true;
			
			tile[14] = new Tile();
			tile[14].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/Arbol_Right_Abajo.png"));
			tile[14].colision = true;
			
			tile[15] = new Tile();
			tile[15].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/Arbol_Left_Arriba.png"));
			tile[15].colision = true;
			
			tile[16] = new Tile();
			tile[16].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/Arbol_Right_Arriba.png"));
			tile[16].colision = true;
			
			tile[17] = new Tile();
			tile[17].imagen = ImageIO.read(getClass().getResourceAsStream("/tiles/Arbusto.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargaMapa(String rutaArchivo) {
		
		try {
			//EXPORTA EL MAPA
			InputStream map1 = getClass().getResourceAsStream(rutaArchivo);
			//LEE EL MAPA
			BufferedReader br = new BufferedReader(new InputStreamReader(map1));
			
			int col = 0;
			int fil = 0;
			
			while(col < pj.maxColMundo && fil < pj.maxFilMundo) {
				
				String linea = br.readLine();
				
				while(col < pj.maxColMundo) {
					
					String numeros[] = linea.split(" ");
					
					int num = Integer.parseInt(numeros[col]);
					
					numTileMap[col][fil] = num;
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
			
			int numTile = numTileMap[colMundo][filMundo];
			
			int mundoX = colMundo * pj.tamPantalla;
			int mundoY = filMundo * pj.tamPantalla;
			int camaraX = mundoX - pj.jugador.mundoX + pj.jugador.camaraX;
			int camaraY = mundoY - pj.jugador.mundoY + pj.jugador.camaraY;
			
			if(mundoX + pj.tamPantalla > pj.jugador.mundoX - pj.jugador.camaraX &&
			   mundoX - pj.tamPantalla < pj.jugador.mundoX + pj.jugador.camaraX &&
			   mundoY + pj.tamPantalla > pj.jugador.mundoY - pj.jugador.camaraY &&
			   mundoY - pj.tamPantalla < pj.jugador.mundoY + pj.jugador.camaraY) {
			
			g2.drawImage(tile[numTile].imagen, camaraX, camaraY, pj.tamPantalla, pj.tamPantalla, null);
			
			}
			
			colMundo++;
			
			if(colMundo == pj.maxColMundo) {
				colMundo = 0;
				filMundo++;
			}
		}

	}
	
}
