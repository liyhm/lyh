package com.lyh.tank.FireStrategy;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseTank;
import com.lyh.tank.gameobject.Tank;

public interface FireStrategy {
	//void fire(BaseTank baseTank,AbstractFactory ay);
	void fire(Tank Tank);
}
