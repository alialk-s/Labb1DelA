package bobo;

import java.util.Stack;

public class CarTransport extends Truck implements Movable{

    private static final double VALID_DISTANCE = 2;
    private final Stack<Car> transportCars = new Stack<>();
    private boolean rampUpp;

    public CarTransport() {
        super(100, 2, "Car Transport");
        rampUpp = true;
        transportCars.setSize(6);
    }

    public void setRamp (boolean ramp) {
        if (this.getCurrentSpeed()==0)
            rampUpp = ramp;
    }

    public boolean getRamp () {
        return rampUpp;
    }


    public boolean loadCar(Car car) {
        if (!rampUpp && getCurrentSpeed()==0) {

            if (!(car instanceof CarTransport) && transportCars.size()<6 && validDistance(car))
                transportCars.push(car);
        }

        return transportCars.contains(car);

    }

    public boolean validDistance(Car car) {
        return (Math.abs(car.getX()-this.getX())<= VALID_DISTANCE
                || Math.abs(this.getY()-car.getY())<= VALID_DISTANCE);

    }

    public void unloadCars() {
        if (!rampUpp && getCurrentSpeed()==0) {
           while (!transportCars.empty()) {
               Car currentCar = transportCars.pop();
               currentCar.setX(this.getX()+ VALID_DISTANCE + 2*transportCars.size());
               currentCar.setY(this.getY());
           }
        }
    }
    @Override
    public void move() {
        if (getPlatformAngle() == 0) {
            setX(getX() + getCurrentSpeed() * getDx());
            setY(getY() + getCurrentSpeed() * getDy());
        }
        for (Car car : transportCars) {
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }


}
