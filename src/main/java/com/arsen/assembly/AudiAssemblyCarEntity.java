package com.arsen.assembly;

public class AudiAssemblyCarEntity extends AssemblyCarEntity{
    public AudiAssemblyCarEntity(String mechanics, String interior, String paint) {
        super(Car.builder()
                .assembleMechanics(mechanics)
                .assembleInterior(interior)
                .paintPanelsPreparePolish(paint)
                .polishPanels()
                .performQualityAssurance()
                .build());
    }
}
