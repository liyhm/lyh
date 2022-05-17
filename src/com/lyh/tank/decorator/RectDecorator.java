package com.lyh.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.lyh.tank.gameobject.GameObject;

public class RectDecorator extends GoDecorator {

	public RectDecorator(GameObject go) {
		super(go);
	}

	@Override
	public void paint(Graphics g) {
		this.x=go.x;
		this.y=go.y;
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.red);
		g.drawRect(go.x, go.y, go.getWidth(), go.getHeigt());
	}

	@Override
	public int getWidth() {
		return super.go.getWidth();
	}

	@Override
	public int getHeigt() {
		return super.go.getHeigt();
	}
	
}
