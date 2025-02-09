import greenfoot.*;

public class MyWorld extends World
{
    private long lastSpawned = 0;
    private long cooldown = 4000;
    private Player player;
    private Score score;
    private GreenfootSound backgroundMusic = new GreenfootSound("wind.wav"); 
    private GreenfootSound scoreSound = new GreenfootSound("cek.wav");

    public MyWorld()
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
        checkNextLevel();
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
            Cloud.setSpeed(1);
        } else if (currentScore < 30) {
            cooldown = 3000;
            Cloud.setSpeed(2);
        } else if (currentScore < 50) {
            cooldown = 2000;
            Cloud.setSpeed(3);
        } else {
            cooldown = 1000;
            Cloud.setSpeed(4);
        }
    }

    private void spawnClouds()
    {
        for (int i = 0; i < 3; i++) {
            int x = Greenfoot.getRandomNumber(400);
            addObject(new Cloud(), x, 700);
        }
    }

    private void checkScore()
    {
        Cloud[] clouds = getObjects(Cloud.class).toArray(new Cloud[0]);
        for (int i = clouds.length - 1; i >= 0; i--) {
            Cloud cloud = clouds[i];
            if (cloud.getY() <= player.getY()) {
                score.addScore();
                scoreSound.play();
                removeObject(cloud);
            }
        }
    }

    private void checkNextLevel() {
        if (score.getScore() >= 10) {
            nextLevel();
        }
    }

    private void nextLevel() {
        GreenfootImage nextLevelImage = new GreenfootImage("Next Level", 50, Color.BLACK, new Color(0, 0, 0, 0));
        getBackground().drawImage(nextLevelImage, getWidth()/2 - nextLevelImage.getWidth()/2, getHeight()/2 - nextLevelImage.getHeight()/2);
        backgroundMusic.stop();
        Greenfoot.delay(100); 
        NextLevel nextLevel = new NextLevel();
        Greenfoot.setWorld(nextLevel); 
        nextLevel.playMusic();
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

    public Score getScore()
    {
        return score;
    }
}
