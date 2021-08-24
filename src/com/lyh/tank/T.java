package com.lyh.tank;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.DefaultFactory;

public class T {
	public static void main(String[] args) throws Exception {
		TankFrame tf =new TankFrame();
		int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
		AbstractFactory ay = DefaultFactory.getInstance();  
		for(int i=0; i<initTankCount; i++) { 
			tf.tanks.add(ay.creatTank(50 + i*80, 200, Dir.DOWN, Group.BAD, tf,ay)); 
		}
//		for(int i=0; i<initTankCount; i++) {
//			tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, tf));
//		}
		
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
