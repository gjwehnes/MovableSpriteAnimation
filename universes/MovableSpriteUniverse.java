import java.util.ArrayList;

public class MovableSpriteUniverse implements Universe {

	private boolean complete = false;	
	private Background background = null;	
	private DisplayableSprite player1 = null;
	private ArrayList<DisplayableSprite> sprites = new ArrayList<DisplayableSprite>();
	private long elapsedTime = 0;
	private String status = "";

	private final double VELOCITY = 200;	
	
//	//require a separate list for sprites to be removed to avoid a concurence exception
	private ArrayList<DisplayableSprite> disposalList = new ArrayList<DisplayableSprite>();

	
	public MovableSpriteUniverse () {
	
	this.setXCenter(0);
	this.setYCenter(0);

	player1 = new ABCSprite();
	sprites.add(player1);

	MovableSprite movable = (MovableSprite)player1;
	movable.setCenterX(-300);
	movable.setCenterY(-200);
	
}
	
	public double getScale() {
		return 1;
	}

	public double getXCenter() {
		return 0;
	}

	public double getYCenter() {
		return 0;
	}
	
	public void setXCenter(double xCenter) {
	}

	public void setYCenter(double yCenter) {
	}
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
	}

	public ArrayList<Background> getBackgrounds() {
		return null;
	}

	public DisplayableSprite getPlayer1() {
		return player1;
	}

	public ArrayList<DisplayableSprite> getSprites() {
		return sprites;
	}
		
	public boolean centerOnPlayer() {
		return false;
	}		
	
	public void update(Animation animation, long actual_delta_time) {

		double velocityX = 0;
		double velocityY = 0;
		
		elapsedTime += actual_delta_time;
		long period = elapsedTime / 2000;
		long phase = period % 4;
		
		if (phase == 0 ) {
			// RIGHT
			velocityX += VELOCITY;
		}
		else if (phase == 1) {
			// DOWN
			velocityY += VELOCITY;						
		}
		else if (phase == 2) {			
			//LEFT	
			velocityX = -VELOCITY;			
		}
		else {
			//UP
			velocityY = -VELOCITY;						
		}
		
		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
			
			if (sprite instanceof MovableSprite) {
				MovableSprite movable = (MovableSprite)sprite;
				movable.setVelocityX(velocityX);
				movable.setVelocityY(velocityY);
			}
			
			sprite.update(this, actual_delta_time);
    	}    	

	}
	
	public String toString() {
		return this.status;
	}	

}
