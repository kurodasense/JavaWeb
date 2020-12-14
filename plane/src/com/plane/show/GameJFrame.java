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
 * @说明 继承JFrame，游戏的窗体，用于载入显示界面、添加监听、启动线程等操作。
 * @author 1205918114
 * 		1.面板绑定到窗体
 *      2.监听绑定
 *      3.游戏主线程启动
 *      4.显示窗体
 */
public class GameJFrame extends JFrame{
	public static int GameX = 500;//窗口的宽 
	public static int GameY = 800;//窗口的高
	private JPanel jPanel =null; //正在显示的面板
	private KeyListener  keyListener=null;//键盘监听
	private MouseMotionListener mouseMotionListener=null; //鼠标监听
	private MouseListener mouseListener=null;
	private Thread thead=null;  //游戏主线程
	private JPanel startJPanel = null;//开始界面
	private JPanel endJPanel = null;//结束界面
	private JButton startButton = null;//开始按钮
	private JLabel jl = null;//文字内容显示。例如游戏标题"飞机大战"、"成功"、"失败"
//	private Thread musicThread=null;//音乐线程
	/**
	 * 默认构造方法
	 */
	public GameJFrame() {
		init();
	}
	/**
	 * @说明 改变JLabel的文字内容
	 * @param str
	 */
	public void setJLText(String str) {
		jl.setText(str);
	}
	
	/**
	 * 实际意义上的构造方法
	 */
	public void init() {
		this.setSize(GameX, GameY); //设置窗体大小
		this.setTitle("打飞机");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出并且关闭
		this.setLocationRelativeTo(null);//屏幕居中显示
//		startButton = new JButton("开始游戏");
//		startButton.setBounds(190,450,100,21);
//		startButton.addActionListener(new ActionListener() {//点击"开始游戏"
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		this.add(startButton);
//		jl = new JLabel();
//		jl.setBounds(40, 200, 500, 300);
//		jl.setFont(new Font("微软雅黑", Font.PLAIN, 100));
//		jl.setForeground(Color.red);
//		this.add(jl);   
	}
	/**
	 * @说明 窗体的布局。会添加启动按钮
	 */
	public void addButton() {
		this.setLayout(null);//布局格式
	}
	/**
	 * @说明 窗体的启动方法
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
			thead.start();//启动线程
		}
		//音乐线程启动
//		if(musicThread!=null) {
//			musicThread.start();
//		}
		this.setVisible(true);//显示界面
		if(this.jPanel instanceof Runnable) {
			Runnable run=(Runnable)this.jPanel;
			Thread th=new Thread(run);
			th.start();// 
			System.out.println("启动");
		}
	}
	/**
	 * @说明 显示标签
	 */
	public void showJL() {
		jl.setVisible(true);
	}
	/**
	 * @说明 隐藏标签
	 */
	public void hideJL() {
		jl.setVisible(false);
	}
	/**
	 * @说明 显示"开始按钮"
	 */
	public void showStartButton() {
		startButton.setVisible(true);
	}
	/**
	 * @说明 隐藏"开始按钮"
	 */
	public void hideStartButton() {
		startButton.setVisible(false);
	}
	/**
	 * @说明 显示开始界面背景图
	 */
	public void showStartJPanel() {
		startJPanel.setVisible(true);
	}
	/**
	 * @说明 隐藏开始界面背景图
	 */
	public void hideStartJPanel() {
		startJPanel.setVisible(false);
	}
	/**
	 * @说明 显示结束界面背景图
	 */
	public void showEndJPanel() {
		endJPanel.setVisible(true);
	}
	/**
	 * @说明 隐藏结束界面背景图
	 */
	public void hideEndJPanel() {
		endJPanel.setVisible(false);
	}
	/**
	 * @说明 设置JPanel，即游戏面板
	 * @param jPanel
	 */
	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	/**
	 * @说明 设置键盘监听器
	 * @param keyListener
	 */
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	/**
	 * @说明 设置鼠标坐标监听器
	 * @param mouseMotionListener
	 */
	public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	/**
	 * @说明 设置鼠标监听器，即鼠标按下、释放、单击、进入、离开
	 * @param mouseListener
	 */
	public void setMouseListener(MouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	/**
	 * @说明 设置游戏主线程
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
	//设置音乐线程
//	public void setMusicThead(Thread thread) {
//		this.musicThread=thread;
//	}
}
