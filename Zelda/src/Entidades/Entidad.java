package Entidades;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidad {
	
	public int mundoX, mundoY;
	public int velocidad;
	
	public BufferedImage abajo0, abajo1, abajo2, arriba0, arriba1, arriba2, derecha0, derecha1, derecha2, izquierda0, izquierda1, izquierda2;
	
	public String direccion;
	
	public int contadorSprite = 0;
	public int numSprite = 1;
	
	public Rectangle hitBox;
	public int hitBoxDefaultX, hitBoxDefaultY;
	public boolean colisionOn = false;
	
	public int vidaMax;
	public int vida;

}
