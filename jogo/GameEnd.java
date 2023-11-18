import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import greenfoot.Actor;
/**
 Inicializa foto de fundo do gameOver quando o jogador perde o jogo.
 */
public class GameEnd extends World
{
    private GreenfootImage PlayerWin = new GreenfootImage("PlayerWin.png");
    private Actor actor;
    
    public void GameEnd(int winner){
        if (winner == 1){
            PlayerWin.scale(500,300);
            actor.setImage(PlayerWin);            
        }
    }
}

