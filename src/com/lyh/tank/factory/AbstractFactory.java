package com.lyh.tank.factory;

import com.lyh.tank.TankFrame;
import com.lyh.tank.factory.style.BaseBullet;
import com.lyh.tank.factory.style.BaseExplode;
import com.lyh.tank.factory.style.BaseTank;
import com.lyh.tank.resource.Dir;
import com.lyh.tank.resource.Group;

public abstract class AbstractFactory {
	public abstract BaseTank creatTank(int x, int y, Dir dir,Group group,TankFrame tf,AbstractFactory ay);
	public abstract BaseBullet creatBullet(int x, int y, Dir dir,Group group,TankFrame tf);
	public abstract BaseExplode creatExplode(int x, int y,TankFrame tf);
}
