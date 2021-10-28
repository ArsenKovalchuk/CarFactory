package com.arsen.assembly;

public class AssemblyLine<T extends AssemblyCarEntity> {
    private final String name;

    public AssemblyLine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Car produce(T assemblyCarEntity) {
        return assemblyCarEntity.getCar();
    }
}
