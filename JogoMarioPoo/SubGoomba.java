import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SubGoomba extends Goomba
{
    /**
     * Classe para verificar se jogador consegue matar inimigo Goomba.
     */
    
     public SubGoomba(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
    public void act() 
    {
        if (getOneIntersectingObject(Jogador.class) != null && Jogador.caindo == true)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                Jogador.velocidadeY = -(Jogador.puloMaximo + 5);
            }
            else
            {
                Jogador.velocidadeY = -(Jogador.puloMaximo);
            }
            seMata();
            PainelPontos.pontos += 50;
        }
        
        movimenta();
        gravidade();
    }
   
}
