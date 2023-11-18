import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Player
{
    private GreenfootImage head = new GreenfootImage("Head.png"); 
    private GreenfootImage headBack = new GreenfootImage("Head.png"); 

    public Life(int whichPlayer){
        headBack.mirrorHorizontally();
        if (whichPlayer == 1){
            setImage (head);
        }
        else{
            setImage (headBack);
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    

    public void removeMe(){
        getWorld().removeObject(this);
    }
}
