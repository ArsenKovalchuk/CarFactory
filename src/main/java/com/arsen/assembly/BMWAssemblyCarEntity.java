package com.arsen.assembly;

public class BMWAssemblyCarEntity extends AssemblyCarEntity{
    public BMWAssemblyCarEntity(String mechanics, String interior, String paint) {
        super(Car.builder()
                .assembleMechanics(mechanics)
                .assembleInterior(interior)
                .paintPanels(paint)
                .performQualityAssurance()
                .build());
    }
}
