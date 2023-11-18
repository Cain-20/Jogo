import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    private GreenfootImage title1 = new GreenfootImage("Title1.png");
    private GreenfootImage title2 = new GreenfootImage("Title2.png");
 
    private int animationDelay = 30;
    private int titleStagger = -15;
    private boolean blink = false;

    public void act() 
    {
        titleBlink();
    }    

    private void titleBlink(){
        if (titleStagger <= animationDelay){
            titleStagger++;
        }
        else{
            if (blink){
                setImage (title1);
                blink = false;
            }
            else{
                setImage (title2);
                blink = true;
            }
            titleStagger = -15;
        }
    }

    public void remove() //Remove
    {
        getWorld().removeObject(this);
    }
}
