import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (Garrett Laturski) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    private GreenfootImage shield;
    private GreenfootImage start;
    private int reloadCount = 30;
    private int health = 100;
    private int shieldCounter = 0;
    private boolean isHit = false;

    /**
     * stores sprites for hero.cass
     */
    public Hero(){
        shield = new GreenfootImage("2.PNG");
        start = new GreenfootImage("1.PNG");
        
        setImage(start);
        
        
    }
    
     /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-6);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+6);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+6, getY());
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-6, getY());
        }
        
        if (Greenfoot.isKeyDown("Space")) 
        {
            if( reloadCount >= 30 ){
                getWorld().addObject(new Bomb(), getX() + 30, getY());
                reloadCount = 0;
            }
        }
        
        checkCollision();
    }
    
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        reloadCount++;
        
        if(isHit == true ){
        
            if( shieldCounter < 5){
                shieldCounter++;
        
            } else{
                shieldCounter = 0;
                isHit = false;
                setImage(start);
            }
            
        }
    }    
    
    /**
     * returns health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * checks to see if bomb hits a hunter
     */
    private void checkCollision(){
    
        if(isTouching(Hunter.class)){
            
            removeTouching(Hunter.class);
            
            health = health -25;
            
            isHit= true;
            setImage(shield);
        }
    
        if(health <= 0){
        
            getWorld().removeObject(this);
            
            
        }
    }
}
