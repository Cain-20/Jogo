import greenfoot.*;  
import greenfoot.GreenfootImage;

/**
 Inicializa foto de fundo do menu principal com suas dimensões e chama a classe 
 * "IniciaJogo" para mostrar o texto na tela,.
 */
public class Menu extends World
{

    public Menu()
    {    
        super(800, 600, 1, false); 
        GreenfootImage fundo = new GreenfootImage("MenuInicio.png");
        fundo.scale(800,600);
        setBackground(fundo);
        addObject(new IniciaJogo(), getWidth()/2, getHeight()/2+125);
    
    }
}
