package com.plane.show;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndJPanel extends JPanel{
	private Image im = null;

	public EndJPanel()
	{
	   this.im= new ImageIcon("image/Index/4.jpg").getImage();
	   this.setOpaque(true);
	}

	public void paintComponent(Graphics g)
	{
	   super.paintComponents(g);
	   g.drawImage(im,0,0,500,700,this);
	}
}
