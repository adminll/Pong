import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    //Int size helps make the size of ball
    int SIZE = 20;
    
    //velocity is for how fast the ball moves per pixel
    private static int velocity = 0;

    /**
     * Creates the balls size and form
     * 
     */
    public Ball()
    {
        GreenfootImage ballImage = new GreenfootImage(SIZE,SIZE);
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval(0,0,SIZE,SIZE);
        setImage(ballImage);
        turn(Greenfoot.getRandomNumber(360));
    }
    

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        PlayField field = (PlayField) getWorld();

        //checks if it hit a paddle and moves the ball
        if(field.getStarted() == true)
        {
            move(velocity);
            checkCollisions();
        }   
    }
    
    /*
     * checks if it has hit a paddle
     */
    private void checkCollisions()
    {
        
        Actor hitting = getOneIntersectingObject(Paddle.class);
        PlayField world = (PlayField) getWorld();
        Score getPoint;
        
        //checks if i hits the paddle, will make it reverse and go the opposite direction
        if(hitting != null)
        {
            velocity = -velocity;
            setRotation( -getRotation() );
            move(velocity);
        }
        if(getY() <= 10)
        {
            setRotation( -getRotation() );
        }
        if(getY() >= 590)
        {
            setRotation( -getRotation() );
        }
        
        //if hits edge of the world, resets and adds 1 to the score
        if(getX() <= 10)
        {
            getWorld().removeObject(this);
            getPoint = (Score)world.getObjects(Score.class).get(1);
            getPoint.countScore();
            world.reset();
        }
        else if(getX() >= 790)
        {
            getWorld().removeObject(this);
            getPoint = (Score)world.getObjects(Score.class).get(1);
            getPoint.countScore();
            world.reset();
        }
    }

    /**
     * sets the velocity to v
     * @params = int v
     * @return = none
     */
    public void setVelocity(int v)
    {
        velocity = v;
    }
}
