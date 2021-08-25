package com.lyh.tank;

import com.lyh.tank.factory.AbstractFactory;
import com.lyh.tank.factory.style.BaseTank;

public interface FireStrategy {
	//void fire(BaseTank baseTank,AbstractFactory ay);
	void fire(Tank Tank);
}
