import greenfoot.*;  


/**
 * Inicializa todos os atributos necessários para o start do jogo e cria o 
 * * universo tendo como base a imagem "MundoMario.png substituindo as cores 
 * * * pelos objetos devidos.
 */
public class Mundo extends World
{

    public static GreenfootSound tema;
    private GreenfootImage planoDeFundo;
    
    public Mundo(GreenfootImage imgBlocos,int vidas)
    {    
        /**
         * Construtor da classe Jogo
         */
        super(800, 600, 1, false);
        tema = new GreenfootSound("Som_Tema.mp3");
        planoDeFundo = new GreenfootImage("PlanoDeFundo.png");
        criaMundo(imgBlocos, vidas);
        setBackground(planoDeFundo);
        BlocoPrincipal.x = 0; // Referencia global do pixel da tela num geral. Consegue fazer a colisão com ele. Se o Mario está na gravidade correta, em vez de fazer em cada bloco.
        BlocoPrincipal.y = 0; //
        PainelPontos.pontos = 0; 
        Jogador.vivo = true;
    }
    public void act()
    /**
         * Inicia o jogo, muda o estado do jogador e encerra o menu.
         */
    {
        if (Jogador.vivo == false)
        {
            tema.stop();
        }
        else 
        {
            tema.playLoop();
        }
    }
    public void criaMundo(GreenfootImage blocos, int vidas)
    {
        // Popula o mundo de acordo com a cor específica na foto
        addObject(new PlanoDeFundo(4700, getHeight()/2), 4700, getHeight()/2);
        for (int j = 0; j < blocos.getHeight(); j++)
        {
            for (int i = 0; i < blocos.getWidth(); i++)
            {
                if (blocos.getColorAt(i, j).equals(Color.RED))
                {
                    addObject(new Bloco(i*50+25, j*50+25), i*50+25, j*50+25);
                }
                else if (blocos.getColorAt(i, j).equals(Color.GREEN))
                {
                    addObject(new Moeda(i*50+25, j*50+25), i*50+25, j*50+25);
                }
                else if (blocos.getColorAt(i, j).equals(Color.BLUE))
                {
                    addObject(new BlocoChao(i*50+25, j*50+25), i*50+25, j*50+25);
                }
                else if (blocos.getColorAt(i, j).equals(Color.YELLOW))
                {
                    addObject(new Jogador(), i*50+25, j*50+25);
                }
                else if (blocos.getColorAt(i, j).equals(Color.MAGENTA))
                {
                    addObject(new SubGoomba(i*50+25, j*50+25), i*50+25, j*50+25);
                } else if (blocos.getColorAt(i,j).equals(Color.BLACK)) 
                {
                    addObject(new Bandeira(i*50+25, j*50+25), i*50+25, j*50+25);
                    
                }
            }
        }
        // Gera painel de pontos e vidas
        addObject(new PainelPontos(), 82, 20); 
        addObject(new PainelVidas(vidas), 800-82, 20);
    }
    
    public void inicia()
    {
        tema.setVolume(75);
        tema.playLoop();
    }
    public void stopped()
    {
        tema.stop();
    }
}
