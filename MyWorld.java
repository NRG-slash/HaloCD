import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Garrett Laturski) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Hero hero;
    
    private int time;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        time = 5000;
        showTime();
        prepare();
        showHealth();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        hero = new Hero();
        addObject(hero,65,203);
        
        for(int i =0; i < 3; i++){
            addObject(new Hunter(), Greenfoot.getRandomNumber(100) + 300, Greenfoot.getRandomNumber(400));
        }
    }
    
    /**
     * Shows health
     */
    public void showHealth(){
        showText( "Health: " + hero.getHealth(), 80, 25);
    }
    
    /**
     * 
     */
    public void act(){
    
                        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Hunter(), 779, Greenfoot.getRandomNumber(360));
        }
        showHealth();
        countTime();
        checkLose();
        
        if( time >= 0){
        
            Greenfoot.playSound("au.wav");
           
        } 
        
        
  
    }
    
    /**
     * checks to see if you lose
     */
        private void checkLose(){

        if( getObjects(Hero.class).isEmpty() ){

            showText("You Lose :(", 300, 180);
            Greenfoot.stop();
        }

    }
    
    /**
     * shows timer
     */
            private void showTime(){
        showText(String.format("time: " + time), 500, 25);
        
    }
    
    /**
     * counts down time
     */
        private void countTime(){
        time--;
        showTime();
        
        if(time <= 0 ){
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    /**
     * tells player that they won
     */
        private void showEndMessage(){
        showText("You Win" , 300, 180);
    }
}
