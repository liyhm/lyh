package com.lyh.tank.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.lyh.tank.resource.ResourceMgr;

public class Wall extends GameObject  {
	
	public Rectangle rect = new Rectangle();
	public static int WIDTH = ResourceMgr.wallU.getWidth();
	public static int HEIGHT = ResourceMgr.wallU.getHeight();
	
	
	public Wall(int x,int y) {
		this.x=x;
		this.y=y;
		rect.x = this.x;
		rect.y = this.y;
		rect.width=this.WIDTH;
		rect.height=this.HEIGHT;
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.wallU, x, y, null);
	}

}
