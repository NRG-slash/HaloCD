import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (Garrett Laturski) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private GreenfootImage normal;
    private GreenfootImage boom;
    private boolean hasBoom = false;
    private int boomCounter = 0;

    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        int xLocation;
        
        if(hasBoom == true ){
        
            if( boomCounter < 5){
                boomCounter++;
        
            } else{
                boomCounter = 0;
                getWorld().removeObject(this);
            }
            
        } else {
            setLocation(getX() + 5, getY());
        
            xLocation  = getX();
        
            checkCollision();  
            
            if( xLocation == 599) {
                getWorld().removeObject(this);
            }
        }

        
    }
    
    /**
     * stores sprites for bomb.cass
     */
     public Bomb(){
        
        normal = new GreenfootImage("boom2.png");
        boom = new GreenfootImage("Capture12.PNG");
        
        setImage(normal);
        
    }
    
    /**
     * checks to see if bomb hits a hunter
     */
    private void checkCollision(){
    
        if(isTouching(Hunter.class)){
            setImage(boom);
            getImage().scale(50, 50);
            removeTouching(Hunter.class);
            hasBoom = true;
        }
    
    }

}
