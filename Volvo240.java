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
public class Volvo240 extends Car{
    public final static double trimFactor = 1.25;


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
     * A method to increase the car's speed with
     * @param amount percents that the car will increase its speed with, and its must
     */
    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    /**
     * A method to decrease the car's speed with
     * @param amount percents that the car will decrease its speed with, and its must
     */
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }



}
