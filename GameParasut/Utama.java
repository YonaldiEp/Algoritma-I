import greenfoot.*;

public class Utama extends World
{
    private static GreenfootSound backgroundMusic = new GreenfootSound("bg.wav");

    public Utama()
    {    
        super(400, 700, 1); 
        prepare();
    }

    private void prepare()
    {
        Judul judul = new Judul();
        addObject(judul, 200, 90);

        Icon icon = new Icon();
        addObject(icon, 200, 250);

        Start start = new Start(this);
        addObject(start, 230, 385);

        About about = new About();
        addObject(about, 230, 457);

        Exit exit = new Exit();
        addObject(exit, 255, 528);
    }

    public void started()
    {
        backgroundMusic.playLoop(); 
    }

    public void stopped()
    {
        backgroundMusic.stop();
    }

    public static void stopMusic()
    {
        backgroundMusic.stop();
    }

    public static void playMusic()
    {
        backgroundMusic.playLoop();
    }
}
