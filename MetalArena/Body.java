import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)






//All the body does is go through an animation with info sent in from the Hero. Core code is in the Hero (legs).
//However, the animation is slightly different from the legs because there are more animation sequences possible.






public class Body extends Player
{
    //Status variables    
    private boolean jumping;
    private boolean shooting;
    
    private int animationDelay = 2; //Manipulate this number to delay the speed all sprites cycle at

    //General animation variables
    private int direction;
    private int previousActDirection;
    private int lastX;

    //Body, jumping
    private int bodyJumpCount = 0;   //Used to determine the specific sprite being used. Do not edit!
    private int bodyJumpStagger = 1; //Manipulate this number (in the code, not here) to delay the speed jumping sprites cycle at
    private GreenfootImage bodyJumpRight [] = new GreenfootImage[6];
    private GreenfootImage bodyJumpLeft [] = new GreenfootImage[6];

    //Body, walking
    private int hWalkAdjust = 5, vWalkAdjust = 10;
    private int bodyWalkCount = 0;   //Used to determine the specific sprite being used. Do not edit!
    private int bodyWalkStagger = 1; //Manipulate this number (in the code, not here) to delay the speed walking sprites cycle at
    private GreenfootImage bodyWalkRight [] = new GreenfootImage [12];
    private GreenfootImage bodyWalkLeft [] = new GreenfootImage [12];

    //Body, standing
    private int hStandAdjust = 5, vStandAdjust = 10;
    private int bodyStandCount = 0;   //Used to determine the specific sprite being used. Do not edit!
    private int bodyStandStagger = -5; //Manipulate this number (in the code, not here) to delay the speed standing sprites cycle at
    private GreenfootImage bodyStandRight [] = new GreenfootImage [4];
    private GreenfootImage bodyStandLeft [] = new GreenfootImage [4];

    //Body, shooting (has more variables because of bug fixes)
    private int hShootAdjust = 28, vShootAdjust = 8;
    private int bodyShootCount = 0;   //Used to determine the specific sprite being used. Do not edit!
    private int bodyShootStagger = 1; //Manipulate this number (in the code, not here) to delay the speed shooting sprites cycle at
    private GreenfootImage bodyShootRight [] = new GreenfootImage [10];
    private GreenfootImage bodyShootLeft [] = new GreenfootImage [10];
    private boolean shootingLock = false;
    private int shootingDirectionLock = 0; //Three-way boolean to lock the shooting animation

    public Body (){ 

        //Importing all the sprites for body animation
        for (int i = 1; i <= bodyJumpRight.length ; i++)
        {
            bodyJumpRight[i - 1] = new GreenfootImage("bJump" + i +".png");
        }

        for (int i = 1; i <= bodyJumpLeft.length ; i++)
        {
            bodyJumpLeft[i - 1] = new GreenfootImage("bJump" + i +".png");
        }
        for (int i = 0; i < bodyJumpLeft.length; i++){
            bodyJumpLeft[i].mirrorHorizontally();
        }

        for (int i = 1; i <= bodyWalkRight.length ; i++)
        {
            bodyWalkRight[i - 1] = new GreenfootImage("bWalking" + i +".png");
        }

        for (int i = 1; i <= bodyWalkLeft.length ; i++)
        {
            bodyWalkLeft[i - 1] = new GreenfootImage("bWalking" + i +".png");
        }
        for (int i = 0; i < bodyWalkLeft.length; i++){
            bodyWalkLeft[i].mirrorHorizontally();
        }

        for (int i = 1; i <= bodyStandRight.length ; i++)
        {
            bodyStandRight[i - 1] = new GreenfootImage("bStanding" + i +".png");
        }

        for (int i = 1; i <= bodyStandLeft.length ; i++)
        {
            bodyStandLeft[i - 1] = new GreenfootImage("bStanding" + i +".png");
        }
        for (int i = 0; i < bodyStandLeft.length; i++){
            bodyStandLeft[i].mirrorHorizontally();
        }

        for (int i = 1; i <= bodyShootRight.length ; i++)
        {
            bodyShootRight[i - 1] = new GreenfootImage("bShooting" + i +".png");
        }

        for (int i = 1; i <= bodyShootLeft.length ; i++)
        {
            bodyShootLeft[i - 1] = new GreenfootImage("bShooting" + i +".png");
        }
        for (int i = 0; i < bodyShootLeft.length; i++){
            bodyShootLeft[i].mirrorHorizontally();
        }
    }

    public void act() 
    {
        bodyAnimation(); //All the body does is go through an animation. Core code is in the legs.
    }    

    public void statusToBody (boolean inputArray[]){ //Receives a burst of information stored in an array.
        jumping = inputArray[0];
        shooting = inputArray[1];
        if (shooting){
            shootingLock = true;
            if (direction == 1){
                setImage(bodyShootRight[bodyShootCount]);
            }
            else if (direction == -1){
                setImage(bodyShootLeft[bodyShootCount]);
            }
        }
    }

    public void locationToBody (int inputLocation[]){ //Receives a burst of information stored in an array.
        setLocation (inputLocation[0],inputLocation[1] - 40);
        direction = inputLocation[2];
        previousActDirection = inputLocation [3];
        lastX = inputLocation [4];
    }

    public void bodyAnimation(){
        if (shootingLock){
            if (direction == 1 && shootingDirectionLock == 0){
                shootingDirectionLock = 1;
            }
            else if (direction == -1 && shootingDirectionLock == 0){
                shootingDirectionLock = -1;
            }
            specialDirectionAdjust (hShootAdjust, vShootAdjust, shootingDirectionLock);
            if (bodyShootStagger <= animationDelay){
                bodyShootStagger ++;
            }
            else{
                // Odd bug fix with bShooting1 - adjusted manually Bug fix code 002. Currently causes a problem if enabled.
                //  if (bodyShootCount == 0){
                //    specialDirectionAdjust (129, 8, shootingDirectionLock); //
                //}
                bodyShootCount ++;

                // Odd bug fix with bShooting10 - adjusted manually. Bug fix code 001
                if (bodyShootCount == 9){
                    specialDirectionAdjust (-19, -1, shootingDirectionLock);
                }

                if (shootingDirectionLock == 1){
                    setImage(bodyShootRight[bodyShootCount]);
                }
                else if (shootingDirectionLock == -1){
                    setImage(bodyShootLeft[bodyShootCount]);
                }

                if (bodyShootCount >= 9){
                    bodyShootCount = 0;
                    shootingLock = false;
                    shootingDirectionLock = 0;
                    specialDirectionAdjust (hShootAdjust *-10, vShootAdjust, shootingDirectionLock);

                }
                bodyShootStagger = 1;
            }
        }
        else if (jumping){
            if (bodyJumpStagger <= animationDelay){
                bodyJumpStagger ++;
            }
            else{
                if (!(previousActDirection == direction)){
                    previousActDirection = direction;
                    bodyJumpCount = 0;
                }
                else {
                    bodyJumpCount ++;
                }

                if (direction == 1){
                    setImage(bodyJumpRight[bodyJumpCount]);
                }
                else if (direction == -1){
                    setImage(bodyJumpLeft[bodyJumpCount]);
                }
                if (bodyJumpCount >= 5){
                    bodyJumpCount = 4;
                }
                bodyJumpStagger = 1;
            }
        }
        else if (getX() ==  lastX){
            if (bodyStandStagger <= animationDelay){
                bodyStandStagger++;
            }
            else{
                if (!(previousActDirection == direction)){
                    previousActDirection = direction;
                    bodyStandCount = 0;
                }
                else{
                    bodyStandCount ++;
                }
                if (bodyStandCount >= 4 || bodyStandCount <= -4){
                    bodyStandCount = 0;
                }
                if (direction ==1){
                    setImage (bodyStandRight[bodyStandCount]);
                }
                else if (direction == -1){
                    setImage (bodyStandLeft[bodyStandCount]);
                }
                bodyStandStagger = -5;
            }
            directionAdjust (hStandAdjust, vStandAdjust);
        }

        else{
            directionAdjust (hWalkAdjust,vWalkAdjust);
            if (bodyWalkStagger <= animationDelay){
                bodyWalkStagger ++;
            }
            else{
                if (!(previousActDirection == direction)){
                    previousActDirection = direction;
                    bodyWalkCount = 0;
                }
                else {
                    bodyWalkCount ++;
                }
                if (bodyWalkCount >= 12 || bodyWalkCount <= -12){
                    bodyWalkCount = 0;
                }

                if (direction == 1){
                    setImage(bodyWalkRight[bodyWalkCount]);
                }
                else if (direction == -1){
                    setImage(bodyWalkLeft[bodyWalkCount]);
                }

                bodyWalkStagger = 1;
            }
        }
    }

    public void directionAdjust(int xAdjust, int yAdjust){
        if (direction == 1)
        {
            setLocation (getX() + xAdjust, getY() + yAdjust);
        }
        else if (direction == -1)
        {
            setLocation (getX() - xAdjust, getY() + yAdjust);
        }
    }

    public void specialDirectionAdjust(int xAdjust, int yAdjust, int shootingDirection){
        if (shootingDirection == 1)
        {
            setLocation (getX() + xAdjust, getY() + yAdjust);
        }
        else if (shootingDirection == -1)
        {
            setLocation (getX() - xAdjust, getY() + yAdjust);
        }
    }

    public boolean bodyCheckDamage(){
        PlayerShot p = (PlayerShot)getOneIntersectingObject (PlayerShot.class);
        if (p != null) {
            p.remove();
            return true;
        }
        return false;
    }
}
