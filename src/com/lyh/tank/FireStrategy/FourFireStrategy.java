package com.lyh.tank.FireStrategy;

import com.lyh.tank.gameobject.Bullet;
import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.resource.Dir;

public class FourFireStrategy implements FireStrategy {

	public static final FourFireStrategy INSTANCE = new FourFireStrategy();
	
	private FourFireStrategy () {}
	
//	@Override
//	public void fire(BaseTank t,AbstractFactory ay) {
//		int bX = t.x + t.WIDTH/2 - DefaultBullet.WIDTH+14;
//		int bY = t.y +t.HEIGHT/2 - DefaultBullet.HEIGHT+14;
//		Dir dirs[] = Dir.values();
//		for(Dir dir:dirs) {
//			ay.creatBullet(bX,bY,dir,t.group, t.tf);
//		}
//	}

	@Override
	public void fire(Tank t) {
		int bX = t.x + t.WIDTH/2 - Bullet.WIDTH+14;
		int bY = t.y +t.HEIGHT/2 - Bullet.HEIGHT+14;
		Dir dirs[] = Dir.values();
		for(Dir dir:dirs) {
			new Bullet(bX,bY,dir,t.group, t.gm);
		}
	}
	
}
