import greenfoot.*; 

public class Cloud extends Actor
{
    private static int speed = 1;

    public void act()
    {
        setLocation(getX(), getY() - speed);
        if (getY() <= 0) {
            getWorld().removeObject(this);
        }
    }

    public static void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
}

