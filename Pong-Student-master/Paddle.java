import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    //helps with making the hight of the paddle
    int WIDTH = 10;
    
    //helps with making the width of the paddle
    int HEIGHT = 60;
    
    //helps with making the controls for the paddle
    String upKey;
    
    //helps with making the controls for the paddle
    String downKey;
    
    /**
     * Creates the paddle and determines what paddle is on what side and what keys to use for each
     * @params = boolean isLeft
     * 
     */
     public Paddle(boolean isLeft)
     {
         GreenfootImage paddleImage = new GreenfootImage(WIDTH,HEIGHT);
         if(isLeft == true)
         {
             upKey = "w";
             downKey = "s";
             paddleImage.setColor(Color.CYAN);
         }
         else
         {
             upKey = "up";
             downKey = "down";
             paddleImage.setColor(Color.RED);
         }
         paddleImage.fillRect(0,0,WIDTH,HEIGHT);
         setImage(paddleImage);
     }
    
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //checks if the player has pressed keyboard keys
        checkKeyPress();
    }    
    
    /**
     * Sets setlocaton to when upkey or downkey is pressed, updates the location/movement of the paddle(s)
     * @params = non
     * @return = none
     */
    private void checkKeyPress()
    {
        if(Greenfoot.isKeyDown(upKey) == true)
        {
            setLocation(getX(),getY() - 4);
        }
        if(Greenfoot.isKeyDown(downKey) == true)
        {
            setLocation(getX(),getY() + 4);
        }
    }
    
    
}
