package com.lyh.tank.collider;

import com.lyh.tank.gameobject.Bullet;
import com.lyh.tank.gameobject.Explodes;
import com.lyh.tank.gameobject.GameObject;
import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.gameobject.Wall;

public class BuletWallCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Bullet && o2 instanceof Wall) {
			Bullet bt = (Bullet)o1;
			Wall wall = (Wall)o2;
			if(bt.rect.intersects(wall.rect)) {
				bt.die();
				return false;
			}
		}else if(o1 instanceof Wall && o2 instanceof Bullet) {
			return collide(o2,o1);
		}else {
			return true;
		}
		return true;
	}

}
