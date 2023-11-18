import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Incializa o menu de textos, seta a música tema e a imagem base pra 
 * criação do mundo.
 */


public class TextoMenu extends Actor
{
   
    private GreenfootSound tema;
    public static GreenfootImage imgMundo;
    private boolean selecionado;

    public TextoMenu(){
    tema = new GreenfootSound("Som_Tema.mp3");
    imgMundo = new GreenfootImage("TESTEGIOVANNA.png");
    selecionado = false;
    }
     
    public void clicado(java.lang.Object obj, int acao)
    {
    
        if (Greenfoot.mouseClicked(obj) == true)
        {
            tema.stop();
            runAction(acao);
        }
    }
    public void stopped()
    {
        tema.stop();
    }
    public void runAction(int acao)
    {
        
       getWorld().removeObjects(getWorld().getObjects(null));
       Greenfoot.setWorld(new Mundo(imgMundo, 3));    
        
      
    }

}
