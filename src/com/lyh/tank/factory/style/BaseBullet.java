package com.lyh.tank.factory.style;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lyh.tank.ResourceMgr;
import com.lyh.tank.factory.AbstractFactory;

public abstract class BaseBullet {
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	public abstract void paint(Graphics g);

	public abstract void collidWith(BaseTank baseTank,AbstractFactory ay);

}
