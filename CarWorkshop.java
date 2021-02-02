package bobo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CarWorkshop <T extends Car> {

    private final int maxNumber;
    private final List<T> cars;

    public CarWorkshop(int maxNumber) {
        this.maxNumber = maxNumber;
        cars = new ArrayList<T>(maxNumber);
    }

    public boolean loadVehicle (T car) {
        if (this.cars.size()<maxNumber) {
            cars.add(car);
        }
        return this.cars.contains(car);
    }

    public String bringVehicle (T car) {
        if (!this.cars.contains(car)) {
            throw new InvalidParameterException("There is no such a car!");
        }
        this.cars.remove(car);
        return car.toString();

    }
}
