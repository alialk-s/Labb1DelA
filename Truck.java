package bobo;

import java.security.InvalidParameterException;

/**
 * A class, subclass of Car, represents a truck and is inherited by different types of truck
 * <p></p>
 * @author Ali Alkhaled
 * @since 2021-02-01
 * @version 1.0
 */
public abstract class Truck extends Car {

    private double platformAngle;

    public Truck(double enginePower, int nrDoors, String modelName) {
        super(enginePower, nrDoors, modelName);
    }

    /**
     * A method to get the value of platform's angle
     * @return platformAngle
     */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * A method to (re)set the platform angle
     * @param platformAngle platform's angle value
     */
    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }


    /**
     * A method to get the speed factor of a truck
     * @return speed factor of the truck
     */
    @Override
    protected double speedFactor() {
        return 1.0;
    }


    /**
     * A method to (re)set the value of platform's angle where the value must be with in the interval 0 - 70 degree
     * <p>
     * Also, the truck must be in sleep mode, i.e. its speed must be zero, to be able to change platform's position
     * @param angle desired angle
     */
    public void changePlatformsPosition(double angle) {
        if (getCurrentSpeed() != 0)
            throw new IllegalStateException("Car is moving");
        if (angle < 0 || angle > 70)
            throw new InvalidParameterException("Invalid Angle");

        platformAngle = angle;
    }

}
