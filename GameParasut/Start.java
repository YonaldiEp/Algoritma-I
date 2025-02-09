import greenfoot.*;

public class Start extends Actor
{
    private Utama mainWorld;

    public Start(Utama mainWorld) {
        this.mainWorld = mainWorld;
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Utama.stopMusic(); 
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
            Greenfoot.start();
        }
    }
}
