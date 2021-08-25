package com.lyh.tank;

public class T {
	public static void main(String[] args) throws Exception {
		TankFrame tf =new TankFrame();
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
