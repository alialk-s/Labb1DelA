package bobo;

/**
 * Class Saab95 represents a certain model of Saab cars, and extends the abstract class Car.
 * <p>
 * Saab95 does have some specific properties compared to other cars
 *<p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-22
 */
public class Saab95 extends Car{
    private boolean turboOn; // Default value is false

    public Saab95() {
        super(125, 2, "Saab95");
        setColor(Color.red);
        setTurboOff();
    }


    /**
     *  A method to turn on the turbo
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     *  A method to turn off the turbo
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * A method to calculate the speed factor in saab95 depending on the turbo is on/off
     * @return speed factor of saab95
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
