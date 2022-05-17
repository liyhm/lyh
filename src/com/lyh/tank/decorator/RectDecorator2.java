package com.lyh.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.lyh.tank.gameobject.GameObject;

public class RectDecorator2 extends GoDecorator {

	public RectDecorator2(GameObject go) {
		super(go);
	}

	@Override
	public void paint(Graphics g) {
		this.x=go.x;
		this.y=go.y;
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawRect(super.go.x, super.go.y, super.go.getWidth()+2, super.go.getHeigt()+2);
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
