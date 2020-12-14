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
	 * �����Ψһ���
	 */
	public static void main(String[] args) {
		String filepath="music/planebg.wav";
		MusicStuff musicStuff=new MusicStuff();
		musicStuff.playMusic(filepath);
		
		//��������
//		Music music=new Music();
		GameJFrame gj=new GameJFrame();
		/**ʵ������壬ע�뵽jframe��*/
		GameJPanel jp=new GameJPanel();	
//		ʵ��������
		GameListener listener=new GameListener();
//		ʵ�������߳�
		GameThread th=new GameThread();
//		ע��
		
		

		
		gj.setjPanel(jp);
		gj.setMouseListener(listener);
		gj.setMouseMotionListener(listener);
		gj.setThead(th);
		//ע������
//		gj.setMusicThead(music);
		gj.start();
		
		
	}

}
