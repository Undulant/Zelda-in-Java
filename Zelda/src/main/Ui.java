package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import Objeto.OBJ_Corazon;
import Objeto.SuperObjeto;

public class Ui {
	
	PanelJuego pj;
	Graphics2D g2;
	Font webFont, interstellar;
	BufferedImage corazonLleno, corazonMedio, corazonVacio;
	public int flechaSeleccion = 0;
	
	public Ui(PanelJuego pj) {
		
		this.pj = pj;
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/001 Interstellar Log Regular.ttf");
			interstellar = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/font/000webfont Regular.ttf");
			webFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		SuperObjeto corazon = new OBJ_Corazon(pj);
		corazonLleno = corazon.imagen;
		corazonMedio = corazon.imagen2;
		corazonVacio = corazon.imagen3; 
		
	}


	public void dibujar(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(webFont);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setColor(Color.white);
		
		if(pj.estadoJuego == pj.estadoMenu) {
			dibujaMenu();
		}
		if(pj.estadoJuego == pj.estadoJugar) {
			dibujaVidaJugador();
		}
		if(pj.estadoJuego == pj.estadoPausa) {
			dibujaVidaJugador();
			dibujarPantallaPausa();
		}
	}
	
	public void dibujar2(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(webFont);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setColor(Color.white);
		
		if(pj.estadoJuego == pj.estadoMenu) {
			dibujaMenu2();
		}
	}
	
	public void dibujaVidaJugador() {
		
		int x = pj.tamPantalla/2;
		int y = pj.tamPantalla/2;
		int i = 0;
		
		//DIBUJA LA VIDA MAXIMA
		while(i < pj.jugador.vidaMax/2) {
			
			g2.drawImage(corazonVacio, x, y, null);
			i++;
			x += pj.tamPantalla;
			
		}
		
		x = pj.tamPantalla/2;
		y = pj.tamPantalla/2;
		i = 0;
		
		//DIBUJA LA VIDA ACTUAL
		while(i < pj.jugador.vida) {
			
			g2.drawImage(corazonMedio, x, y, null);
			i++;
			if(i < pj.jugador.vida) {
				g2.drawImage(corazonLleno, x, y, null);
			}
			i++;
			x += pj.tamPantalla;
		}
		
	}
	
	private void dibujaMenu() {
		
		//COLOR DE FONDO DEL MENU
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0, 0, pj.anchoPantalla, pj.alturaPantalla);
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
		String text = "The Legend of Zelda";
		int x = getXparaCentrarTexto(text);
		int y = pj.tamPantalla*3;
		
		//SOMBRA
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//IMAGEN DE LINK
		x = pj.anchoPantalla/2 - (pj.tamPantalla*2)/2;
		y += pj.tamPantalla*2;
		g2.drawImage(pj.jugador.abajo1, x, y, pj.tamPantalla*2, pj.tamPantalla*2, null);
		
	}

	private void dibujaMenu2() {
		
		//MENU
		int y = pj.tamPantalla*5;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,45F));
			
		String text = "Nuevo Partida";
		int x = getXparaCentrarTexto(text);
		y += pj.tamPantalla*3.5;
		g2.drawString(text, x, y);
		if(flechaSeleccion == 0) {
			g2.drawString(">", x-pj.tamPantalla, y);
		}
		
		text = "Cargar Partida";
		x = getXparaCentrarTexto(text);
		y += pj.tamPantalla;
		g2.drawString(text, x, y);
		if(flechaSeleccion == 1) {
			g2.drawString(">", x-pj.tamPantalla, y);
		}
			
		text = "Salir";
		x = getXparaCentrarTexto(text);
		y += pj.tamPantalla;
		g2.drawString(text, x, y);
		if(flechaSeleccion == 2) {
			g2.drawString(">", x-pj.tamPantalla, y);
		}
	}
	
	public void dibujarPantallaPausa() {
		
		String texto = "PAUSA";
		int x = getXparaCentrarTexto(texto);
		int y = pj.alturaPantalla/2;
		
		g2.drawString(texto, x, y);
		
	}

	private int getXparaCentrarTexto(String text) {
		
		int longitud = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = pj.anchoPantalla/2 - longitud/2;
		return x;
	}	

}
