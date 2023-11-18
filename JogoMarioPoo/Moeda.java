import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cria a moeda com sua posição, caso haja interseção com o jogador, as moedas 
 * * são removidas.
 */
public class Moeda extends Actor
{
    private int x;
    private int y;
    private GreenfootSound musicaMoeda;
    
    public Moeda(int x, int y){
        this.x = x;
        this.y = y;
        musicaMoeda = new GreenfootSound("Som_Moeda.mp3");
    }
    
    public void act()
    {
        setLocation(BlocoPrincipal.x + x, BlocoPrincipal.y + y);
        if (getOneIntersectingObject(Jogador.class) != null)
        {
            getWorld().removeObject(this);
            PainelPontos.pontos += 10;
            musicaMoeda.setVolume(40);
            musicaMoeda.play();
        } 
    }
    
    public void inicia(){
        this.x = getX();
        this.y = getY();
    }
}
