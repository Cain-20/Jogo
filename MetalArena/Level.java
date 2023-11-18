import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Actor
{
    private int level = 1;
    private GreenfootImage levels [] = new GreenfootImage[3];    

    public Level(){
        for (int i = 1; i <= levels.length ; i++)
        {
            levels[i - 1] = new GreenfootImage(i + ".png");
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    

    public void setLevel(){
        level ++;
        if (level == 4){
            level = 1;
        }
        setImage (levels[level - 1]);
    }

    public void remove() //Remove
    {
        getWorld().removeObject(this);
    }
}
