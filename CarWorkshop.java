package bobo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class represents car workshop where we can repair different types of cars.
 * <p>
 * A workshop is specialized to repair a specific type of cars
 * @param <T> subtype of Car
 *<p></p>
 * @author Ali Alkhaled
 * @since 2021-02-01
 * @version 1.0
 */
public class CarWorkshop <T extends Car> {

    private final int maxNumber;
    private final List<T> cars;

    public CarWorkshop(int maxNumber) {
        this.maxNumber = maxNumber;
        cars = new ArrayList<T>(maxNumber);
    }

    /**
     * A method to check if it is possible to load a vehicle in the workshop
     * @param car the vehicle that should be loaded
     * @return true if car is loaded, false otherwise
     */
    public boolean loadVehicle (T car) {
        if (cars.size()<maxNumber) {
            cars.add(car);
        }
        return cars.contains(car);
    }

    /**
     * A method to bring out an (already loaded) vehicle
     * @param car the car that we want to bring out
     * @return car that will be brought
     */
    public T bringVehicle (T car) {
        if (!cars.contains(car)) {
            throw new InvalidParameterException("There is no such a car!");
        }
        cars.remove(car);
        return car;

    }
}
