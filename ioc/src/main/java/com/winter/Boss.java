package com.winter;

public class Boss {
    private String name;
    private int salary;
    private Car car;

    public Boss() {
    }

    public Boss(String name, int salary, Car car) {
        this.name = name;
        this.salary = salary;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
