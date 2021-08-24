package com.lyh.tank;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Explodes {
	private int x,y;
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private boolean living = true;
	private TankFrame tf =null;
	
	public Explodes(int x, int y,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}
	private int step = 0;
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step >= ResourceMgr.explodes.length) {
			tf.explodes.remove(this);
		}
	}
	
	
}
