package com.lyh.tank.collider;

import com.lyh.tank.gameobject.GameObject;

public interface Collider {
	public boolean collide(GameObject o1, GameObject o2);
}
