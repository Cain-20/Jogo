import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class IniciaJogo extends TextoMenu
{
    /**
     * Seta texto de inicia jogo.
     */
    private boolean mousePos = false;
    GreenfootImage texto1 = new GreenfootImage("Inicia jogo", 50, new Color(242, 220, 75), new Color(0, 0, 0, 0));
    GreenfootImage texto2 = new GreenfootImage("Inicia jogo", 50, new Color(236, 172, 43), new Color(0, 0, 0, 0));
    IniciaJogo()
    {
        setImage(texto2);
    }
    public void act() 
    {
        if (mousePos == true)
        {
            setImage(texto1);
        }
        else
        {
            setImage(texto2);
        }
        checkMouse(mousePos);
        clicado(this, 0);
    }
    public void checkMouse(boolean estado)
    {
        if ((!mousePos && Greenfoot.mouseMoved(this)) || (mousePos && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)))
        {
            mousePos = !estado;
        }
    }
}
