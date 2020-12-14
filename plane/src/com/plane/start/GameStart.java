package com.plane.start;

import com.plane.controller.GameListener;
import com.plane.controller.GameThread;
import com.plane.element.Music;
import com.plane.element.MusicStuff;
import com.plane.show.EndJPanel;
import com.plane.show.GameJFrame;
import com.plane.show.GameJPanel;
import com.plane.show.StartJPanel;



public class GameStart {
	/**
	 * 程序的唯一入口
	 */
	public static void main(String[] args) {
		String filepath="music/planebg.wav";
		MusicStuff musicStuff=new MusicStuff();
		musicStuff.playMusic(filepath);
		
		//创建音乐
//		Music music=new Music();
		GameJFrame gj=new GameJFrame();
		/**实例化面板，注入到jframe中*/
		GameJPanel jp=new GameJPanel();	
//		实例化监听
		GameListener listener=new GameListener();
//		实例化主线程
		GameThread th=new GameThread();
//		注入
		
		

		
		gj.setjPanel(jp);
		gj.setMouseListener(listener);
		gj.setMouseMotionListener(listener);
		gj.setThead(th);
		//注入音乐
//		gj.setMusicThead(music);
		gj.start();
		
		
	}

}
