import bobo.*;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * CarTest is a testing class to test methods in class Car.
 * <p></p>
 * @author  Ali Alkhaled
 * @since   2021-01-25
 * @version 1.0
 */
public class CarTest {

    Car volvo240 = new Volvo240();
    Car saab95 = new Saab95();

    @Test
    public void testInitializingValueVolvo () {
        assert (volvo240.getNrDoors()==4 && volvo240.getEnginePower()==100 && volvo240.getColor()==Color.black);

    }

    @Test
    public void testInitializingValueSaab () {
        assert (saab95.getNrDoors()==2 && saab95.getEnginePower()==125 && saab95.getColor()==Color.red);

    }


    @Test
    public void testGasVolvo () {
        volvo240.startEngine();
        volvo240.gas(1);

        //assert (volvo240.getCurrentSpeed()==1.35);

        assertEquals(volvo240.getCurrentSpeed(), 1.35, 0.001);
    }

    @Test
    public void testBrakeVolvo () {
        volvo240.startEngine();
        volvo240.brake(1);

        assert (volvo240.getCurrentSpeed()==0);
    }

    @Test
    public void testGasSaab () {
        saab95.startEngine();
        saab95.gas(0.05);

        assert (saab95.getCurrentSpeed()==0.1625);
    }

    @Test
    public void testBrakeSaab () {
        saab95.startEngine();
        saab95.brake(0.03);

        assert (saab95.getCurrentSpeed()==0.0625);
    }

    @Test
    public void testThrowExceptionsPositiveGasVolvo () {
        boolean thrown = false;

        try {
            volvo240.gas(2);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsNegativeGasVolvo () {
        boolean thrown = false;

        try {
            volvo240.gas(-4);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsPositiveBrakeVolvo () {
        boolean thrown = false;

        try {
            volvo240.brake(2);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsNegativeBrakeVolvo () {
        boolean thrown = false;

        try {
            volvo240.brake(-1.5);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }


    @Test
    public void testThrowExceptionsPositiveGasSaab () {
        boolean thrown = false;

        try {
            saab95.gas(5);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsNegativeGasSaab () {
        boolean thrown = false;

        try {
            saab95.gas(-7);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsPositiveBrakeSaab () {
        boolean thrown = false;

        try {
            saab95.brake(1.2);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testThrowExceptionsNegativeBrakeSaab () {
        boolean thrown = false;

        try {
            saab95.brake(-0.6);
        } catch (InvalidParameterException exception) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void testTempTurnLeftAndRight () {
        //TODO
        assert (volvo240.getCurrentSpeed()==0 && saab95.getCurrentSpeed()==0);
    }

}
