package bobo;

import java.security.InvalidParameterException;

public abstract class Truck extends Car {

    private double platformAngle;

    public Truck(double enginePower, int nrDoors, String modelName) {
        super(enginePower, nrDoors, modelName);
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }

    @Override
    protected double speedFactor() {
        return 0;
    }


    public void changePlatformsPosition(double angle) {

        if (getCurrentSpeed() == 0) {
            if (angle > 0 && angle <= 70) {
                platformAngle = angle;
            } else {
                throw new InvalidParameterException("Invalid Angle");
            }
        }
        else {
            throw new IllegalStateException("Car is moving");
        }
    }

}
