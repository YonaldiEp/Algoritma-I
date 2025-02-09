import greenfoot.*;

public class Back extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Utama.stopMusic();
            Greenfoot.setWorld(new Utama());
            Utama.playMusic();
        }
    }
}
