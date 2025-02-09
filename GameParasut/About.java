import greenfoot.*;

public class About extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new AboutWorld()); 
        }
    }
}
