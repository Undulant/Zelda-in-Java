package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entidades.Jugador;
import Objeto.SuperObjeto;
import tiles.AdministradoTile;

public class PanelJuego extends JPanel implements Runnable {
	
	//CONFIGURACIONES DE PANTALLA
	final int escalaOriginal = 16; //16x16 CUADROS
	final int escala = 3;
	
	public final int tamPantalla = escalaOriginal * escala; //48x48 CUADROS
	public final int maxColPantalla = 16;
	public final int maxFilPantalla = 12;
	public final int anchoPantalla = tamPantalla * maxColPantalla; // 768 PIXELES
	public final int alturaPantalla = tamPantalla * maxFilPantalla; // 576 PIXELES
	
	//CONFIGURACIONES DEL MUNDO
	public final int maxColMundo = 32;
	public final int maxFilMundo = 24;
	public final int anchoMundo = tamPantalla * maxColMundo;
	public final int alturaMundo = tamPantalla * maxFilMundo;

	
	//FPSSSSSSSSSSSSSSSSSSSSSSSSS
	int FPS = 60;
	
	AdministradoTile tileM = new AdministradoTile(this);
	ControlTeclas teclas = new ControlTeclas(this);
	Thread hiloJuego;
	public AdministradorColision aColision = new AdministradorColision(this);
	public Jugador jugador = new Jugador(this,teclas);
	public Ui ui = new Ui(this);
	public SuperObjeto obj[] = new SuperObjeto[10];
	public AssetSetter aSetter = new AssetSetter(this);
	
	//ESTADO DEL JUEGO
	public int estadoJuego;
	public final int estadoMenu = 0;
	public final int estadoJugar = 1;

	
	//RESPAWN DEL JUGADOR
	/*int jugadorX = 100;
	int jugadorY = 100;
	int jugadorVelocidad = 4;*/
	
	//CONTROLADOR DE PANTALLA
	public PanelJuego(){
		
		this.setPreferredSize(new Dimension(anchoPantalla, alturaPantalla));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(teclas);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		aSetter.setObjeto();
	}
	
	public void setupJuego() {
		estadoJuego = estadoMenu;
	}
	
	public void iniciarHiloJuego() {
		
		hiloJuego = new Thread(this);
		hiloJuego.start();
	}
	
	//LOOP
	@Override
	public void run() {
		
		//CONTROL DE FPSSSSSSSSSSS 1
		double intervaloDibujado = 1000000000/FPS;
		double tiempoDibujado = System.nanoTime() + intervaloDibujado;
		
		while(hiloJuego !=null) {
			
			/*long currentTiempo = System.nanoTime();
			System.out.println("Tiempo: "+currentTiempo);*/
			
			//1 ACTUALIZA: ACTUALIZA LA INFORMACION COMO LA POSICION DEL PERSONAJE
			actualizar();
			
			//2 DRAW: DIBUJA EN PANTALLA LA ACTUALIZACION DE INFORMACION
			repaint();
			
		//CONTROL DE FPSSSSSSSSSS 2
		try {
			double tiempoRestante = tiempoDibujado - System.nanoTime();
			tiempoRestante = tiempoRestante/1000000;
			
			if(tiempoRestante < 0) {
				tiempoRestante = 0;
			}
			
			Thread.sleep((long) tiempoRestante);
			
			tiempoDibujado += intervaloDibujado;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
	
	//MOVIMIENTO DEL JUGADOR
	public void actualizar() {
		
		jugador.actualizar();
	}
	
	public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//MENU
		if(estadoJuego == estadoMenu) {
			
			ui.dibujar(g2);
			ui.dibujar2(g2);
			
		}else {
			
			//PRIMERO SE VA DIBUJAR LO QUE ESTE ARRIBA
			tileM.dibuja(g2);
			
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					obj[i].dibujar(g2, this);
				}
			}
			
			jugador.dibujar(g2);
			
		}
		
	
		g2.dispose();
	}
	
	
	
}
