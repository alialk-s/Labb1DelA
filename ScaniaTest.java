import bobo.Car;
import bobo.Scania;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScaniaTest {

    Scania scania = new Scania();

    @Test
    public void testMove() {
        scania.setDx(Car.LEFT_DIRECTION);
        scania.startEngine(); scania.move();

        assertEquals(scania.getX(), -0.1, 0.001);
    }

    @Test
    public void testMoveWhenPlatformAngleIsNotZero() {
        scania.setDx(Car.RIGHT_DIRECTION); scania.setDy(Car.FRONT_DIRECTION);
        scania.changePlatformsPosition(10); scania.gas(1); scania.move();

        assertEquals(scania.getX(), 0.0, 0.00001);
    }

    @Test
    public void testTurnLeftTurnRight() {
        scania.turnLeft(); scania.turnRight();

        assertEquals(scania.getX(), 0.0, 0.00001);
    }
}
