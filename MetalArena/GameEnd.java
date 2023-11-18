import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEnd extends Actor
{
    private GreenfootImage Player1Win = new GreenfootImage("PlayerWin1.png");
    private GreenfootImage Player2Win = new GreenfootImage("PlayerWin2.png");
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void whoWon(int winner){
        if (winner == 1){
            setImage (Player1Win);
        }
        else {
            setImage (Player2Win);
        }
    }
}
