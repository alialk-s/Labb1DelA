package bobo;

import java.security.InvalidParameterException;


/**
 * The Car class describes the basic properties/actions of a car.
 * <p>
 * instance variables x and y describe the location of a car in x-coordinate and y-coordinate
 * <p>
 * Instance variables dx and dy describe the direction of a car in x-coordinate and y-coordinate
 * <p>
 * Positive dx represents right side, while negative represents left side
 * <p>
 * Positive dy represents front side, while negative represents back side
 * <p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-22
 */
public abstract class Car implements Movable {
    private final static double LEFT_DIRECTION = -1, RIGHT_DIRECTION = 1, FRONT_DIRECTION = 1, BACK_DIRECTION = -1;
    private double x, y;
    private double dx, dy;
    private double enginePower; // the engine power of the car
    private int nrDoors;         // number of doors
    private String modelName;     // model name of the car
    private Color color;          // color of the car

    protected double currentSpeed;

    public Car (double enginePower, int nrDoors, String modelName) {
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.modelName = modelName;
        dy = FRONT_DIRECTION;
        stopEngine();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * A method that turns on the engine and makes the car's speed 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }


    /**
     * A method that turns off the engine and makes the car's speed 0.0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }


    /**
     * A method that makes the user to increase car's speed
     * @param amount the percents that the car while increase its speed with and it must
     *               be within the intervals (0, 1)
     */
    public void gas(double amount){
        if (amount>1 || amount<0)
            throw new InvalidParameterException();
        incrementSpeed(amount);
        move();
    }

    /**
     * A method that makes the user to decrease car's speed
     * @param amount the percents that the car will decrease its speed with, and its must
     *               be within the intervals (0, 1)
     */
    public void brake(double amount){
        if (amount>1 || amount<0)
            throw new InvalidParameterException();
        decrementSpeed(amount);
    }

    /**
     * A method to change the location of the car, in x-coordinate and y-coordinate, depending on car's speed
     */

    @Override
    public void move() {
        setX(getX() + currentSpeed*getDx());
        setY(getY() + currentSpeed*getDy());
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

    /**
     * A method to calculate the speed factor of a car
     * @return double
     */
    protected abstract double speedFactor();

    /**
     * A helper method to increase the car's speed with
     * @param amount percents that the car will increase its speed with, and its must
     *                   be within the intervals (0, 1)
     */
    protected abstract void incrementSpeed(double amount);

    /**
     * A helper method to decrease the car's speed with
     * @param amount percents that the car will decrease its speed with, and its must
     *               be within the intervals (0, 1)
     */
    protected abstract void decrementSpeed(double amount);



}
