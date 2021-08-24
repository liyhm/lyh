package com.lyh.tank.factory.style.dazzle;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lyh.tank.Dir;
import com.lyh.tank.Explodes;
import com.lyh.tank.Group;
import com.lyh.tank.PropertyMgr;
import com.lyh.tank.ResourceMgr;
import com.lyh.tank.Tank;
import com.lyh.tank.TankFrame;
import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseBullet;
import com.lyh.tank.factory.style.BaseTank;

public class DazzleBullet extends BaseBullet {

	private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));
	private int x,y;
	private Dir dir;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	private boolean living = true;
	private TankFrame tf =null;
	private Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	
	public DazzleBullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group=group;
		this.tf = tf;
		rect = new Rectangle();
		rect.x = this.x;
		rect.y = this.y;
		rect.width=this.WIDTH;
		rect.height=this.HEIGHT;
		tf.btList.add(this);
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.btList.remove(this);
		}
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletDazzleL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletDazzleU, x, y, null);
			break;
		case RIGTH:
			g.drawImage(ResourceMgr.bulletDazzleR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletDazzleD, x, y, null);
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

	@Override
	public void collidWith(BaseTank tank,AbstractFactory ay) {
		if(this.group == tank.getGroup()) return ;
		if(rect.intersects(tank.rect)) {
			int eX=tank.getX()+tank.WIDTH/2 - DazzleExplode.WIDTH/2;
			int eY=tank.getY()+tank.HEIGHT/2 -DazzleExplode.HEIGHT/2;
			tf.explodes.add(ay.creatExplode(eX, eY, tf));
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
