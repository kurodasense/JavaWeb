package com.plane.element;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Music extends Thread{
	private File f;
	private URI uri;
	private URL url;
	
	@Override
	public void run() {
		f=new File("music/planebg.wav");
		uri=f.toURI();
		try {
			url=uri.toURL();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AudioClip aau;
		aau=Applet.newAudioClip(url);
		aau.loop();
		System.out.println("music");
	}
	
}
