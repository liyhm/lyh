package com.lyh.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.DazzleFactory;
import com.lyh.tank.factory.DefaultFactory;
import com.lyh.tank.factory.style.BaseBullet;
import com.lyh.tank.factory.style.BaseExplode;
import com.lyh.tank.factory.style.BaseTank;

public class TankFrame extends Frame {
	//Tank tk = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
	//Bullet bt = new Bullet(300, 300, Dir.DOWN, this);
	public static final int GAME_WIDTH=Integer.parseInt((String)PropertyMgr.get("gameWidth"));
	public static final int GAME_HEIGHT=Integer.parseInt((String)PropertyMgr.get("gameHeight"));
	public List<BaseBullet> btList = new ArrayList<BaseBullet>();
	public List<BaseTank> tanks = new ArrayList<BaseTank>();
	public List<BaseExplode> explodes =  new ArrayList<BaseExplode>();
	//Explodes explodes = new Explodes(100, 100, this);
	public static AbstractFactory ay = DefaultFactory.getInstance();
	BaseTank tk = ay.creatTank(200,400,Dir.DOWN,Group.GOOD,this,ay);
	public TankFrame _this=this;
	
	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);// 不允许窗口改变大小
		setVisible(true);// 显示窗口
		setTitle("lyh");
		// 添加一个窗口关闭事件，点窗口小叉叉的时候关闭
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new MyKeyListener());
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("方向键上下左右调整方向，Ctrk键开火", 10,45);
		g.drawString("子弹的数量："+btList.size(), 10,60);
		g.drawString("敌人的数量："+tanks.size(), 10,80);
		g.drawString("爆炸的数量："+explodes.size(), 10,100);
		g.setColor(c);
		tk.paint(g);
		for(int i = 0; i < btList.size(); i++) {
			btList.get(i).paint(g);
		}
		
		for(int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}
		
		for(int i = 0; i<btList.size();i++) {
			for(int j = 0; j<tanks.size();j++) {
				btList.get(i).collidWith(tanks.get(j),ay);
			}
		}
		
		for(int i = 0; i < explodes.size(); i++) {
			explodes.get(i).paint(g);
		}
		
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage,0,0,null);
	}

	class MyKeyListener extends KeyAdapter {
		boolean bl = false;
		boolean bu = false;
		boolean br = false;
		boolean bd = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = true;
				break;
			case KeyEvent.VK_UP:
				bu = true;
				break;
			case KeyEvent.VK_RIGHT:
				br = true;
				break;
			case KeyEvent.VK_DOWN:
				bd = true;
				break;
			case KeyEvent.VK_CONTROL:
				tk.fire();
				break;
			case KeyEvent.VK_0:
				AbstractFactory day = DefaultFactory.getInstance();
				tk = day.creatTank(tk.x, tk.y, tk.dir, Group.GOOD, _this, day);
				break;
			case KeyEvent.VK_1:
				DazzleFactory dey = DazzleFactory.getInstance();
				tk = dey.creatTank(tk.x, tk.y, tk.dir, Group.GOOD, _this, dey);
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = false;
				break;
			case KeyEvent.VK_UP:
				bu = false;
				break;
			case KeyEvent.VK_RIGHT:
				br = false;
				break;
			case KeyEvent.VK_DOWN:
				bd = false;
				break;
			default:
				break;
			}
			setMainTankDir();
		}
		
		private void setMainTankDir() {
			if(!bl && !bu && !br && !bd) {
				tk.setMoving(false);
			}else {
				tk.setMoving(true);
			}
			if(bl) tk.setDir(Dir.LEFT);
			if(bu) tk.setDir(Dir.UP);
			if(br) tk.setDir(Dir.RIGTH);
			if(bd) tk.setDir(Dir.DOWN);
			
		}
	}
}
