import bobo.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTransportTest {
    CarTransport carTransport =  new CarTransport(6);

    @Test
    public void testRestRampPositionInSleepMode() {
        carTransport.setRampUpp();

        assertEquals(carTransport.getRamp(), true);
    }

    @Test
    public void testRestRampPositionInMotion() {
        carTransport.startEngine();

        boolean thrown = false;
        try {
            carTransport.setRampUpp();
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testLoadingCar () {
        Car car = new Saab95();
        carTransport.setRampUpp();

        assertEquals(carTransport.loadCar(car), false);
    }

    @Test
    public void testLoadingCarWhenCarTransportIsMoving() {
        Car car = new Volvo240();
        carTransport.startEngine();

        assertEquals(carTransport.loadCar(car), false);

    }

    @Test
    public void testLoadingCarWhenRampIsUpp() {
        Car car = new Volvo240();

        assertEquals(carTransport.loadCar(car), false);
    }

    @Test
    public void testLoadingCarTransportInCarTransport() {
        Car car = new CarTransport(6);

        assertEquals(carTransport.loadCar(car), false);
    }

    @Test
    public void testLoadingCarWhenRampIsFull() {
        CarTransport carTransport = new CarTransport(1);

        Car car1 = new Volvo240(); Car car2 = new Saab95();

        carTransport.loadCar(car1);

        assertEquals(carTransport.loadCar(car2), false);
    }

    @Test
    public void testLoadingCarFromInvalidDistance() {
        Car car = new Scania();
        car.setY(6); car.setX(1);

        assertEquals(carTransport.loadCar(car), false);
    }

    @Test
    public void testMove() {
        Volvo240 volvo240 = new Volvo240();
        carTransport.setRampDown();
        carTransport.loadCar(volvo240);
        carTransport.setRampUpp();
        carTransport.startEngine(); carTransport.setDx(Car.LEFT_DIRECTION); carTransport.move();

        assertEquals(carTransport.getX(), -0.1, 0.000001);
        assertEquals(volvo240.getX(), -0.1, 0.000001);

    }

    @Test
    public void testUnloadAllCars() {
        carTransport.setRampUpp();
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        carTransport.loadCar(volvo240); carTransport.loadCar(saab95);

        carTransport.unloadCars();

        assertEquals(carTransport.getNumberOfLoadedCars(), 0);
    }

    @Test
    public void testRestRampUpWhileCarIsMoving() {
        carTransport.startEngine();
        boolean thrown = false;

        try {
            carTransport.setRampUpp();
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

    @Test
    public void testRestRampDownWhileCarIsMoving() {
        carTransport.startEngine();
        boolean thrown = false;

        try {
            carTransport.setRampDown();
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

    @Test
    public void testTurnLeftTurnRight() {
        carTransport.turnLeft(); carTransport.turnRight();

        assertEquals(carTransport.getX(), 0.0, 0.0000001);
    }
}
