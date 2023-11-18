import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Player
{

    //Movement variables
    private double vSpeed = 0;
    private double acceleration = 0.5;
    private int jumpStrength = 13;
    private boolean jumping = true;

    //Movement constriction variables
    private int leftWall = 63;
    private int rightWall = 738;
    private int ground = 542;

    //Shooting variables
    private int shotDelay = 38;
    private int recentShot = 0;

    //Picture drawing
    private int animationDelay = 2; //Manipulate this number (in the code, not here) to delay the speed all sprites cycle at
    private int direction;
    private int previousActDirection;

    //Body control
    private boolean shooting = false;
    //private boolean moving = false;

    //Legs, walking
    private int legWalkCount = 0;
    private int legWalkStagger = 1; //Manipulate this number (in the code, not here) to delay the speed walking sprites cycle at
    private GreenfootImage legWalkRight [] = new GreenfootImage[18];
    private GreenfootImage legWalkLeft [] = new GreenfootImage[18];

    //Legs, jumping
    private int legJumpCount = 0;
    private int legJumpStagger = 3; //Manipulate this number (in the code, not here) to delay the speed jumping sprites cycle at
    private GreenfootImage legJumpRight [] = new GreenfootImage[6];
    private GreenfootImage legJumpLeft [] = new GreenfootImage[6];

    //Legs, standing
    private int lastX;
    private GreenfootImage legStandRight;
    private GreenfootImage legStandLeft;

    private boolean statusToSend [] = new boolean [2];
    private int locationToSend [] = new int [5];

    public Hero (){ //Importing all the sprites. 
        for (int i = 1; i <= legWalkRight.length ; i++)
        {
            legWalkRight[i - 1] = new GreenfootImage("lWalk" + i +".png");
        }

        for (int i = 1; i <= legWalkLeft.length ; i++)
        {
            legWalkLeft[i - 1] = new GreenfootImage("lWalk" + i +".png");
        }
        for (int i = 0; i < 18; i++){
            legWalkLeft[i].mirrorHorizontally();
        }

        for (int i = 1; i <= legJumpRight.length ; i++)
        {
            legJumpRight[i - 1] = new GreenfootImage("lJump" + i +".png");
        }

        for (int i = 1; i <= legJumpLeft.length ; i++)
        {
            legJumpLeft[i - 1] = new GreenfootImage("lJump" + i +".png");
        }
        for (int i = 0; i < 6; i++){
            legJumpLeft[i].mirrorHorizontally();
        }

        legStandRight = new GreenfootImage("lStanding1.png");
        legStandLeft = new GreenfootImage("lStanding1.png");
        legStandLeft.mirrorHorizontally();
    }

    public void act() 
    {
        checkWalls();
        legAnimation();

        if (recentShot != 0){
            recentShot -= 1;
        }
        lastX = getX();
    }

    private void checkWalls()
    {
        if (atLeftEdge()){
            setLocation(leftWall, getY());}
        if (atRightEdge()){
            setLocation(rightWall, getY());}

        //J. Cohen's code starts here (contains changes)
        if(getY() >= ground || onPlatform()) {
            setLocation (getX(), getY());
            vSpeed = 0;
            jumping = false;

            //Bug fix 004
            if (getY() >= ground){setLocation (getX(), ground);}

        }
        else {
            fall();
        }
    }
    
    
    public boolean onPlatform(){
        Platform p = (Platform)getOneIntersectingObject(Platform.class);     
        if (p != null && vSpeed >= 0 && getY() + 20 <= p.getY() - 5){
            
            return true;
        }
        return false;
    }

    public void jump()
    {
        jumping = true;
        vSpeed = -jumpStrength;
        fall();
        legJumpCount = 0;
    }

    public boolean jumping()
    {
        if (getY() >= ground || onPlatform()){
            return false;}
        return true;
    }   

    public void fall()
    {
        setLocation (getX(), getY() + (int)vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    //J. Cohen's code ends here (contains changes)

    public boolean atLeftEdge ()
    {
        if (getX()  <= leftWall -1 )
        { return true; }
        return false;
    }

    public boolean atRightEdge ()
    {
        if (getX() >= rightWall - 1)
        { return true; }
        return false;
    }

    private void legAnimation()
    {
        //Although the ways used for animating sets of sprites are generally the same, some are re-orded or have special code inside.
        //This is for special effects or bug fixing.
        //There are standard restriction variables for every set of sprites, also to prevent bugs.
        
        if (jumping){ //If the player is jumping, go through the jumping animation.
            if (legJumpStagger <= animationDelay){
                legJumpStagger ++;
            }
            else{
                if (!(previousActDirection == direction)){
                    previousActDirection = direction;
                    legJumpCount = 3;
                }
                else {
                    legJumpCount ++;
                }
                if (direction == 1){
                    setImage(legJumpRight[legJumpCount]);
                }
                else if (direction == -1){
                    setImage(legJumpLeft[legJumpCount]);
                }
                if (legJumpCount >= 5){
                    legJumpCount = 4;
                }
                legJumpStagger = 1;
            }
        }
        else if (getX() ==  lastX){ //If the player has not moved since the last act, it is standing.
            if (direction == 1){
                setImage (legStandRight);
            }
            else if (direction == -1){
                setImage (legStandLeft);
            }

        }
        //The rest is for walking animation.
        else if (legWalkStagger <= animationDelay){
            legWalkStagger ++;
        }
        else{
            if (!(previousActDirection == direction)){
                previousActDirection = direction;
                legWalkCount = 0;
            }
            else {
                legWalkCount ++;
            }
            if (legWalkCount >= 18 || legWalkCount <= -18){
                legWalkCount = 0;
            }
            if (direction == 1){
                setImage(legWalkRight[legWalkCount]);
            }
            else if (direction == -1){
                setImage(legWalkLeft[legWalkCount]);
            }
            legWalkStagger = 1;
        }
    }

    public boolean[] statusFromHero(){ //Puts status information from the legs into an array and sends the entire array to the World.
        if (jumping){
            statusToSend[0] = true;
        }
        else{
            statusToSend[0] = false;
        }
        if (recentShot == shotDelay){
            statusToSend[1] = true;
        }
        else{
            statusToSend[1] = false;
        }
        return (statusToSend);
    }

    public int [] locationFromHero(){ //Puts location information from the legs into an array and sends the entire array to the World.
        locationToSend [0] = getX();
        locationToSend [1] = getY();
        locationToSend [2] = direction;
        locationToSend [3] = previousActDirection;
        locationToSend [4] = lastX;
        return locationToSend;
    }

    public void moveMe (int xMove, int directionInput) //Called by World to move the legs.
    {
        direction = directionInput;
        setLocation (getX()+ xMove, getY());
    }

    public void playerFire() //Firing a bullet.
    {
        if  (recentShot == 0){
            Atirar bullet = new Atirar(direction);
            getWorld().addObject(bullet, getX() + (74*direction), getY() - 35);
            recentShot = shotDelay;
        }
    }    

    public boolean legsCheckDamage(){ //Has a bullet collided with the player?
        Atirar p = (Artirar)getOneIntersectingObject (Atirar.class);
        if (p != null) {
            p.remove();
            return true;
        }
        return false;
    }
}