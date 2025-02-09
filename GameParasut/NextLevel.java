import greenfoot.*;

public class NextLevel extends World
{
    private long lastSpawned = 0;
    private long cooldown = 4000;
    private Player player;
    private Score score;
    private GreenfootSound backgroundMusic = new GreenfootSound("wind.wav"); 
    private GreenfootSound scoreSound = new GreenfootSound("cek.wav");

    public NextLevel()
    {    
        super(400, 700, 1); 
        prepare();
    }

    private void prepare()
    {
        player = new Player();
        score = new Score();
        addObject(player, 200, 150);
        addObject(score, 70, 25);
    }

    public void act()
    {
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
        }
        updateGameLevel();
        updateGame();
    }

    private void updateGame()
    {
        long currentTime = System.currentTimeMillis();
        if (currentTime >= lastSpawned + cooldown) {
            spawnClouds();
            lastSpawned = currentTime;
        }
        checkScore();
    }

    private void updateGameLevel()
    {
        int currentScore = score.getScore(); 

        if (currentScore < 10) {
            cooldown = 4000;
            Cloud2.setSpeed(1);
            Cloud2.setHorizontalSpeed(1);
        } else if (currentScore < 30) {
            cooldown = 3000;
            Cloud2.setSpeed(2);
            Cloud2.setHorizontalSpeed(2);
        } else if (currentScore < 50) {
            cooldown = 2000;
            Cloud2.setSpeed(3);
            Cloud2.setHorizontalSpeed(3);
        } else {
            cooldown = 1000;
            Cloud2.setSpeed(4);
            Cloud2.setHorizontalSpeed(4);
        }
    }

    private void spawnClouds()
    {
        for (int i = 0; i < 3; i++) {
            int x = Greenfoot.getRandomNumber(400);
            addObject(new Cloud2(), x, 700);
        }
    }

    private void checkScore()
    {
        Cloud2[] clouds = getObjects(Cloud2.class).toArray(new Cloud2[0]);
        for (int i = clouds.length - 1; i >= 0; i--) {
            Cloud2 cloud = clouds[i];
            if (cloud.getY() <= player.getY()) {
                score.addScore();
                scoreSound.play();
                removeObject(cloud);
            }
        }
    }

    public void gameOver()
    {
        GreenfootImage gameOverImage = new GreenfootImage("Game Over", 50, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(gameOverImage, getWidth()/2 - gameOverImage.getWidth()/2, getHeight()/2 - gameOverImage.getHeight()/2);
        backgroundMusic.stop();
        Greenfoot.delay(100); 
        Utama utama = new Utama();
        Greenfoot.setWorld(utama); 
        Utama.playMusic();
    }

    public void started()
    {
        backgroundMusic.playLoop(); 
    }

    public void stopped()
    {
        backgroundMusic.stop();
    }

    public void playMusic()
    {
        backgroundMusic.playLoop();
    }

    public Score getScore()
    {
        return score;
    }
}
