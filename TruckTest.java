import bobo.CarTransport;
import bobo.Scania;
import bobo.Truck;
import org.junit.Test;
import static org.junit.Assert.*;

public class TruckTest {
    Truck scania = new Scania();
    Truck carTransport = new CarTransport(6);

    @Test
    public void testPlatFormPositionValidValueScania () {
        scania.changePlatformsPosition(45);

        assertEquals(scania.getPlatformAngle(), 45, 0.001);
    }

    @Test
    public void testPlatFormPositionHugeValueScania() {
        boolean exceptionCaught = false;
        try {
            scania.changePlatformsPosition(90);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue(exceptionCaught);
    }

    @Test
    public void testPlatFormPositionSmallValueScania() {
        boolean exceptionCaught = false;

        try {
            scania.changePlatformsPosition(-5);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue(exceptionCaught);
    }

    @Test
    public void testPlatFormPositionValidValueCarTransport() {
        carTransport.changePlatformsPosition(70);

        assertEquals(carTransport.getPlatformAngle(), 70, 0.001);
    }

    @Test
    public void testPlatFormPositionHugeValueCarTransport() {
        boolean exceptionCaught = false;
        try {
            carTransport.changePlatformsPosition(80);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue(exceptionCaught);
    }

    @Test
    public void testPlatFormPositionSmallValueCarTransport() {
        boolean exceptionCaught = false;

        try {
            carTransport.changePlatformsPosition(-10);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertTrue(exceptionCaught);
    }
}
