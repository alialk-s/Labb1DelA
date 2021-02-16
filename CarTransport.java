package bobo;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.Stack;

/**
 * A class, subclass of truck, that represents a movable car transport, with a certain ramp capacity
 *<p></p>
 * @author Ali Alkhaled
 * @since 2021-02-01
 * @version 1.0
 */
public class CarTransport extends Truck implements Movable {

    private static final double VALID_DISTANCE = 2;
    private final int rampCapacity;
    private final Stack<Car> transportCars = new Stack<>();
    private boolean rampUp;

    public CarTransport(int rampCapacity) {
        super(100, 2, "Car Transport");
        this.rampCapacity = rampCapacity;
        setColor(Color.BLACK);
        setRampUp();
    }

    /**
     * An overridden method that change platform's angle
     * <p>
     * Car transport's angle either 0 or 70
     * @param angle desired angle
     */
    @Override
    public void changePlatformsPosition(double angle) {
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Car is moving");
        if (angle != 0 && angle != 70)
            throw new InvalidParameterException("Invalid Angle");

        setPlatformAngle(angle);
    }

    /**
     * A method to set the ramp up
     */
    public void setRampUp() {
        changePlatformsPosition(0);
        rampUp = true;
    }

    /**
     * A method to set the ramp down
     */
    public void setRampDown() {
        changePlatformsPosition(70);
        rampUp = false;
    }

    /**
     * A method to get the value of rampUpp
     * @return Value of rampUp
     */
    public boolean getRamp() {
        return rampUp;
    }

    /**
     * A method to get the number of cars that are loaded on the ramp right now
     * @return number of loaded cars
     */
    public int getNumberOfLoadedCars() {
        return transportCars.size();
    }

    private boolean validDistance(Car car) {
        return (Math.abs(car.getX()-this.getX())<= VALID_DISTANCE
                && Math.abs(this.getY()-car.getY())<= VALID_DISTANCE);

    }

    //private boolean canLoad() ////////////////////////IMPROVEMENT NEEDED
    //private void placeCar() /////////////////////////



    /**
     * A method to load up a car under certain conditions
     * <p> Car transport must be in sleep mode, ramp must be down, valid distance between the car and car transport,
     * car transports can not be loaded and the ramp is not full
     * @param car The car that should be loaded
     * @return true if the car is loaded, false otherwise
     */
    public boolean loadCar(Car car) {
        if (!rampUp && getCurrentSpeed()==0) {

            if (!(car instanceof CarTransport) && transportCars.size()<rampCapacity && validDistance(car))
                transportCars.push(car);
        }
        return transportCars.contains(car);

    }


    /**
     * A method to unload all the cars that have been loaded on the car transport and putting them in valid distances
     */
    public void unloadCars() {
        if (!rampUp && getCurrentSpeed()==0) {
           while (!transportCars.empty()) {
               Car currentCar = transportCars.pop();
               currentCar.setX(this.getX()+ VALID_DISTANCE + 2*transportCars.size());
               currentCar.setY(this.getY());
           }
        }
    }

    /*/**
     * An overridden method to move the car transport with respect to changing the positions of all cars loaded on it
     */

    /**
     * A method, overridden from the interface Movable, to make Car transport move
     */
    @Override
    public void move() {
        if (rampUp) {
            //super.move();
            setX(getX() + getCurrentSpeed()*getDx());
            setY(getY() + getCurrentSpeed()*getDy());
            for (Car car : transportCars) {
                car.setX(this.getX());
                car.setY(this.getY());
            }
        }
    }

    /**
     * A method to turn the car into the left
     */
    @Override
    public void turnLeft() {

    }

    /**
     * A method to turn the car into the right
     */
    @Override
    public void turnRight() {

    }


}
