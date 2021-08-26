package com.lyh.tank.collider;

import java.util.LinkedList;
import java.util.List;

import com.lyh.tank.gameobject.GameObject;

public class ColliderChain implements Collider {
	
	public ColliderChain() {
		add(new BuletTankCollider());
		add(new TankTankCollider());
		add(new TankWallCollider());
		add(new BuletWallCollider());
	}
	
	List<Collider> list = new LinkedList<>();
	public ColliderChain add(Collider c) {
		list.add(c);
		return this;
	}
	
	public boolean collide(GameObject o1,GameObject o2) {
		for(Collider cr : list) {
			if(!cr.collide(o1, o2)) {
				return false;
			}
		}
		return true;
	}
	
}
