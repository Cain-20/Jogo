import greenfoot.*;  
import greenfoot.GreenfootImage;

/**
 Inicializa foto de fundo do gamewin quando o jogador ganha o jogo.
 */
public class GameWin extends World
{
 
    

    public GameWin()
    {    
        super(800, 600, 1, false); 
        GreenfootImage fundo = new GreenfootImage("GameWin.png");
        fundo.scale(800,600);
        setBackground(fundo);
       
    
       
    }
    
  
}
