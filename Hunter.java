import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hunter here.
 * 
 * @author (Garrett Laturski) 
 * @version (a version number or a date)
 */
public class Hunter extends Actor
{
    private int speed = 1;
    
    /**
     * Act - do whatever the Hunter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(-3); 
       
       
       
       if( getX() == 5) {
             getWorld().removeObject(this);
             
        }
    }   
    

}
