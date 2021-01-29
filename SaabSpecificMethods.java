import bobo.Saab95;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class to test specific methods in class Saab95
 * <p></p>
 * @author  Ali Alkhaled
 * @version 1.0
 * @since   2021-01-26
 */
public class SaabSpecificMethods {

    Saab95 saab95 = new Saab95();

    @Test
    public void testTurboOn () {
        saab95.setTurboOn();
        saab95.startEngine();

        saab95.gas(0.1);

        assert (saab95.getCurrentSpeed()==0.2625);
    }

}
