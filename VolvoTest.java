import bobo.Car;
import bobo.Volvo240;
import com.sun.management.VMOption;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class to test specific methods in class Volvo240
 * <p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-26
 */

public class VolvoTest {

    Volvo240 volvo240 = new Volvo240();

    @Test
    public void testMove() {
        volvo240.setDx(Car.RIGHT_DIRECTION);
        volvo240.startEngine(); volvo240.move();

        assertEquals(volvo240.getX(), 0.1, 0.00001);
    }

    @Test
    public void turnLeftTurnRight() {
        volvo240.turnLeft(); volvo240.turnRight();

        assertEquals(volvo240.getX(), 0.0, 0.00001);
    }
}
