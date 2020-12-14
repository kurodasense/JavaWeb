package com.plane.show;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.plane.loader.GameLoad;


/**
 * @˵�� �̳�JFrame����Ϸ�Ĵ��壬����������ʾ���桢��Ӽ����������̵߳Ȳ�����
 * @author 1205918114
 * 		1.���󶨵�����
 *      2.������
 *      3.��Ϸ���߳�����
 *      4.��ʾ����
 */
public class GameJFrame extends JFrame{
	public static int GameX = 500;//���ڵĿ� 
	public static int GameY = 800;//���ڵĸ�
	private JPanel jPanel =null; //������ʾ�����
	private KeyListener  keyListener=null;//���̼���
	private MouseMotionListener mouseMotionListener=null; //������
	private MouseListener mouseListener=null;
	private Thread thead=null;  //��Ϸ���߳�
	private JPanel startJPanel = null;//��ʼ����
	private JPanel endJPanel = null;//��������
	private JButton startButton = null;//��ʼ��ť
	private JLabel jl = null;//����������ʾ��������Ϸ����"�ɻ���ս"��"�ɹ�"��"ʧ��"
//	private Thread musicThread=null;//�����߳�
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public GameJFrame() {
		init();
	}
	/**
	 * @˵�� �ı�JLabel����������
	 * @param str
	 */
	public void setJLText(String str) {
		jl.setText(str);
	}
	
	/**
	 * ʵ�������ϵĹ��췽��
	 */
	public void init() {
		this.setSize(GameX, GameY); //���ô����С
		this.setTitle("��ɻ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳����ҹر�
		this.setLocationRelativeTo(null);//��Ļ������ʾ
//		startButton = new JButton("��ʼ��Ϸ");
//		startButton.setBounds(190,450,100,21);
//		startButton.addActionListener(new ActionListener() {//���"��ʼ��Ϸ"
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		this.add(startButton);
//		jl = new JLabel();
//		jl.setBounds(40, 200, 500, 300);
//		jl.setFont(new Font("΢���ź�", Font.PLAIN, 100));
//		jl.setForeground(Color.red);
//		this.add(jl);   
	}
	/**
	 * @˵�� ����Ĳ��֡������������ť
	 */
	public void addButton() {
		this.setLayout(null);//���ָ�ʽ
	}
	/**
	 * @˵�� �������������
	 */
	public void start() {
		if(jPanel!=null) {
			this.add(jPanel);
		}
		if(startJPanel != null) {
			this.add(startJPanel);
		}
		if(endJPanel != null) {
			this.add(endJPanel);
		}
		if(keyListener !=null) {
			this.addKeyListener(keyListener);
		}
		if(mouseMotionListener!=null){
			this.addMouseMotionListener(mouseMotionListener);
		}
		if(mouseListener!=null){
			this.addMouseListener(mouseListener);
		}
		if(thead !=null) {
			thead.start();//�����߳�
		}
		//�����߳�����
//		if(musicThread!=null) {
//			musicThread.start();
//		}
		this.setVisible(true);//��ʾ����
		if(this.jPanel instanceof Runnable) {
			Runnable run=(Runnable)this.jPanel;
			Thread th=new Thread(run);
			th.start();// 
			System.out.println("����");
		}
	}
	/**
	 * @˵�� ��ʾ��ǩ
	 */
	public void showJL() {
		jl.setVisible(true);
	}
	/**
	 * @˵�� ���ر�ǩ
	 */
	public void hideJL() {
		jl.setVisible(false);
	}
	/**
	 * @˵�� ��ʾ"��ʼ��ť"
	 */
	public void showStartButton() {
		startButton.setVisible(true);
	}
	/**
	 * @˵�� ����"��ʼ��ť"
	 */
	public void hideStartButton() {
		startButton.setVisible(false);
	}
	/**
	 * @˵�� ��ʾ��ʼ���汳��ͼ
	 */
	public void showStartJPanel() {
		startJPanel.setVisible(true);
	}
	/**
	 * @˵�� ���ؿ�ʼ���汳��ͼ
	 */
	public void hideStartJPanel() {
		startJPanel.setVisible(false);
	}
	/**
	 * @˵�� ��ʾ�������汳��ͼ
	 */
	public void showEndJPanel() {
		endJPanel.setVisible(true);
	}
	/**
	 * @˵�� ���ؽ������汳��ͼ
	 */
	public void hideEndJPanel() {
		endJPanel.setVisible(false);
	}
	/**
	 * @˵�� ����JPanel������Ϸ���
	 * @param jPanel
	 */
	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	/**
	 * @˵�� ���ü��̼�����
	 * @param keyListener
	 */
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	/**
	 * @˵�� ����������������
	 * @param mouseMotionListener
	 */
	public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	/**
	 * @˵�� ������������������갴�¡��ͷš����������롢�뿪
	 * @param mouseListener
	 */
	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	/**
	 * @˵�� ������Ϸ���߳�
	 * @param thead
	 */
	public void setThead(Thread thead) {
		this.thead = thead;
	}
	public void setStartJPanel(JPanel startJPanel) {
		this.startJPanel = startJPanel;
	}
	public void setEndJPanel(JPanel endJPanel) {
		this.endJPanel = endJPanel;
	}
	//���������߳�
//	public void setMusicThead(Thread thread) {
//		this.musicThread=thread;
//	}
}
