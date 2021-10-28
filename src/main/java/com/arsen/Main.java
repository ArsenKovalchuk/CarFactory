package com.arsen;

import com.arsen.assembly.AssemblyLine;
import com.arsen.assembly.AudiAssemblyCarEntity;
import com.arsen.assembly.BMWAssemblyCarEntity;

public class Main {

    public static void main(String[] args) {
        BMWAssemblyCarEntity bmwAssemblyCarEntity = new BMWAssemblyCarEntity("235j2k3", "Leather", "Red");

        AudiAssemblyCarEntity audiAssemblyCarEntity = new AudiAssemblyCarEntity("435kj34", "Leather", "Black");

        AssemblyLine<BMWAssemblyCarEntity> bmwAssembly = new AssemblyLine("BWM 20D");
        AssemblyLine<AudiAssemblyCarEntity> audiAssembly = new AssemblyLine("Audi A6");

        System.out.println(bmwAssembly.produce(bmwAssemblyCarEntity));
        System.out.println(audiAssembly.produce(audiAssemblyCarEntity));
    }
}
