//package com.lyh.tank.factory;
//
//import com.lyh.tank.Dir;
//import com.lyh.tank.Group;
//import com.lyh.tank.TankFrame;
//import com.lyh.tank.factory.style.BaseBullet;
//import com.lyh.tank.factory.style.BaseExplode;
//import com.lyh.tank.factory.style.BaseTank;
//import com.lyh.tank.factory.style.dazzle.DazzleBullet;
//import com.lyh.tank.factory.style.dazzle.DazzleExplode;
//import com.lyh.tank.factory.style.dazzle.DazzleTank;
//
//public class DazzleFactory extends AbstractFactory {
//	
//	private static final DazzleFactory INSTANCE = new DazzleFactory();
//	
//	private DazzleFactory() {}
//	
//	public static DazzleFactory getInstance() {
//		return INSTANCE;
//	}
//	
//	@Override
//	public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf, AbstractFactory ay) {
//		return new DazzleTank(x,y,dir,group,tf,ay);
//	}
//
//	@Override
//	public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
//		return new DazzleBullet(x,y,dir,group,tf);
//	}
//
//	@Override
//	public BaseExplode creatExplode(int x, int y, TankFrame tf) {
//		return new DazzleExplode(x,y,tf);
//	}
//
//
//}
