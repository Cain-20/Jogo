import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bloco extends BlocoPrincipal
{
    /**
    * Verifica a posição do bloco e atualiza.
     */

    private int x;
    private int y;
    public Bloco(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void act() 
    {
        setLocation(BlocoPrincipal.x + x, BlocoPrincipal.y + y);
    }
    public void started()
    {
        this.x = getX();
        this.y = getY();
    }
}
