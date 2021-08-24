package com.lyh.tank.factory.style.dazzle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lyh.tank.Audio;
import com.lyh.tank.ResourceMgr;
import com.lyh.tank.TankFrame;
import com.lyh.tank.factory.style.BaseExplode;

public class DazzleExplode extends BaseExplode {

	private int x,y;
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private boolean living = true;
	private TankFrame tf =null;
	
	public DazzleExplode(int x, int y,TankFrame tf) {
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
