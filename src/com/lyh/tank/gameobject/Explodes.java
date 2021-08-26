package com.lyh.tank.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.lyh.tank.GameModel;
import com.lyh.tank.resource.Audio;
import com.lyh.tank.resource.ResourceMgr;


public class Explodes extends GameObject {
	private int x,y;
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private boolean living = true;
	private GameModel gm =null;
	
	public Explodes(int x, int y,GameModel gm) {
		this.x = x;
		this.y = y;
		this.gm = gm;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}
	private int step = 0;
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step >= ResourceMgr.explodes.length) {
			gm.remove(this);
		}
	}
	
	
}
