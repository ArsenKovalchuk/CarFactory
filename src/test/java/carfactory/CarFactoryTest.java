package carfactory;

import com.arsen.assembly.AssemblyLine;
import com.arsen.assembly.AudiAssemblyCarEntity;
import com.arsen.assembly.BMWAssemblyCarEntity;
import com.arsen.assembly.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CarFactoryTest {
    BMWAssemblyCarEntity bmwAssemblyCarEntity;
    AudiAssemblyCarEntity audiAssemblyCarEntity;

    AssemblyLine<AudiAssemblyCarEntity> audiAssemblyLine;
    AssemblyLine<BMWAssemblyCarEntity> bmwAssemblyLine;

    @Before
    public void setUp() {
        bmwAssemblyCarEntity = new BMWAssemblyCarEntity("235j2k3", "Leather", "Red");
        audiAssemblyCarEntity = new AudiAssemblyCarEntity("435kj34", "Leather", "Black");
        bmwAssemblyLine = new AssemblyLine("BWM 20D");
        audiAssemblyLine = new AssemblyLine("Audi A6");
    }

    @After
    public void tearDown() {
        bmwAssemblyCarEntity = null;
        audiAssemblyCarEntity = null;
        bmwAssemblyLine = null;
        audiAssemblyLine = null;
    }

    @Test
    public void assembleBMWCarTest() {
        Car bmw = bmwAssemblyLine.produce(bmwAssemblyCarEntity);
        assertEquals(bmw.getChassis(), "235j2k3");
        assertEquals(bmw.getInterior(), "Leather");
        assertEquals(bmw.getPaint(), "Red");
        assertFalse(bmw.isPanelsPolished());

        assertEquals(bmw.toString(), "Car with chassis 235j2k3 with interior Leather with paint color Red");
    }

    @Test
    public void assembleAudiCarTest() {
        Car audi = audiAssemblyLine.produce(audiAssemblyCarEntity);
        assertEquals(audi.getChassis(), "435kj34");
        assertEquals(audi.getInterior(), "Leather");
        assertEquals(audi.getPaint(), "Black");
        assertTrue(audi.isPanelsPolished());

        assertEquals(audi.toString(), "Car with chassis 435kj34 with interior Leather with paint color " +
                "Black with panels polished");
    }

    /*
    * Can add additional tests here with Mockito by mocking the Utils class and manually calling the generateRating
    * method for validating the validation station and much more.. However I hope just the basics here will suffice
    * for now.
    * */
}
