package com.winter.factory;

import com.winter.Car;

public class CarFactory {
    public Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }
}
