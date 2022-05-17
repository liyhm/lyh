package com.lyh.tank.collider;

import com.lyh.tank.GameModel;
import com.lyh.tank.gameobject.Bullet;
import com.lyh.tank.gameobject.Explodes;
import com.lyh.tank.gameobject.GameObject;
import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.resource.Group;

public class BuletTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet bt = (Bullet)o1;
			Tank tank = (Tank)o2;
			if(bt.group == tank.getGroup()) return true;
			if(bt.rect.intersects(tank.rect) && tank.group == Group.BAD) {
				int eX=tank.getX()+Tank.WIDTH/2 - Explodes.WIDTH/2;
				int eY=tank.getY()+tank.HEIGHT/2 -Explodes.HEIGHT/2;
				new Explodes(eX, eY);
				tank.die();
				bt.die();
				return false;
			}
		}else if(o1 instanceof Tank && o2 instanceof Bullet) {
			return collide(o2,o1);
		}else {
			return true;
		}
		return true;
	}

}
