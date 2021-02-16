package bobo;

import java.awt.*;
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
public abstract class Car {   //IMPROVEMENT NEEDED
    public final static double LEFT_DIRECTION = -1, RIGHT_DIRECTION = 1, FRONT_DIRECTION = 1, BACK_DIRECTION = -1;
    private double x, y;
    private double dx, dy;
    private double enginePower; // the engine power of the car
    private double currentSpeed; // car's speed
    private int nrDoors;         // number of doors
    private String modelName;     // model name of the car
    private Color color; // color of the car

    public Car (double enginePower, int nrDoors, String modelName) {
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.modelName = modelName;
        dx = RIGHT_DIRECTION;
        stopEngine();
    }

    /**
     * A method to get the position of the car in x-axis
     * @return car's positon in x-axis
     */
    public double getX() {
        return x;
    }

    /**
     * A method to (re)set the position of the car in x-axis
     * @param x car's position in x-axis
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * A method to get the position of the car in y-axis
     * @return car's position in y-axis
     */
    public double getY() {
        return y;
    }

    /**
     * A method to (re)set the position of the car in y-axis
     * @param y car's position in y-axis
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * A method to get the direction of the car in x-axis
     * @return car's direction in x-axis
     */
    public double getDx() {
        return dx;
    }

    /**
     * A method to (re)set the direction of the car in x-axis
     * @param dx left or right
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * A method to get the direction of the car in y-axis
     * @return car's direction in y-axis
     */
    public double getDy() {
        return dy;
    }

    /**
     * A method to (re)set the direction of the car in y-axis
     * @param dy front or back direction
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * A method to get how many doors the car has
     * @return number of doors of the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * A method to get the engine power of the car
     * @return engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * A method to get the current speed of the car
     * @return current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * A method to get the color of the car
     * @return color of the car
     */
    public Color getColor(){
        return color;
    }


    /**
     * A method to set the color of the car
     * @param clr color of the car
     */
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
            throw new InvalidParameterException("Invalid value");
        incrementSpeed(amount);
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
     * A helper method to increase the car's speed with
     * @param amount percents that the car will increase its speed with, and its must
     *                   be within the intervals (0, 1)
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        /*System.out.println("Speed factor: " + speedFactor());
        System.out.println("Amount: " + amount);
        System.out.println("Engine power: " + enginePower);
        System.out.println("current speed: " + currentSpeed);

         */
    }

    /**
     * A helper method to decrease the car's speed with
     * @param amount percents that the car will decrease its speed with, and its must
     *               be within the intervals (0, 1)
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    /**
     * A method to calculate the speed factor of a car
     * @return speed factor
     */
    protected abstract double speedFactor();

}
