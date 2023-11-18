import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MetalWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MetalWorld extends World
{
    /**
    %------------------------------%
    %-----------Marco Ho-----------%
    %-------------ICS3U------------%
    %-Start of program : 23/4/2012-%
    %-------MetalSlugArena 2-------%
    %-------------(MSA2)-----------%
    %------------------------------%
     */

    /**
    Edit log
    v0.01 - 4/23/2012 - Began program, created Edit Log, created simple WASD movement program
    v0.10 - 4/24/2012 - Created Ball class and actor as a stand-in, copied jumping code (gravity) from MSA1, merged with J. Cohen's code
    v0.11 - 4/25/2012 - At home: space background created, made Ball stop at walls
    v0.12 - 4/26/2012 - Transferred most code into Player from MetalWorld. Created section of log for keys.
    ------------------- Began tinkering with sprite sheets. Created section of log for credit.
    v0.13 - 4/30/2012 - Discovered photoshop's greatest weakness - inability to scale up pictures. Will do at home.
    v0.14 - 5/01/2012 - Worked with sprite sheets. Lots to do because of fluid Metal Slug animations.
    v0.15 - 5/03/2012 - Finished making transparencies in sprite sheets. Now need to enlarge pictures.
    ------------------- At home: enlarged some pictures, processed* lWalk and bAir. Got leg animation to the right working.
    v0.20 - 5/05/2012 - Got both walking left and walking right working.
    v0.30 - 5/23/2012 - Missed some logs. All that was accomplished in the missing logs:
    ------------------- Added a second player and standing (legs).
    ------------------- Note: Still leg animation seems to have not been used in the real game. It has been reduced to one sprite.
    ------------------- At home: Processed leg jumping, which is the last of the legs (unless I have time.)
    ------------------- Note: From this version on, there is a lot of dead code.**
    ------------------- Made player 2 start off facing left. Added leg jumping sprites.
    v0.31 - 5/24/2012 - Added the body, but no picture yet. Began to make code that allows the legs and body to communicate...
    ------------------- through the World.
    v0.31 - 5/26/2012 - Shortened code for importing pictures by K. Luo's suggestion.
    v0.32 - 5/27/2012 - Worked on getting communication between the legs and the bodies.
    ------------------- At home: communication successful! Processed the rest of the sprites, only body was remaining.
    ------------------- Coded in the rest of the body. Everything communicates properly, but the sprites require manual adjustment.
    ------------------- There is a bug where there is no animation when the game starts. Began manual adjustment.
    ------------------- Odd body firing bug in animation. Manual patch added in to fix (bug fix 001), but a second one needs further thinking.
    v0.33 - 5/28/2012 - Worked on fixing animation bugs.
    v0.34 - 5/29/2012 - Ditto.
    ------------------- At home: Attempted to fix an animation bug through locking control in midair.
    ------------------- Attempt unsuccessful. Will re-attempt later with status codes (a three-status boolean of sorts, I'm thinking)
    v0.35 - 5/30/2012 - Locked midair control with some clever usage of the existing jumping() method.
    ------------------- Attempting to disble rapid turning. Fixed location of bullet spawn.
    v0.36 - 5/31/2012 - Fixed another animation bug by locking the body's animation to one direction while it is shooting.
    ------------------- Added odd bug fix 002. New bug has emerged with the first two (three?) frames of shooting animation.
    v0.37 - 6/01/2012 - Made "Known bugs" section. Added bug 001 - 003. Listed 001 - 002 as resolved.
    ------------------- Disabled bug fix 002 in favor of another fix. The error was ultimately the lines of code taking time...
    ------------------- to run instead of running all at once.
    v0.50 - 6/03/2012 - Made platforms. Found and fixed bug 004. 
    ------------------- Made the players pass through the platforms unless falling and colliding with them.
    ------------------- Tried to use getOneObjectAtOffset for collision with the platform, but ended up using...
    ------------------- getOneIntersectingObject with a little additional code to achieve the same effect.
    ------------------- Fancified the platforms with a flying animation! 
    ------------------- Matched up firing speed with animation.
    v0.51 - 6/04/2012 - Made bullets collide with both the body and the legs. Added bug 005 - 006.
    ------------------- Strangely, bug 003 may have dissapeared. Further testing warranted.
    ------------------- At home: Cut out all of the dead code.
    v0.52 - 6/05/2012 - Started on life counter. Hit detection only works for the legs for now.
    ------------------- At home: finished all aspects of hit detection for core features.
    ------------------- Note: some dead code is being created again because of half-complete experimental features.
    ------------------- Discovered that it is possible to jump midair if falling off the platform. Listed as bug 007 (for now).
    ------------------- Crossed off bug 007.
    ------------------- Began working on life counters.
    v0.53 - 6/06/2012 - Gave immunity to players when hit as a grace period.
    ------------------- Added life counters to world. Life counters are not bound to yet.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------
    v1.00 - 6/07/2012 - Bound life counters to players. Made Greenfoot stop if either counter hits 0. Core features finished.
    ------------------- Found and recorded bug 008. Listed 003 as resolved. Added Final Attack (music).
    ------------------- If a player shoots against the wall while sticking to it, the bullet will harm the player (self-hit).
    v1.10 - 6/08/2012 - Made music tracks cycle. Added three songs from the racing game Proun and the song Chaoz Fantasy.
    ------------------- Noted bug 009.
    v1.11 - 6/10/2012 - Worked on making the title screen. Combined instructions with the title screen
    ------------------- Completely finished the title screen. Logged bug 010.
    v1.12 - 6/12/2012 - Moved some bugs into the resolved section.
    ------------------- Added different levels, level changing, different platform sizes and better support for pictures in the platforms.
    ------------------- Bound the 1 key to player 1 fire along with f for players with hand-to-key tendencies.
    ------------------- Crossed off bug 006.
    v1.50 - 6/13/2012 - Finished setting up and balancing all three levels. Cut out all dead code** again.

     * Processed: Enlarged and cut into individual sprites.
     ** Dead code: Unused code, left as comments in case they are needed again.

      
      
     
    Keys used
    W - Player 1 jump
    A - Player 1 left 
    D - Player 1 right
    F or 1 - Player 1 fire

    ↑ - Player 2 jump
    ← - Player 2 left
    → - Player 2 right
    Enter - Player 2 fire

    M - Cycle music tracks

    
    
    
    -------Known Bugs-------
    Resolved:
    001) At the second last firing frame, the body flies off. Resolving code in Body.
    002) In the first two firing frames, the body flies off. Resolving code in Body.
    003) Strange animation bug at the end of firing whilst attempting rapid turning. Reason for resolve unknown.
    004) Heroes could go into the ground. Resolving code in Hero.
    005) Hitboxes are extremely large because of how the sprites are. Resolved by changes in mechanics and what the user can see.
    006) The program inexpicably crashes and a restart of Greenfoot is required. Suspected to be either lag or a problem within Greenfoot/Java.
    007) Walking off a platform enabled a player to jump in midair in any direction they chose. Resolved while fixing a core mechanic.
    008) Players do not begin animation until they move. Resolved by dropping both players when game starts.

    Remaining:
    009) Music sometimes does not play until cycled, and sometimes cycling multiple times. Likely error with slow processing.
    010) The error "Java heap space" appears very often. Although I'm fairly certain this is a hardware limitation, I'd like to fix it. Related to 006.

    ---------Thanks---------
    'I am Kevin lol' for sprites
    'ParagonX9' for Chaoz Fantasy (music)
    Arno Landsbergen for music
    SNK Playmore for music, creating the original sprites,  and wonderful memories of a wonderful game
    J. Cohen for a piece of code (code copied only to save time - my own code was in another programming language)
    'MrJinx' for the word ARENA seen in title
    -----Special thanks for various and/or forgotten reasons-----
    A. Kwok
    D. Lee
    C. Woo
    G. Zheng
    K. "Bob" Luo
    and you, because and you keeps appearing on flash games in the special thanks, so he/she must be a pretty cool guy.
    Thanks, and you!

     */

    //The Hero is the legs, while the Body is the body that follows it.
    private Hero player1;
    private Hero player2;

    private Body body1;
    private Body body2;

    //6 Platforms are in the cache, but never used at once. Each pair of platforms has its own size (L, M, S)
    private Platform plat1;
    private Platform plat2;
    private Platform plat3;
    private Platform plat4;
    private Platform plat5;
    private Platform plat6;

    //Title and end game objects
    private Title title;
    private GameEnd winStatus;
    private boolean titleScreen = true;
    private GreenfootSound gameOver = new GreenfootSound ("Finish.wav");

    //Setting level variables
    private Level levelCounter;
    private int level = 1;

    //Music control variables
    private GreenfootSound music[] = new GreenfootSound[5]; 
    private int trackPlaying = 0;
    private int mPressed = 5;

    private int playerSpeed1 = 3;      //Running speed for player 1
    private int direction1 = 1;        //Initial direction of player 1
    private int playerSpeed2 = 3;      //Running speed for player 2
    private int direction2 = -1;       //Initial direction of player 2
    private int changeX1 = 0;          
    private int changeX2 = 0;

    private int playerImmune1 = 0;
    private int playerImmune2 = 0;
    private int immunityTime = 12; //Time a player gets to be immune after being hit. (Mostly to prevent holes in the program)

    //The life each player has. These can be changed, but 5 is recommended.
    private int playerLife1 = 5;
    private int playerLife2 = 5;

    //Life counters
    private Life[] life1 = new Life[playerLife1];
    private Life[] life2 = new Life[playerLife2];

    //Air movement constriction variables
    private boolean movedWhenJump1 = false;
    private boolean movedWhenJump2 = false;

    public MetalWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        //Filling up the Jukebox :)
        music[0] = new GreenfootSound("FinalAttack.mp3"); 
        music[1] = new GreenfootSound("ChaozFantasy.mp3"); 
        music[2] = new GreenfootSound("Proun1.mp3"); 
        music[3] = new GreenfootSound("Proun2.mp3"); 
        music[4] = new GreenfootSound("Proun3.mp3"); 

        //A piece of code recommended by J. Cohen to stop a sound file bug in Greenfoot 2.1.2.
        for (int i = 0; i < music.length; i++){
            music[i].play();
            music[i].stop();
        }

        //These tracks are very loud, and are adjusted manually to be quieter.
        music[1].setVolume (35);
        music[2].setVolume (40);
        music[3].setVolume (40);
        music[4].setVolume (40);
        gameOver.setVolume(50);

        //Setting up the players
        player1 = new Hero();
        body1 = new Body();

        player2 = new Hero();
        body2 = new Body();

        //Two large platforms, two medium, two small
        plat1 = new Platform("L");
        plat2 = new Platform("L");
        plat3 = new Platform("M");
        plat4 = new Platform("M");
        plat5 = new Platform("S");
        plat6 = new Platform("S");

        //Scattered pictures that guide the users along.
        title = new Title();
        levelCounter = new Level();
        winStatus = new GameEnd();

        //Start with adding only the title and level manipulator.
        addObject (title, 400, 300);
        addObject (levelCounter, 666, 125);

        //Fixing the order which actors are layered.
        setPaintOrder (Body.class, Hero.class, PlayerShot.class, Platform.class, Level.class, Title.class); 
    }

    public void act (){ 
        checkMusic();         //The key M is used in here. All other keys are in checkKeys(). Cycles through tracks and ensures music is playing.
        if (titleScreen == true){ //This variable is true from the start, so the title screen goes until the user stops it.
            titleScreenCheck();
        }
        else if (titleScreen == false){ //After the title screen has passed
            checkKeys();          //Control input
            legBodyCommunicate(); //Have the legs send information to the body.
            checkHits();          //Check for collisions. The body and legs both detect collision, but to be in unison, the info goes to the World.
        }
        //System.out.println(Greenfoot.getMouseInfo());
    }

    private void titleScreenCheck(){
        if (Greenfoot.mousePressed(levelCounter)){ //If the user clicks on the level counter, cycle.
            level ++;
            if (level == 4){
                level = 1;
            }
            levelCounter.setLevel();
        }
        else if (Greenfoot.mousePressed(null)){ // If the user clicks on anything else, start the game.
            titleScreen = false;
            title.remove();
            levelCounter.remove();
            beginGame();
        }
    }

    private void beginGame(){
        //Adds players
        addObject (player1, 150, 505);
        addObject (body1, 150, 515);
        addObject (player2, 650, 505);
        addObject (body2, 650, 515);

        //Adds life counters
        for (int i = 0; i < life1.length; i++){
            life1[i] = new Life(1);
            addObject (life1[i], 20 + (50 * (i+1)), 55);
        }
        for (int i = 0; i < life2.length; i++){
            life2[i] = new Life(2);
            addObject (life2[i], 780 - (50 * (i+1)), 55);
        }

        //Depending on what level has been selected, the platforms are added in differently.
        if (level == 1){
            addObject (plat1, 400, 435);
        }
        else  if (level == 2){
            addObject (plat1, 400, 308);
            addObject (plat3, 175, 435);
            addObject (plat4, 625, 435);
        }
        else  if (level == 3){
            addObject (plat3, 400, 435);
            addObject (plat4, 400, 308);
            addObject (plat5, 100, 435);
            addObject (plat6, 700, 435);
        }
    }

    private void checkKeys (){
        if (player1.jumping() == false){ //Constricts movement if the player is in the air.
            changeX1 = 0;
            if (Greenfoot.isKeyDown("a")){ //Move left
                changeX1 = changeX1 - playerSpeed1;
                direction1 = -1;}
            if (Greenfoot.isKeyDown("d")){ //Move right
                changeX1 = changeX1 + playerSpeed1;
                direction1 = 1;
            }
        }
        if (Greenfoot.isKeyDown("w") && player1.jumping() == false){ //Jump
            player1.jump();
        }
        if (Greenfoot.isKeyDown("s") && player1.onPlatform()){ //Fall through platform 
            player1.setLocation(player1.getX(), player1.getY() + 5);
        }

        //Same for player 2.
        if (player2.jumping() == false){
            changeX2 = 0;
            if (Greenfoot.isKeyDown("left")){
                changeX2 = changeX2 - playerSpeed2;
                direction2 = -1;}
            if (Greenfoot.isKeyDown("right")){
                changeX2 = changeX2 + playerSpeed2;
                direction2 = 1;}
        }
        if (Greenfoot.isKeyDown("up") && player2.jumping() == false){
            player2.jump();
        }
        if (Greenfoot.isKeyDown("down") && player2.onPlatform()){
            player2.setLocation(player2.getX(), player2.getY() + 5);
        }

        //Sending movement to the hero (legs) to process sprites with
        player1.moveMe (changeX1, direction1);
        player2.moveMe (changeX2, direction2);

        //Firing controls
        if (Greenfoot.isKeyDown("f") || Greenfoot.isKeyDown ("1")){
            player1.playerFire();
        }   
        if (Greenfoot.isKeyDown("enter")){
            player2.playerFire();
        }      
    } 

    //Special methods built into Greenfoot, used here for sound control
    public void started(){
        music[trackPlaying].play();
        gameOver.stop();
    }

    public void stopped(){
        music[trackPlaying].pause();
        gameOver.play();
    }

    public void checkMusic(){
        if (musicKeyCheck()){ //If the M key is pressed, go to the next track.
            music[trackPlaying].stop();
            trackPlaying ++;
            if (trackPlaying >= music.length){
                trackPlaying = 0;
            }
            music[trackPlaying].playLoop();
            mPressed = 50;
        }
    }

    public boolean musicKeyCheck(){
        if (mPressed > 0){
            mPressed--;
        }
        if(Greenfoot.isKeyDown("m")  && mPressed == 0){
            return true;
        }
        return false;
    }

    public void legBodyCommunicate(){ //Legs and bodies need to communicate for seperate animation sprites.
        body1.statusToBody(player1.statusFromHero());
        body2.statusToBody(player2.statusFromHero());

        body1.locationToBody(player1.locationFromHero());
        body2.locationToBody(player2.locationFromHero());
    }

    public void checkHits(){ 
        //This method is entirely in charge of taking away lives when a player is hit.
        //It is lengthy to patch holes in the code (bug fixes).
        
        //Players recieve immunity for a time when hit so they are not hit twice by the same bullet.
        if (playerImmune1 >= 1){
            playerImmune1 --;
        }
        if (playerImmune2 >= 1){
            playerImmune2 --;
        }

        //Removing a life counter and keeping track of where it is.
        if (player1.legsCheckDamage() || body1.bodyCheckDamage()){
            if (playerImmune1 == 0){
                playerImmune1 = immunityTime;
                life1[playerLife1 - 1].removeMe();
                playerLife1 --;
            }
        }
        if (player2.legsCheckDamage() || body2.bodyCheckDamage()){
            if (playerImmune2 == 0){
                playerImmune2 = immunityTime;
                life2[playerLife2 - 1].removeMe();
                playerLife2 --;
            }
        } 

        //If both die at the same time, it's a draw. Otherwise, change the end picture to "player ? has won" and display.
        //Stopping Greenfoot also plays the game over track mentioned before.
        if (playerLife1 == 0 && playerLife2 == 0){
            addObject (winStatus, 400, 100);
            Greenfoot.stop();
        }
        else if (playerLife1 == 0){
            winStatus.whoWon(2);
            addObject (winStatus, 400, 100);
            Greenfoot.stop();
        }
        else if (playerLife2 == 0){
            winStatus.whoWon(1);
            addObject (winStatus, 400, 100);
            Greenfoot.stop();
        }

    }

    private int numGenerator(int min, int max){ //Generates a random int with min and max that can be set
        int num = min - 1;
        while (!(num >= min && num <= max)){
            num = (int)(Math.random()*10);
        }
        return num; 
    }
}

