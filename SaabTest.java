import bobo.Car;
import bobo.Saab95;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Testing class to test specific methods in class Saab95
 * <p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-26
 */
public class SaabTest {

    Saab95 saab95 = new Saab95();

    @Test
    public void testTurboOn() {
        saab95.setTurboOn();
        saab95.startEngine();

        saab95.gas(0.1);

        assert (saab95.getCurrentSpeed() == 0.2625);
    }

    @Test
    public void testMove() {
        saab95.setDx(Car.LEFT_DIRECTION);
        saab95.startEngine(); saab95.move();
        assertEquals (saab95.getX(), -0.1, 0.0001);
    }

    @Test
    public void testTurnLeftTurnRight() {
        saab95.turnLeft(); saab95.turnRight();

        assertEquals(saab95.getX(), 0.0, 0.00001);
    }
}
