import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    //playerScore counts the score of a player
    int playerScore;
    
    //isLeft is for who is on the left and who is on the right of the screen
    boolean isLeft;
    
    //checks to see if the score has changed
    boolean scoreChanged;
    
    /**
     * sets everything up for score
     */
    public Score(boolean onLeft)
    {
        playerScore = 0;
        isLeft = onLeft;
        displayScore();
    }
    
    
    

    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        //displays the score if the score has changed
        if(scoreChanged = true)
        {
            displayScore();
        }
        
            
    }    

    /**
     * code for placing and displaying the score on the screen
     * @return = none
     * @params = none
     */
    public void displayScore()
    {
        GreenfootImage display;
        if(isLeft == true)
        {
            display = new GreenfootImage(Integer.toString(playerScore), 30, Color.CYAN, Color.BLACK); 
        }
        else
        {
            display = new GreenfootImage(Integer.toString(playerScore), 30, Color.RED, Color.BLACK);
        }
        setImage(display);
    }
    
    /**
     * changes score change to true
     * @params = none
     * @return = none
     */
    public void countScore()
    {
        playerScore = 1;
        scoreChanged = true;
    }
    
    
    /**
     * returns the player score
     * @params = none
     * @return = returns an int variable (playerScore)
     */
    
    public int getScore()
    {
        return playerScore;
    }
    
    
}

