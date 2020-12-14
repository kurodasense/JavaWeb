package com.plane.show;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.plane.loader.GameLoad;

public class StartJPanel extends JPanel{

	private Image im = null;

	public StartJPanel()
	{
	   this.im= new ImageIcon("image/Index/6.jpg").getImage();
	   this.setOpaque(true);
	   
	}

	public void paintComponent(Graphics g)
	{
	   super.paintComponents(g);
	   g.drawImage(im,0,0,500,700,this);
	}

}
