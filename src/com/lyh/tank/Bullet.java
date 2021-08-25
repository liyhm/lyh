package com.lyh.tank;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Bullet {
	private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));
	private int x,y;
	private Dir dir;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	private TankFrame tf =null;
	private Group group = Group.BAD;
	Rectangle rect = new Rectangle();
	
	public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group=group;
		this.tf = tf;
		rect.x = this.x;
		rect.y = this.y;
		rect.width=this.WIDTH;
		rect.height=this.HEIGHT;
		//tf.btList.add(this);
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.btList.remove(this);
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

	public void collidWith(Tank tank) {
		if(this.group == tank.getGroup()) return ;
		if(rect.intersects(tank.rect)) {
			int eX=tank.getX()+Tank.WIDTH/2 - Explodes.WIDTH/2;
			int eY=tank.getY()+tank.HEIGHT/2 -Explodes.HEIGHT/2;
			tf.explodes.add(new Explodes(eX, eY, tf));
			tank.die();
			this.die();
		}
	}

	private void die() {
		living = false;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	
	
}
