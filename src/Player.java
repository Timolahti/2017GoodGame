import acm.graphics.GImage;

public class Player extends GImage {
	
	private int health = 9;
	private int x;
	private int y;

    public Player(String image) {
        
        super(image);
        
        // TODO Auto-generated constructor stub
    }
    
    /*
     * Moves the player character sideways the appropriate distance 
     */
    public void setInitialLocation(int a, int b)
    {
        super.setLocation(a, b);
        x = a;
        y = b;
    }
    
    
    
    public void move(double move) {
    	setLocation(getX() + move, getY());
    	pause(5);

    }
    
    /*
     * Jumps
     */
    public void jump(String image) {
    	
    }
    
    /*
     * Punches. Execute punching animation. Returns the boolean value isPunching. In Game.java after executing the punch and hitbox code
     * immediately set isPunching false
     */
    public boolean punch(String image, boolean isPunching) {
    	setImage(image);
    	pause(50);
    	return isPunching = true;
    }
    
    /*
     * Returns the player health
     */
    public int getHealth() {
    	return health;
    }
    
    /*
     * Called in hitbox code
     */
    public void getPunched() {
    	health--;
    }
    
    /*
     * Enacts death animation, moves player up and over as if uppercutted in the jaw and changes image to lying down
     * Also returns a boolean false to determine whether or not the game is over
     */
    public boolean die(String death, boolean gameover) {
    	this.setImage(death);
    	return gameover = true;
    }

}
