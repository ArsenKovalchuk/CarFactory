package com.arsen.assembly;

public abstract class AssemblyCarEntity {
    private Car car;

    public AssemblyCarEntity(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
