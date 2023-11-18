import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Verifica e atualiza posição do bloco de chão.
 */
public class BlocoChao extends BlocoPrincipal
{
    private int x;
    private int y;
    
    public BlocoChao(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void act() 
    {
        setLocation(BlocoPrincipal.x+ x, BlocoPrincipal.y+ y);
    }
    public void started()
    {
        this.x = getX();
        this.y = getY();
    }    
}
