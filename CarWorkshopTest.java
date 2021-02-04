import bobo.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarWorkshopTest {

    CarWorkshop <Car> carWorkshop = new CarWorkshop<>(5);
    @Test
    public void testLoadVolvoWithTypeParameterCar() {
        CarWorkshop <Car> carWorkshop = new CarWorkshop(5);
        Volvo240 volvo240 = new Volvo240();

        assertEquals(carWorkshop.loadVehicle(volvo240), true);

    }

    @Test
    public void testLoadSaabWithTypeParameterCar() {
        CarWorkshop <Car> carWorkshop = new CarWorkshop<>(4);
        Saab95 saab95 = new Saab95();

        assertEquals(carWorkshop.loadVehicle(saab95), true);
    }

    @Test
    public void testLoadScaniaWithTypeParameterCar() {
        CarWorkshop <Car> carWorkshop = new CarWorkshop<>(4);

        Scania scania = new Scania();
        assertEquals(carWorkshop.loadVehicle(scania), true);
    }

    @Test
    public void testBringVehicle1() {
        Car car = new Scania();
        carWorkshop.loadVehicle(car);

        assertEquals((carWorkshop.bringVehicle(car) instanceof Car), true);
    }

    @Test
    public void testBringVehicle2() {
        Scania car = new Scania();

        carWorkshop.loadVehicle(car);
        assertEquals((carWorkshop.bringVehicle(car) instanceof Car), true);
    }

    @Test
    public void testBringNonExistingVehicle() {
        Car car = new Volvo240(); boolean exceptionCaught = false;
        try {
            carWorkshop.bringVehicle(car);
        } catch (Exception e) {
            exceptionCaught = true;
        }

        assertEquals(exceptionCaught, true);
    }
}
