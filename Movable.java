package bobo;

/**
 * Interface Movable, implemented by the class Car, has some methods that make a car move
 *
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-22
 */
public interface Movable {

    /**
     * A method to change the location of something
     */
    void move();

    /**
     * A method to turn something into the left
     */
    void turnLeft();

    /**
     * A method to turn something into the right
     */
    void turnRight();
}
