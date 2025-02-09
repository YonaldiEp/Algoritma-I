import greenfoot.*;

public class Score extends Actor
{
    private int score = 0;

    public Score()
    {
        updateImage();
    }

    public void act()
    {
        updateImage();
    }

    public void addScore()
    {
        score++;
        updateImage();
    }

    public int getScore()
    {
        return score;
    }

    private void updateImage()
    {
        setImage(new GreenfootImage("SCORE: " + score, 30, Color.BLACK, null));
    }
}
