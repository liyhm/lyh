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
	
	Tank tk = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
	private List<GameObject> list = new ArrayList<GameObject>();
	ColliderChain ccn = new ColliderChain();
	public Random random = new Random();
	
	public GameModel() {
		int wallCount = Integer.parseInt((String)PropertyMgr.get("wallCount"));
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		
		//墙
		List<Integer> wallX = new ArrayList<>();
		List<Integer> wallY = new ArrayList<>();
		for(int i=0; i<wallCount; i++) {
			boolean flag = true;
			while(flag) {
				int x = random.nextInt(1080);
				int y = random.nextInt(700);
				if(!wallX.contains(x) && !wallY.contains(y) && x > 50 && y > 200) {
					wallX.add(x);
					wallY.add(y);
					add(new Wall(x-50,y-50));
					flag = false;
				}
			}
		}
		
		//敌方坦克
		for(int i=0; i<initTankCount; i++) {
			add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
		}
		
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("方向键上下左右调整方向，Ctrk键开火", 10,45);
		g.setColor(c);
		tk.paint(g);
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
