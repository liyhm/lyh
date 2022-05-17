package com.lyh.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lyh.tank.collider.ColliderChain;
import com.lyh.tank.gameobject.GameObject;
import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.gameobject.Wall;
import com.lyh.tank.resource.Dir;
import com.lyh.tank.resource.Group;
import com.lyh.tank.resource.PropertyMgr;

public class GameModel {
	
	private static final GameModel INSTANCE = new GameModel();
	
	public static GameModel getInstance() {
		return INSTANCE;
	}
	static {
		INSTANCE.init();
	}
	Tank tk;
	private List<GameObject> list = new ArrayList<GameObject>();
	ColliderChain ccn = new ColliderChain();
	public Random random = new Random();
	
	private GameModel() {
	}
	
	private void init() {
		
		int wallCount = Integer.parseInt((String)PropertyMgr.get("wallCount"));
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		//主战坦克
		tk = new Tank(200,400,Dir.DOWN,Group.GOOD);
		
		//墙
		new Wall(150,150);
		new Wall(190,150);
		new Wall(230,150);
		new Wall(270,150);
		new Wall(310,150);
		new Wall(270,186+50);
		new Wall(270,222+50);
		new Wall(270,257+50);
		new Wall(270,289+50);
		
		new Wall(600,150);
		new Wall(640,150);
		new Wall(680,150);
		new Wall(720,150);
		new Wall(760,150);
		new Wall(640,186+50);
		new Wall(640,222+50);
		new Wall(640,257+50);
		new Wall(640,289+50);
		
		//敌方坦克
		for(int i=0; i<initTankCount; i++) {
			new Tank(50 + i*80, 80, Dir.DOWN, Group.BAD);
		}
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("方向键上下左右调整方向，Ctrk键开火", 10,45);
		g.setColor(c);
		//tk.paint(g);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).paint(g);
		}
		for(int i = 0; i<list.size();i++) {
			for(int j = i+1; j<list.size();j++) {
				GameObject o1 = list.get(i);
				GameObject o2 = list.get(j);
				ccn.collide(o1, o2);
			}
		}
		
	}
	
	public Tank getMyTank() {
		return tk;
	} 

	public void add(GameObject gt) {
		list.add(gt);
	}
	
	public void remove(GameObject gt) {
		list.remove(gt);
	}
	
}
