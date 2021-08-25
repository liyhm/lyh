package com.lyh.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.lyh.tank.factory.style.BaseBullet;

public class Tank {
	int x, y;
	Dir dir = Dir.DOWN;
	private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("tankSpeed"));
	private boolean moving = true;
	GameModel tf = null;
	public static int WIDTH = ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
	public boolean living = true; 
	public Random random = new Random();
	Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
//	FireStrategy fs ;
	
	public Tank(int x, int y, Dir dir,Group group,GameModel gameModel) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = gameModel;
		rect.x = this.x;
		rect.y = this.y;
		rect.width=this.WIDTH;
		rect.height=this.HEIGHT;
//		if(Group.GOOD == group) {
//			fs = FourFireStrategy.INSTANCE;
//		}else {
//			fs = DefaultFireStrategy.INSTANCE;
//		}
	}

	public void paint(Graphics g) {
		if(!living) tf.tanks.remove(this);
		switch (dir) {
		case LEFT:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL,x,y,null);
			break;
		case RIGTH:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR,x,y,null);
			break;
		case UP:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU,x,y,null);
			break;
		case DOWN:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD,x,y,null);
			break;
		default:
			break;
		}
		
		move();
	}

	public void move() {
		if(!moving) return;
		
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
		
		if(this.group != Group.GOOD) {
			if(random.nextInt(100) > 95) this.fire();
		}
		
		if(this.group != Group.GOOD && random.nextInt(100) > 95) {
			randomDir();
		}
		boundsCheck();
		rect.x=this.x;
		rect.y=this.y;
	}
	
	private void boundsCheck() {
		if(this.x < 0)x=0;
		if(this.y < 30) y = 30;
		if(this.x > TankFrame.GAME_WIDTH-Tank.WIDTH)x=TankFrame.GAME_WIDTH-Tank.WIDTH-2;
		if(this.y > TankFrame.GAME_HEIGHT-Tank.HEIGHT)y=TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;
	}

	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}

	public void fire() {
		//fs.fire(this);
		int bX = this.x + this.WIDTH/2 - Bullet.WIDTH+14;
		int bY = this.y +this.HEIGHT/2 - Bullet.HEIGHT+14;
		tf.btList.add(new Bullet(bX,bY,this.dir,this.group, this.tf));
	}
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

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

	public void die() {
		this.living=false;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
