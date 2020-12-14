package com.plane.element;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicStuff {
	public void playMusic(String musicLocation) {
		File musicPath=new File(musicLocation);
		
		if(musicPath.exists()) {
			try {
				AudioInputStream audioInput=AudioSystem.getAudioInputStream(musicPath);
				try {
					Clip clip=AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (LineUnavailableException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			} catch (UnsupportedAudioFileException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			
		}
	}
}
