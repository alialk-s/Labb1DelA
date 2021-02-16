package bobo;

import java.awt.*;
import java.security.InvalidParameterException;

/**
 * A class, a subclass of Truck, represents Scania that implements the interface Movable to make it move
 * <p></p>
 * @author Ali Alkhaled
 * @since 2021-02-01
 * @version 1.0
 */
public class Scania extends Truck implements Movable{

    public Scania() {
        super(100, 2, "Scania");
        setColor(Color.green);
        setPlatformAngle(0);
    }

    /**
     * A method, overridden from the interface Movable, to make Scania move
     */
    @Override
    public void move() {
        if (getPlatformAngle() == 0) {
            //super.move();
            setX(getX() + getCurrentSpeed()*getDx());
            setY(getY() + getCurrentSpeed()*getDy());
        }
    }
    /**
     * A method to change the location of the car, in x-coordinate and y-coordinate, depending on car's speed
     */


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
