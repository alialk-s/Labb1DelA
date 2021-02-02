package bobo;

/**
 * Class Volvo240 represents a certain model of Volvo cars, and extends the abstract class Car.
 * <p>
 * Volvo240 does have some specific properties compared to other cars
 * <p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-22
 */
public class Volvo240 extends Car implements Movable{
    private final static double trimFactor = 1.25;


    public Volvo240(){
        super(100, 4, "Volvo240");
        setColor(Color.black);
    }


    /**
     * A method to calculate the speed factor in Volvo240
     * @return speed factor of Volvo240
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * A method to change the location of the car, in x-coordinate and y-coordinate, depending on car's speed
     */

    public void move() {
        setX(getX() + getCurrentSpeed()*getDx());
        setY(getY() + getCurrentSpeed()*getDy());
    }

    /**
     * A method to turn the car into the left
     */
    public void turnLeft() {

    }

    /**
     * A method to turn the car into the right
     */
    public void turnRight() {

    }


}
