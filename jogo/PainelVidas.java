import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
* Painel de vidas do jogador demonstrado no canto superior esquerdo.
 */
public class PainelVidas extends Actor
{

    public static int vidas = 0;
    
    public PainelVidas(int qtdVidas)
    {
        GreenfootImage vidaImagem = new GreenfootImage("Vidas: "+String.valueOf(qtdVidas), 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(vidaImagem);
       vidas = qtdVidas;
    }
    
    public void act() 
    {
        if (PainelPontos.pontos >= 1000 && vidas <= 9)
        {
            vidas++;
            PainelPontos.pontos -= 1000;
        }
        setImage(new GreenfootImage("Vidas: "+String.valueOf(vidas), 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }   
 
}
