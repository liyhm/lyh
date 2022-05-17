package com.lyh.tank.collider;

import com.lyh.tank.gameobject.GameObject;
import com.lyh.tank.gameobject.Tank;
import com.lyh.tank.gameobject.Wall;

public class TankWallCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Wall) {
			Tank t1 = (Tank)o1;
			Wall t2 = (Wall)o2;
			if(t1.rect.intersects(t2.rect)) {
				t1.back();
			}
		}else if(o1 instanceof Wall && o2 instanceof Tank) {
			collide(o2,o1);
		}
		return true;
	}

}
