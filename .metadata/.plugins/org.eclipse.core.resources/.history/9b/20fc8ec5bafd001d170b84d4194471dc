package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		//VENTANA
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventana.pack();
		ventana.setResizable(false);
		ventana.setTitle("La leyenda de melda");
		
		PanelJuego panelJuego = new PanelJuego();
		ventana.add(panelJuego);
		
		ventana.pack();
		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		//LOOP
		panelJuego.iniciarHiloJuego();
	}

}
