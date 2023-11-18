import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage plat = new GreenfootImage("Platform.PNG"); // Backup pictures in case I need to edit.
    private GreenfootImage platL = new GreenfootImage("PlatformL1.png"); // Backup pictures in case I need to edit.
    private GreenfootImage platM = new GreenfootImage("PlatformL2.png"); // Backup pictures in case I need to edit.
    private GreenfootImage platS = new GreenfootImage("PlatformL3.png"); // Backup pictures in case I need to edit.

    private int animationDelay = 15;

    private int platformCount = 0;
    private int platformStagger = -15;
    private GreenfootImage platforms [] = new GreenfootImage[4];    
    public Platform(String size){
        for (int i = 1; i <= platforms.length - 1 ; i++)
        {
            platforms[i - 1] = new GreenfootImage("Platform" + size + i +".png");
        }
        platforms[3] = new GreenfootImage ("Platform" + size + "2.png");
        setImage (platforms[0]);
    }

    public void act() 
    {
        platformAnimation();
    }    

    public void platformAnimation(){
        if (platformStagger <= animationDelay){
            platformStagger++;
        }
        else{
            platformCount ++;
            if (platformCount >= 4 || platformCount <= -4){
                platformCount = 0;
            }
            setImage (platforms[platformCount]);
            platformStagger = -15;
        }
    }
}