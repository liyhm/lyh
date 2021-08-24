package com.lyh.tank.factory.style.dazzle;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.lyh.tank.DefaultFireStrategy;
import com.lyh.tank.Dir;
import com.lyh.tank.FireStrategy;
import com.lyh.tank.FourFireStrategy;
import com.lyh.tank.Group;
import com.lyh.tank.PropertyMgr;
import com.lyh.tank.ResourceMgr;
import com.lyh.tank.Tank;
import com.lyh.tank.TankFrame;
import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseTank;

public class DazzleTank extends BaseTank {

	//int x, y;
		//Dir dir = Dir.DOWN;
		private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("tankSpeed"));
		private boolean moving = true;
		//public static int WIDTH = ResourceMgr.goodTankU.getWidth();
		//public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
		public boolean living = true; 
		public Random random = new Random();
		//Group group = Group.BAD;
		FireStrategy fs ;
		public AbstractFactory ay;
		
		public DazzleTank(int x, int y, Dir dir,Group group,TankFrame tf,AbstractFactory ay) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.group = group;
			this.tf = tf;
			this.ay = ay;
			rect = new Rectangle();
			rect.x = this.x;
			rect.y = this.y;
			rect.width=this.WIDTH;
			rect.height=this.HEIGHT;
			WIDTH = ResourceMgr.goodTankDazzleU.getWidth();
			HEIGHT = ResourceMgr.goodTankDazzleU.getHeight();
			if(Group.GOOD == group) {
				fs = FourFireStrategy.INSTANCE;
			}else {
				fs = DefaultFireStrategy.INSTANCE;
			}
		}

		public void paint(Graphics g) {
			if(!living) tf.tanks.remove(this);
			switch (dir) {
			case LEFT:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankDazzleL:ResourceMgr.badTankL,x,y,null);
				break;
			case RIGTH:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankDazzleR:ResourceMgr.badTankR,x,y,null);
				break;
			case UP:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankDazzleU:ResourceMgr.badTankU,x,y,null);
				break;
			case DOWN:
				g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankDazzleD:ResourceMgr.badTankD,x,y,null);
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
			if(this.x > TankFrame.GAME_WIDTH-WIDTH)x=TankFrame.GAME_WIDTH-WIDTH-2;
			if(this.y > TankFrame.GAME_HEIGHT-HEIGHT)y=TankFrame.GAME_HEIGHT-HEIGHT-2;
		}

		private void randomDir() {
			this.dir = Dir.values()[random.nextInt(4)];
		}
		@Override
		public void fire() {
			fs.fire(this,ay);
		}
		
		public Dir getDir() {
			return dir;
		}

		@Override
		public void setDir(Dir dir) {
			this.dir = dir;
		}

		public boolean isMoving() {
			return moving;
		}

		@Override
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

		@Override
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
