package com.lyh.tank.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.lyh.tank.GameModel;
import com.lyh.tank.TankFrame;
import com.lyh.tank.resource.Dir;
import com.lyh.tank.resource.Group;
import com.lyh.tank.resource.PropertyMgr;
import com.lyh.tank.resource.ResourceMgr;


public class Bullet extends GameObject {
	private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));
	private int x,y;
	private Dir dir;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	public GameModel gm =null;
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	
	public Bullet(int x, int y, Dir dir,Group group,GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group=group;
		this.gm = gm;
		rect.x = this.x;
		rect.y = this.y;
		rect.width=this.WIDTH;
		rect.height=this.HEIGHT;
		//tf.btList.add(this);
	}
	
	public void paint(Graphics g) {
		if(!living) {
			gm.remove(this);
		}
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGTH:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		}
		
		move();
	}
	public void move() {
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGTH:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		rect.x=this.x;
		rect.y=this.y;
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			living=false;
		}
		
	}

	public void die() {
		living = false;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	
	
}
