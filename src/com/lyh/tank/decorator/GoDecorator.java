package com.lyh.tank.decorator;

import java.awt.Graphics;

import com.lyh.tank.gameobject.GameObject;

public abstract class GoDecorator extends GameObject {

	GameObject go;
	
	public GoDecorator(GameObject go) {
		this.go = go;
	}
	
	@Override
	public void paint(Graphics g) {
		go.paint(g);
	}

}
