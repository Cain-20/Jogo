import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Verifica os movimentos do jogador, verifica gravidade, se foi morto pela 
* goomba e atualização do mapa.
 */
public class Jogador extends Mario
{
    
    public Jogador(){
        
    }
     public void act() 
    {
        
        
        vivo = true;     
        int tamMovimento = 300;
        movimenta();         
    
        // Realiza movimentos 
        if (getX()>= getWorld().getWidth()-tamMovimento)
        {
            BlocoPrincipal.x -= velocidadeMov;
            if (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null ||
                        getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setLocation(getX()-velocidadeMov, getY());
                }
            }
            while (getX()>= getWorld().getWidth()-tamMovimento)
            {
                setLocation(getX()-1, getY());
            }
        }
        if (getX()<= tamMovimento)
        {
            BlocoPrincipal.x += velocidadeMov;
            if (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null ||
                        getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setLocation(getX()+velocidadeMov, getY());

                }
            }
            while (getX() <= tamMovimento)
            {
                setLocation(getX()+1, getY());
            }
        }
       
        // Verifica se foi morto pela Goomba
        if (morreGoomba() == true) 
        {
            return;
        }
        
        // Calcula gravidade com as colisões
        gravidade(); 
        
        // Mata jogador se for além do mapa
        if (getY()+30 > getWorld().getHeight())  
        {
            morre();
        }
        
       
    }    
}
