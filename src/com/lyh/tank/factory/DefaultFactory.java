package com.lyh.tank.factory;

import com.lyh.tank.Dir;
import com.lyh.tank.Group;
import com.lyh.tank.TankFrame;
import com.lyh.tank.factory.style.BaseBullet;
import com.lyh.tank.factory.style.BaseExplode;
import com.lyh.tank.factory.style.BaseTank;
import com.lyh.tank.factory.style.defaults.DefaultBullet;
import com.lyh.tank.factory.style.defaults.DefaultExplode;
import com.lyh.tank.factory.style.defaults.DefaultTank;

public class DefaultFactory extends AbstractFactory {
	private static final DefaultFactory INSTANCE = new DefaultFactory();
	private DefaultFactory() {
	}
	public static DefaultFactory getInstance() {
		return INSTANCE;
	}
	@Override
	public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf,AbstractFactory ay) {
		return new DefaultTank(x,y,dir,group,tf,ay);
	}

	@Override
	public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		return new DefaultBullet(x,y,dir,group,tf);
	}

	@Override
	public BaseExplode creatExplode(int x, int y, TankFrame tf) {
		return new DefaultExplode(x,y,tf);
	}



}
