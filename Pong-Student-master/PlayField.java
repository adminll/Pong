/**
 * TODO (132): Fill out an appropriate assignment comment block
 * Name: Kaden
 * Last edited: 11/30/2018
 */


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class PlayField extends World
{
    //startGame boolean
    public boolean startGame = false;
    
    //Ball instance variable for ball
    private Ball theBall;
    
    //Score instance variable for score
    private Score player1Score;
    
    //Score instance variable for score
    private Score player2Score;
    
    /**
     * Sets the size of the world
     */
    public PlayField()
    {
        super(800,600,1);
        initializePlayingField();
    }
    
    /**
     * Sets the background of the world
     * @return = none
     * @params = none
     */
    
    public void initializePlayingField()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect( 0, 0, getWidth(), getHeight() );
        getBackground().setColor(Color.GRAY);
        getBackground().fillRect( 400, 0, 4, getHeight() );
        addPlayersAndObjects();
        showText(" press the space bar to begin play ", 200, 550);
    }
    
    /**
     * adds the ball, the score, and paddles to the world
     * @return = none
     * @params = none
     */
    
    
    
    public void addPlayersAndObjects()
    {
        
        theBall = new Ball();
        player1Score = new Score(true);
        player2Score = new Score(false);
        addObject(theBall, getWidth()/2,getHeight()/2);
        addObject( player1Score ,200,50);
        addObject( player2Score ,600 ,50);
        
        addObject(new Paddle(false),getWidth() - 10, getHeight()/2);
        addObject(new Paddle(true),10, getHeight()/2);
    }
    
    
    /**
     * Act method for playfield
     * @params = none
     * @return = none
     */
    public void act()
    {
        //checks too see if the game has started, if not, press space bar to start
        if (startGame == false)
        {
            checkKeyPress();
        }
        
        //checks to see who has won the round
        checkWin();
    }
    
    
    
    /**
     * Checks to see if the space bar has been pressed to start the round
     * @params = none
     * @return = none
     */
    private void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("space") == true)
        {
            //changes start game boolean to true
            startGame = true;
            
            //makes the "press spacebar" text disappear
            showText(" ",200,550);
            
            //sets the balls velocity to 5
            theBall.setVelocity(5);
        }
    }
    
    /**
     * resets the ball
     * @perams = none
     * @return = none
     */
    public void reset()
    {
        //helps spawn in the ball/reset the ball
        theBall = new Ball();
        
        //resets/spawns the ball in the middle of the screen
        addObject(theBall,getWidth()/2,getHeight()/2);
        
        //sets the balls velocity to 0
        theBall.setVelocity(0);
        
        //shows text on the bottom left corner
        showText(" Press the space bar to begin ", 200,550);
        
        //sets startGame to false
        startGame = false;
    }
    /**
     * CHecks whom has one the game
     * @params = none
     * @return = none
     */
    
    private void checkWin()
    {
        //sets the player1Win and player2Win to put text on the screen for when one player wins
        GreenfootImage player1Win = new GreenfootImage(" Player 1 Wins! ", 45,Color.CYAN,Color.BLACK);
        GreenfootImage player2Win = new GreenfootImage(" Player 2 Wins! ", 45,Color.RED,Color.BLACK);
        
        
        int player1Total = player1Score.getScore();
        int player2Total = player2Score.getScore();
        
        //checks to see who has won the game
        if(player1Total >= 7)
        {
            removeObjects(null);
            getBackground().setColor(Color.BLACK);
            getBackground().fillRect(0,0,getWidth(),getHeight());
            getBackground().drawImage(player1Win, getWidth()/2, getHeight()/2);
        }
        else if(player2Total >= 7)
        {
            removeObjects(null);
            getBackground().setColor(Color.BLACK);
            getBackground().fillRect(0,0,getWidth(),getHeight());
            getBackground().drawImage(player2Win, getWidth()/2, getHeight()/2);
        }
    }
    
    /**
     * Returns startgame
     * @params = none
     * @return = returns a boolean
     * 
     */
    
    public boolean getStarted()
    {
        return startGame;
    }
    
}
