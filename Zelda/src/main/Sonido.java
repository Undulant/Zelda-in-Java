package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sonido() {
		
		soundURL[0] = getClass().getResource("/sonido/Musica_Menu.wav");
		soundURL[1] = getClass().getResource("/sonido/Musica_Mundo.wav");
		soundURL[2] = getClass().getResource("/sonido/coin.wav");
		soundURL[3] = getClass().getResource("/sonido/cursor.wav");
		soundURL[4] = getClass().getResource("/sonido/levelup.wav");
		soundURL[5] = getClass().getResource("/sonido/powerup.wav");
		soundURL[6] = getClass().getResource("/sonido/Musica_Boss.wav");

	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void play() {
		
		clip.start();
		
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void stop() {
		
		clip.stop();
		
	}
}
