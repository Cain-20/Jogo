import greenfoot.*;  

/**
 Classe do inimigo Goomba, inicializa seus atributos, realiza seus movimentos,
 * verifica sua vida, e ajusta sua localização com a gravidade. 
 */
public class Goomba extends Actor
{
    
    private int velocidadeY;
    private boolean caindo;
    private boolean andaDireita;
    private static final int velocidadeMov = 2;
    public int x;
    public int y;
    private boolean viva;
    private GreenfootImage continuaDireitaGoomba;
    private GreenfootImage direta1Goomba;
    private GreenfootImage direita2Goomba;
    private GreenfootImage direita3Goomba;
    private GreenfootImage direita4Goomba;
    private GreenfootImage continuaEsquerdaGoomba;
    private GreenfootImage esquerda1Goomba;
    private GreenfootImage esquerda2Goomba;
    private GreenfootImage esquerda3Goomba;
    private GreenfootImage esquerda4Goomba;
    private GreenfootSound goombaMorta;
    private int imagemDireita;
    private int imagemEsquerda;
    private int animacaoCont;
   
    
    public Goomba(){                                                    
    continuaDireitaGoomba = new GreenfootImage("Goomba_anda_direita.png");
    direta1Goomba = new GreenfootImage("Goomba_anda_direita_1.png");
    direita2Goomba = new GreenfootImage("Goomba_anda_direita_2.png");
    direita3Goomba = new GreenfootImage("Goomba_anda_direita_3.png");
    direita4Goomba = new GreenfootImage("Goomba_anda_direita_4.png");
    continuaEsquerdaGoomba = new GreenfootImage("Goomba_anda_esquerda.png");
    esquerda1Goomba = new GreenfootImage("Goomba_anda_esquerda_1.png");
    esquerda2Goomba = new GreenfootImage("Goomba_anda_esquerda_2.png");
    esquerda3Goomba = new GreenfootImage("Goomba_anda_esquerda_3.png");
    esquerda4Goomba = new GreenfootImage("Goomba_anda_esquerda_4.png");
    goombaMorta = new GreenfootSound("Som_Goomba.mp3");
    velocidadeY = 0;
    caindo = true;
    andaDireita = false;
    viva = true;
    x = -1;
    y = -1;
    imagemDireita = 0;
    imagemEsquerda = 0;
    animacaoCont = 0;
    
    }
    

    
    public void seMata()
    {
    
        viva = false;
        if (andaDireita)
        {
            setImage(continuaDireitaGoomba);
        }
        else
        {
            setImage(continuaEsquerdaGoomba);
        }  
    }
    // Atualiza posições
  
    public void setRelLocation(int x, int y)
    {
    
        this.x = x;
        this.y = y;
        this.setLocation(BlocoPrincipal.x+getRelX(), BlocoPrincipal.y+getRelY());
    }
    // Retorna as posições relativas
    public int getRelX()
    {
        return x;
    }
    public int getRelY()
    {
        return y;
    }
    // Realiza movimentos e ajusta imagens da Goomba
    public void movimenta()
    {
         
         
        if (andaDireita  && viva )
        {
            andaDireita = true;
            setRelLocation(getRelX()+velocidadeMov, getRelY());
            if (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null ||
                        getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setRelLocation(getRelX()-2, getRelY());
                    andaDireita = false;
                }
            }
            if (animacaoCont >= 3)
            {
                if (imagemDireita == 0)
                {
                    setImage(direta1Goomba);
                    imagemDireita = 1;
                    animacaoCont = 0;
                }
                else if (imagemDireita == 1)
                {
                    setImage(direita2Goomba);
                    imagemDireita = 2;
                    animacaoCont = 0;
                }
                else if (imagemDireita == 2)
                {
                    setImage(direita3Goomba);
                    imagemDireita = 3;
                    animacaoCont = 0;
                }
                else if (imagemDireita == 3)
                {
                    setImage(direita4Goomba);
                    imagemDireita = 4;
                    animacaoCont = 0;
                }
                else if (imagemDireita == 4)
                {
                    setImage(direta1Goomba);
                    imagemDireita = 1;
                    animacaoCont= 0;
                }
            }
            
        }
        else if (andaDireita == false && viva == true)
        {
            andaDireita = false;
            setRelLocation(getRelX()-velocidadeMov, getRelY());
            if (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null ||
                        getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setRelLocation(getRelX()+2, getRelY());
                    andaDireita = true;
                }
            }
            if (animacaoCont >= 3)
            {
                if (imagemEsquerda == 0)
                {
                    setImage(esquerda1Goomba);
                    imagemEsquerda = 1;
                    animacaoCont = 0;
                }
                else if (imagemEsquerda == 1)
                {
                    setImage(esquerda2Goomba);
                    imagemEsquerda = 2;
                    animacaoCont = 0;
                }
                else if (imagemEsquerda == 2)
                {
                    setImage(esquerda3Goomba);
                    imagemEsquerda = 3;
                    animacaoCont = 0;
                }
                else if (imagemEsquerda == 3)
                {
                    setImage(esquerda4Goomba);
                    imagemEsquerda = 4;
                    animacaoCont = 0;
                }
                else if (imagemEsquerda == 4)
                {
                    setImage(esquerda1Goomba);
                    imagemEsquerda = 1;
                    animacaoCont = 0;
                }
            }
        }
        if (viva == false)
        {
            if (getImage().getHeight() > 2)
            {
                getImage().scale(getImage().getWidth(), getImage().getHeight() - 24);
                setRelLocation(getRelX(), getRelY() + 12);
                goombaMorta.play();
                return;
            }
            else
            {
                getWorld().removeObject(this);
                return;
            }
        }
        animacaoCont++;
    }
    // Ajusta gravidade de acordo com as colisões
    public void gravidade()
    {
        if (viva==false)
        {
            return;
        }
        velocidadeY += Mario.gravidade;
        setRelLocation(getRelX(), getRelY() + velocidadeY);
        caindo = true;
        if ((getOneIntersectingObject(Bloco.class) != null ||
                getOneIntersectingObject(BlocoChao.class) != null) && velocidadeY <0)
        {
            while (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                setRelLocation(getRelX(), getRelY()+1);
                velocidadeY = 0;
            }
            setRelLocation(getRelX(), getRelY()+1);
        }
        if (getOneIntersectingObject(Bloco.class) != null ||
                getOneIntersectingObject(BlocoChao.class) != null)
        {
            while (getOneIntersectingObject(Bloco.class) != null ||
                    getOneIntersectingObject(BlocoChao.class) != null)
            {
                setRelLocation(getRelX(), getRelY()-1);
                caindo = false;
                velocidadeY = 0;
            }
        }

    }
}
