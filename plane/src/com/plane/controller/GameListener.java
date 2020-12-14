package com.plane.controller;

import com.plane.element.ElementObj;
import com.plane.manager.*;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GameListener implements MouseListener,MouseMotionListener{
	
	private ElementManager em=ElementManager.getManager();

//	private Set<Integer> set=new HashSet<Integer>();
	boolean bot1=false;

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		List<ElementObj> play=em.getElementsByKey(GameElement.PLAY);
		for(ElementObj obj:play)
		{
			obj.mousePosition(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
