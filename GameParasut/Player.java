import greenfoot.*;

public class Player extends Actor
{
    private static final int SPEED = 5;
    private boolean isFacingRight = true;

    public void act()
    {
        handleMovement();
        checkCollision();
    }

    private void handleMovement()
    {
        if (Greenfoot.isKeyDown("d")) {
            moveRight();
        } else if (Greenfoot.isKeyDown("a")) {
            moveLeft();
        }
    }

    private void moveRight()
    {
        if (!isFacingRight) {
            getImage().mirrorHorizontally();
            isFacingRight = true;
        }
        setLocation(getX() + SPEED, getY());
    }

    private void moveLeft()
    {
        if (isFacingRight) {
            getImage().mirrorHorizontally();
            isFacingRight = false;
        }
        setLocation(getX() - SPEED, getY());
    }

    private void checkCollision()
    {
        if (isTouching(Cloud.class)) {
            ((MyWorld)getWorld()).gameOver();
        } else if (isTouching(Cloud2.class)) {
            ((NextLevel)getWorld()).gameOver();
        }
    }
}
