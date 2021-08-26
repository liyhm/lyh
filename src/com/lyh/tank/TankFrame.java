package com.lyh.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.resource.Dir;
import com.lyh.tank.resource.PropertyMgr;

public class TankFrame extends Frame {
	
	public static final int GAME_WIDTH=Integer.parseInt((String)PropertyMgr.get("gameWidth"));
	public static final int GAME_HEIGHT=Integer.parseInt((String)PropertyMgr.get("gameHeight"));

	GameModel model = new GameModel();
	
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
		model.paint(g);
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
				model.getMyTank().fire();
				break;
//			case KeyEvent.VK_0:
//				AbstractFactory day = DefaultFactory.getInstance();
//				tk = day.creatTank(tk.x, tk.y, tk.dir, Group.GOOD, _this, day);
//				break;
//			case KeyEvent.VK_1:
//				DazzleFactory dey = DazzleFactory.getInstance();
//				tk = dey.creatTank(tk.x, tk.y, tk.dir, Group.GOOD, _this, dey);
//				break;
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
			Tank tank = model.getMyTank();
			if(!bl && !bu && !br && !bd) {
				tank.setMoving(false);
			}else {
				tank.setMoving(true);
			}
			if(bl) tank.setDir(Dir.LEFT);
			if(bu) tank.setDir(Dir.UP);
			if(br) tank.setDir(Dir.RIGTH);
			if(bd) tank.setDir(Dir.DOWN);
			
		}
	}
}
