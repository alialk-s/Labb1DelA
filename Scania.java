package bobo;

import java.security.InvalidParameterException;

public class Scania extends Truck implements Movable {

    public Scania() {
        super(100, 2, "Scania");
        setColor(Color.green);
        setPlatformAngle(0);
    }

    @Override
    public void move() {
        if (getPlatformAngle() == 0) {
            setX(getX() + getCurrentSpeed() * getDx());
            setY(getY() + getCurrentSpeed() * getDy());
        }
    }

    @Override
    public void turnLeft() {}

    @Override
    public void turnRight() {}



}
