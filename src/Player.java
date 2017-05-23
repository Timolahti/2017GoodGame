import acm.graphics.GImage;

public class Player extends GImage {
	
	private int health = 9;

    public Player(String image, int x, int y) {
        super(image, x, y);
        // TODO Auto-generated constructor stub
    }
    
    /*
     * Moves the player character sideways the appropriate distance 
     */
    public void move(int x) {
    	
    }
    
    /*
     * Punches. Execute punching animation. Returns the boolean value isPunching. In Game.java after executing the punch and hitbox code
     * immediately set isPunching false
     */
    public boolean punch(GImage punch, boolean isPunching) {
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
