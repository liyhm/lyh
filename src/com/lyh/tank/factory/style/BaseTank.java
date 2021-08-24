package com.lyh.tank.factory.style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.lyh.tank.Dir;
import com.lyh.tank.Group;
import com.lyh.tank.ResourceMgr;
import com.lyh.tank.TankFrame;

public abstract class BaseTank {
	public Rectangle rect ;
	public Group group;
	public TankFrame tf;
	public int x;
	public int y;
	public Dir dir;
	public static int WIDTH;
	public static int HEIGHT;

	public abstract void paint(Graphics g);

	public abstract Group getGroup();

	public abstract int getX();

	public abstract void setX(int x);

	public abstract int getY();

	public abstract void setY(int y);

	public abstract void die();

	public abstract void fire();

	public abstract void setMoving(boolean b);

	public abstract void setDir(Dir left);
	
}
