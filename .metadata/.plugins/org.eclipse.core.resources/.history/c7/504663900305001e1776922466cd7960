package Objeto;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.PanelJuego;

public class SuperObjeto {
	
	public BufferedImage imagen;
	public String nombre;
	public boolean colision = false;
	public int mundoX, mundoY;
	public Rectangle hitBox = new Rectangle(0, 0, 48, 48);
	public int hitBoxDefaultX = 0;
	public int hitBoxDefaultY = 0;
	
	public void dibujar(Graphics2D g2, PanelJuego pj) {
		
		int camaraX = mundoX - pj.jugador.mundoX + pj.jugador.camaraX;
		int camaraY = mundoY - pj.jugador.mundoY + pj.jugador.camaraY;
		
		if(mundoX + pj.tamPantalla > pj.jugador.mundoX - pj.jugador.camaraX &&
		   mundoX - pj.tamPantalla < pj.jugador.mundoX + pj.jugador.camaraX &&
		   mundoY + pj.tamPantalla > pj.jugador.mundoY - pj.jugador.camaraY &&
		   mundoY - pj.tamPantalla < pj.jugador.mundoY + pj.jugador.camaraY) {
		
		g2.drawImage(imagen, camaraX, camaraY, pj.tamPantalla, pj.tamPantalla, null);
		
		}
		
	}
}
