import greenfoot.*;  

public class Player extends Actor
{
    /**
     * Define todos os movimentos do Mário, gravidade, sua morte e quando mata
     * * o imigo goomba.
     */
    // Imagens
    private GreenfootImage andaDireita1;    
    private GreenfootImage andaDireita2;
    private GreenfootImage pulaDireita;       
    private GreenfootImage andaDireita;        
    private GreenfootImage andaEsquerda1;  
    private GreenfootImage andaEsquerda2;  
    private GreenfootImage pulaEsquerda;  
    private GreenfootImage andaEsquerda;
    // Sons
    private GreenfootSound pulaSom;
    private GreenfootSound  morreSom;
    private GreenfootSound musicaMoeda;
    // Atributos estaticos     
    public static int velocidadeMov = 7;
    public static boolean vivo = true;   
    public static final int gravidade = 1;
    public static int velocidadeY = 0;
    public static boolean caindo = true;
    public static final int puloMaximo = 20;
    // Demais atributos
    private int pulo = 6;
    private boolean prontoPular = true;
    private boolean andando;                
    private int imagem;                          
    private int andandoCont;
    private boolean andandoDireita;
        
    public Player(){
    // Imagens Mario
    andaDireita1 = new GreenfootImage("Mario_anda_direita_1.png");      
    andaDireita2 = new GreenfootImage("Mario_anda_direita_2.png");      
    pulaDireita= new GreenfootImage("Mario_pula_direita.png");       
    andaDireita = new GreenfootImage("Mario_anda_direita.png");        
    andaEsquerda1 = new GreenfootImage("Mario_anda_esquerda_1.png");  
    andaEsquerda2 = new GreenfootImage("Mario_anda_esquerda_2.png");  
    pulaEsquerda = new GreenfootImage("Mario_pula_esquerda.png");   
    andaEsquerda = new GreenfootImage("Mario_anda_esquerda.png");
    // Sons Mario
    musicaMoeda = new GreenfootSound("Som_Moeda.mp3");
    pulaSom = new GreenfootSound("Som_Pula_Mario.mp3");
    morreSom = new GreenfootSound("Som_Morre_Mario.mp3");
    andando = false;                
    imagem = 0;                          
    andandoCont = 0;
    andandoDireita = true;
    pulo = 6;
    prontoPular = true;
    
      
    }
   // Realiza todos os movimentos do Mário verificando colisões com os blocos
    public void movimenta()
    {
        if (Greenfoot.isKeyDown("shift"))
        {
            velocidadeMov = 10;
        }
        else
        {
            velocidadeMov = 7;
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            andando = true;
            andandoDireita = true;
            andaImagem();
            setLocation(getX()+velocidadeMov, getY());
            if (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setLocation(getX()-2, getY());
    
                }
            }
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            andando = true;
            andandoDireita = false;
            andaImagem();
            setLocation(getX()-velocidadeMov, getY());
            if (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
            {
                while (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
                {
                    setLocation(getX()+2, getY());
                
                }
            }
        }
        else
        {
            andando = false;
            andaImagem();
            andandoCont = 0;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (caindo == false || podePular() == true)
            {
             pula();   
            }
        }
        else
        {
            pulo = 6;
            prontoPular = false;
        }
    }
    
    // Ajusta imagens para demonstrar movimento do Mário
    public void andaImagem()
    {
        if (caindo == false)
        {
            if (andando && andandoDireita && andandoCont == 0)
            {
                setImage(andaDireita1);
                imagem = 1;
            }
            else if (andando && andandoCont == 0)
            {
                setImage(andaEsquerda1);
                imagem = 1;
            }
            if (andando && andandoCont >= 5)
            {
                andandoCont = 0;
                if (andandoDireita)
                {
                    if (imagem == 1)
                    {
                        setImage(andaDireita2);
                        imagem = 2;
                    }
                    else
                    {
                        setImage(andaDireita1);
                        imagem = 1;
                    }
                }
                else
                {
                    if (imagem == 1)
                    {
                        setImage(andaEsquerda2);
                        imagem = 2;
                    }
                    else
                    {
                        setImage(andaEsquerda1);
                        imagem = 1;
                    }
                }
            }
            if (andando == false && andandoDireita == true)
            {
                setImage(andaDireita);
            }else if (andando== false && andandoDireita == false)
            {
                setImage(andaEsquerda);
            }
            
            andandoCont += 1;
        }
        else
        {
            if (andandoDireita == true)
            {
                setImage(pulaDireita);
            }
            else if (andandoDireita == false)
            {
                setImage(pulaEsquerda);
            }
        }
    }
  
    // Realiza o pulo do Mário
    public void pula()
    {
    
        if (podePular() == true && prontoPular == true)
        {
            velocidadeY = - pulo;
            caindo = true;
            pulaSom.play();
            while(getOneIntersectingObject(Bloco.class) != null)
            {
                getWorld().removeObject(getOneIntersectingObject(Bloco.class));
                prontoPular = false;
            }
        }
    }
    // Verifica se tem condição pra pular
    private boolean podePular()
    {
        if (pulo < puloMaximo)
        {
            pulo += 2;
            return true;
        }
        if (pulo == puloMaximo)
        {
            prontoPular = false;
            return false;
        }
        return false;
    }
    

    // Ajusta gravidade Mario de acordo com as colisões
    public void gravidade()
    {
        velocidadeY += gravidade;
        setLocation(getX(), getY() + velocidadeY);
        caindo = true;
        if ((getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null) && velocidadeY <0)
        {
            while(getOneIntersectingObject(Bloco.class) != null)
            {
                getWorld().removeObject(getOneIntersectingObject(Bloco.class));
                velocidadeY = 0;
                musicaMoeda.stop();
                musicaMoeda.play();
                PainelPontos.pontos += 10;
            }
            while (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
            {
                setLocation(getX(), getY()+1);
                velocidadeY = 0;
            }
            setLocation(getX(), getY()+1);
        }
        if (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
        {
            while (getOneIntersectingObject(Bloco.class) != null || getOneIntersectingObject(BlocoChao.class) != null)
            {
                setLocation(getX(), getY()-1);
                caindo = false;
                prontoPular = true;
                velocidadeY = 0;
            }
        }
    
    }


    public void morre()
    {
        vivo = false;
        morreSom.play();
        PainelVidas.vidas--;
        getWorld().addObject(new Morte(), getX(), getY());
        getWorld().removeObject(this);
        return; 
    }
    
    // Verifica se há interseção com o imigo e mata o mesmo
 
    public boolean morreGoomba()
    {
        if (getOneIntersectingObject(SubGoomba.class) != null && caindo == false)
        {
            morre();
            return true;
        }
        else
        {
            return false;
        }
    }

}
