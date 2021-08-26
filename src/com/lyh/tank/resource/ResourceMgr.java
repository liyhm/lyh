package com.lyh.tank.resource;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class ResourceMgr {
	
	public static ResourceMgr INSTANCE = new ResourceMgr();
	
	private ResourceMgr() {
		
	}
	
	public static ResourceMgr getInstance() {
		return INSTANCE;
	}
	
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
	public static BufferedImage badTankL, badTankU, badTankR, badTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	public static BufferedImage goodTankDazzleL, goodTankDazzleU, goodTankDazzleR, goodTankDazzleD;
	public static BufferedImage bulletDazzleL, bulletDazzleU, bulletDazzleR, bulletDazzleD;
	
	public static BufferedImage wallU;
	
	static {
		try {
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU, -90);
			goodTankR = ImageUtil.rotateImage(goodTankU, 90);
			goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			
			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU, -90);
			badTankR = ImageUtil.rotateImage(badTankU, 90);
			badTankD = ImageUtil.rotateImage(badTankU, 180);
			
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
			
			for(int i=0;i<16;i++) {
				explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
			
			wallU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/wall.png"));
			
			//--------StyleTwo--------------------------------------------------------------------------------------
			goodTankDazzleU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankDazzle.png"));
			goodTankDazzleL = ImageUtil.rotateImage(goodTankDazzleU, -90);
			goodTankDazzleR = ImageUtil.rotateImage(goodTankDazzleU, 90);
			goodTankDazzleD = ImageUtil.rotateImage(goodTankDazzleU, 180);
			
			bulletDazzleU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletDazzle.png"));
			bulletDazzleL = ImageUtil.rotateImage(bulletDazzleU, -90);
			bulletDazzleR = ImageUtil.rotateImage(bulletDazzleU, 90);
			bulletDazzleD = ImageUtil.rotateImage(bulletDazzleU, 180);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
