import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Morte extends Jogador
{
    /**
     * Classe invocada para morte do jogador, encerrando o objeto Mário e
     * retornando ao menu.
     */

    private int animacaoCont;
    private int velocidadeY;
   
   
    
    public Morte(){
    animacaoCont = 0;
    velocidadeY = -30;

        
    }
    public void act() 
    {
        if (getY() >= getWorld().getHeight()+50)
        {
            getWorld().removeObject(this);
            if (PainelVidas.vidas <= 0)
            {
                
                Greenfoot.setWorld(new GameOver());
                GreenfootSound gameOver = new GreenfootSound("Som_GameOver.wav");
                gameOver.setVolume(75);
                gameOver.playLoop();
                
                   
            }
            else
            {
                Greenfoot.setWorld(new Mundo(TextoMenu.imgMundo, PainelVidas.vidas));
            }
            return;
        }
        animacaoCont++;
        velocidadeY++;
        turn(15);
        setLocation(getX(), getY() + velocidadeY);
    }
}
