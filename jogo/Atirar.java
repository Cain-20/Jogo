import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Atirar extends Player
{
    private int speed = 12; //Manipulate this number to change the rate at which bullets move
    private boolean bulletHit = false;

    private GreenfootImage emptyBullet = new GreenfootImage("BulletEmpty.png");

    private GreenfootSound fire1 = new GreenfootSound("PistolFire1.wav"); 
    private GreenfootSound fire2 = new GreenfootSound("PistolFire2.wav"); 

    public Atirar(int direction){
        speed *= direction; //Changing the direction the bullet flies in

        fire1.setVolume(90);
        if (numGenerator(0,5) != 5){
            fire1.play();
        }
        else{
            fire2.play();
        }
    }

    public void act() 
    {
        move(); //Bullet always moves

        if (bulletHit == false){
            checkCollision();
        }

        if (atWorldEdge()){ //Checking for collision with walls
            remove();
        }
    }

    public void move()
    {
        setLocation (getX() + speed, getY());
    }

    public boolean atWorldEdge() //Checking for collision with walls
    {       
        if(getX() <= 45 || getX() >= getWorld().getWidth() - 45){
            return true;
        }
        return false;
    }

    public void checkCollision()
    {
        if (getOneIntersectingObject (Hero.class) != null || getOneIntersectingObject (Body.class) != null){
            bulletHit = true;
            setImage (emptyBullet);
        }
    }

    public void remove() //Removes an individual bullet
    {
        getWorld().removeObject(this);
    }

    public boolean bulletUsed(){
        if (bulletHit){
            return true;
        }
        return false;
    }
    
    private int numGenerator(int min, int max){ //Generates a random number with easy to influence min and max
        int num = min - 1;
        while (!(num >= min && num <= max)){
            num = (int)(Math.random()*10);
        }
        return num; 
    }

}