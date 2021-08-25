package com.lyh.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
	
	//public List<BaseBullet> btList = new ArrayList<BaseBullet>(); 
	//public List<BaseTank> tanks = new ArrayList<BaseTank>(); 
	//public List<BaseExplode> explodes =  new ArrayList<BaseExplode>(); 
	//public static AbstractFactory ay = DefaultFactory.getInstance(); 
	//BaseTank tk = ay.creatTank(200,400,Dir.DOWN,Group.GOOD,this,ay); 
	//public TankFrame _this=this;
	Tank tk = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
	public List<Bullet> btList = new ArrayList<Bullet>(); 
	public List<Tank> tanks = new ArrayList<Tank>(); 
	public List<Explodes> explodes =  new ArrayList<Explodes>();
	
	
	public GameModel() {
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
//		AbstractFactory ay = DefaultFactory.getInstance();  
//		for(int i=0; i<initTankCount; i++) { 
//			tf.tanks.add(ay.creatTank(50 + i*80, 200, Dir.DOWN, Group.BAD, tf,ay)); 
//		}
		for(int i=0; i<initTankCount; i++) {
			tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
		}
	}
	
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
				//btList.get(i).collidWith(tanks.get(j),ay);
				btList.get(i).collidWith(tanks.get(j));
			}
		}
		
		for(int i = 0; i < explodes.size(); i++) {
			explodes.get(i).paint(g);
		}
		
	}
	
	public Tank getMyTank() {
		return tk;
	} 

	
	
	
}
