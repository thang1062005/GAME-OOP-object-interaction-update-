package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.Superobject;
import tile.Tilemanager;

public class Gamepanel extends JPanel implements Runnable {
	// CHỈNH MÀN HÌNH
	final int originaltilesize = 16; //16x16: NHÂN VẬT - NPC - Ô TILE TRÊN MAP
	final int scale = 3; //16x16 look like 48x48 
	public final int tilesize = originaltilesize*scale;
	public final int maxscreencol = 16;
	public final int maxscreenrow = 12;
	
	public final int screenwidth = tilesize*maxscreencol;// 768
	public final int screenheight = tilesize*maxscreenrow;//576
	
	
	//world setting
	public final int maxworldcol = 50;
	public final int maxworldrow = 50;
	public final int worldwidth =tilesize*maxworldcol;
	public final int worldheight =tilesize*maxworldrow;
	int FPS = 60;
	
	Tilemanager tileM = new Tilemanager(this);
	Keyhandler keyH = new Keyhandler();
	
	Thread gameThread; //keep runing util u stop
	public Collisioncheck ccheck = new Collisioncheck(this);
    public Assetsetter ass = new Assetsetter(this);
	public Player player = new Player(this, keyH);
	// set default char posi
	public Superobject obj[]= new Superobject[10];
	// CONSTRUCTOR
	public Gamepanel() {
		this.setPreferredSize(new Dimension(screenwidth,screenheight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true); // all the drawing from this componet done offscreen
		this.addKeyListener(this.keyH); // có
		this.setFocusable(true);// có
		this.requestFocusInWindow();
	
	}
	
	
	public void startgamethread() {
		this.gameThread = new Thread(this); // gắn biển gameThread bằng 1 giá trị Thread lấy gamepanel là tham số
		this.gameThread.start();
	}
	
	//game loop
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lasttime = System.nanoTime();
		long currenttime;
		long timer = 0;
		int drawcount = 0;
		while (gameThread != null) {
			currenttime =  System.nanoTime();
			delta += (currenttime-lasttime)/drawInterval;
			timer += (currenttime-lasttime);
			lasttime= currenttime ;
			if (delta >=1) {
				update();
				repaint();
				delta --;
				drawcount ++;
			}
			if (timer>= 1000000000) {
				System.out.println(drawcount);
				drawcount = 0;
				timer=0;
			}
		
			
		}
		// TODO Auto-generated method stub
		
	}
	public void update() {
		player.update();
	}
	
	// vẽ đồ họa tùy chỉnh lên JPanel bằng cách ghi đè phương thức
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// khởi tạo g2, với Graphics2D là lớp con của g
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2); //layer of tile first
		
		for (int i = 0; i<obj.length; i++) {
			if (obj[i]!= null) {
				obj[i].draw(g2,  this);
			}
		}
		player.draw(g2);
		
		
		g2.dispose();
		
		
		
	}
	public void setup() {
		ass.setobj();
		
	}

}
