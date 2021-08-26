package com.lyh.tank.collider;

import com.lyh.tank.gameobject.GameObject;
import com.lyh.tank.gameobject.Tank;

public class TankTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if(o1 instanceof Tank && o2 instanceof Tank) {
			Tank t1 = (Tank)o1;
			Tank t2 = (Tank)o2;
			if(t1.rect.intersects(t2.rect)) {
				t1.setX(t1.oldX);
				t1.setY(t1.oldY);
				t2.setX(t2.oldX);
				t2.setY(t2.oldY);
			}
			
		}
		return true;
	}

}
