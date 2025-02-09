import greenfoot.*;

public class Exit extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
        }
    }
}
