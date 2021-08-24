package com.lyh.tank;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseBullet;
import com.lyh.tank.factory.style.BaseTank;

public class DefaultFireStrategy implements FireStrategy {

	public static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
	
	private DefaultFireStrategy() {}
	
	@Override
	public void fire(BaseTank t,AbstractFactory ay) {
		int bX = t.x + t.WIDTH/2 - BaseBullet.WIDTH+14;
		int bY = t.y +t.HEIGHT/2 - BaseBullet.HEIGHT+14;
		ay.creatBullet(bX,bY,t.dir,t.group, t.tf);
	}

//	@Override
//	public void fire(Tank t) {
//		int bX = t.x + t.WIDTH/2 - BaseBullet.WIDTH+14;
//		int bY = t.y +t.HEIGHT/2 - BaseBullet.HEIGHT+14;
//		new Bullet(bX,bY,t.dir,t.group, t.tf);
//	}
	
}
