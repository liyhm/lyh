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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void die();

	public abstract void fire();

	public abstract void setMoving(boolean b);

	public abstract void setDir(Dir left);
	
}
