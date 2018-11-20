package com.winter.fb;

import com.winter.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    //实例化CarBean
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setColor(infos[1]);
        car.setMaxSpeed(Integer.parseInt(infos[2]));
        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    //标识通过该FactoryBean返回的Bean是singleton
    public boolean isSingleton() {
        return false;
    }
}
