package com.lyh.tank;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseTank;
import com.lyh.tank.factory.style.defaults.DefaultBullet;

public class FourFireStrategy implements FireStrategy {

	public static final FourFireStrategy INSTANCE = new FourFireStrategy();
	
	private FourFireStrategy () {}
	
	@Override
	public void fire(BaseTank t,AbstractFactory ay) {
		int bX = t.x + t.WIDTH/2 - DefaultBullet.WIDTH+14;
		int bY = t.y +t.HEIGHT/2 - DefaultBullet.HEIGHT+14;
		Dir dirs[] = Dir.values();
		for(Dir dir:dirs) {
			ay.creatBullet(bX,bY,dir,t.group, t.tf);
		}
	}

//	@Override
//	public void fire(Tank t) {
//		int bX = t.x + t.WIDTH/2 - DefaultBullet.WIDTH+14;
//		int bY = t.y +t.HEIGHT/2 - DefaultBullet.HEIGHT+14;
//		Dir dirs[] = Dir.values();
//		for(Dir dir:dirs) {
//			new Bullet(bX,bY,dir,t.group, t.tf);
//		}
//	}
	
}
