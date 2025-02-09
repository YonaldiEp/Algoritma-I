import greenfoot.*; 

public class Cloud2 extends Actor
{
    private static int speed = 1;
    private static int horizontalSpeed = 2;  
    private static boolean movingRight = true;  

    public void act()
    {
        setLocation(getX(), getY() - speed);
        if (((NextLevel)getWorld()).getScore().getScore() < 50) {
            moveHorizontally();
        }
        if (getY() <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void moveHorizontally()
    {
        if (movingRight) {
            setLocation(getX() + horizontalSpeed, getY());
            if (getX() >= getWorld().getWidth() - 1) {
                movingRight = false;
            }
        } else {
            setLocation(getX() - horizontalSpeed, getY());
            if (getX() <= 1) {
                movingRight = true;
            }
        }
    }

    public static void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }

    public static void setHorizontalSpeed(int newSpeed)
    {
        horizontalSpeed = newSpeed;
    }

    public static void setMovingRight(boolean direction)
    {
        movingRight = direction;
    }
}
