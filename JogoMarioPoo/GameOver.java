import greenfoot.*;  
import greenfoot.GreenfootImage;
import greenfoot.Actor;

/**
 Inicializa foto de fundo do gameOver quando o jogador perde o jogo.
 */
public class GameOver extends World
{
 
    

    public GameOver()
    {    
        super(800, 600, 1, false); 
        GreenfootImage fundo = new GreenfootImage("GameOver.jpeg");
        fundo.scale(800,600);
        setBackground(fundo);
       
    
       
    }
    
  
}
