package com.lyh.tank.gameobject;

import java.awt.Graphics;

public abstract class GameObject {
	public int x;
	public int y;
	public int width;
	public int height;
	public abstract void paint(Graphics g);
	public abstract int getWidth();
	public abstract int getHeigt();
}
