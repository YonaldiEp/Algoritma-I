import greenfoot.*;

public class AboutWorld extends World
{
    public AboutWorld()
    {    
        super(400, 700, 1); 
        prepare();
    }

    private void prepare()
    {
        Tentang tentang = new Tentang();
        addObject(tentang, 200, 325);
        
        Back back = new Back();
        addObject(back, 50, 600);

    }
}
