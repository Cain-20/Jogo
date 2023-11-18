import greenfoot.*;  


/**
* Criação do painel de pontos no canto superior esquerdo,
 */
public class PainelPontos extends Actor
{
 
    public static long pontos = 0;
    
    public PainelPontos()
    {
        GreenfootImage imagemPainel = new GreenfootImage("Pontos: "+String.valueOf(0), 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(imagemPainel);
        pontos = 0;
    }
    
      public void act() 
    {
        setImage(new GreenfootImage("Pontos: "+String.valueOf(pontos), 40, Color.BLACK, new Color(0, 0, 0, 0))); 
    }
}
