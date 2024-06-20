
public class MovableSpriteAnimation implements Animation {

	private Universe current = new MovableSpriteUniverse();
	private boolean universeSwitched = false;
	private boolean animationComplete = false;
	
	public Universe switchUniverse(Object event) {

		universeSwitched = true;
		//there is only the initial universe; when a switch is called for, set current to null;
		animationComplete = true;
		
		return current;

	}

	public Universe getCurrentUniverse() {
		return current;
	}
	
	@Override
	public boolean getUniverseSwitched() {
		return universeSwitched;
	}

	@Override
	public void acknowledgeUniverseSwitched() {
		this.universeSwitched = false;		
	}

	@Override
	public boolean isComplete() {
		return animationComplete || current.isComplete();
	}

	@Override
	public void setComplete(boolean complete) {
		this.animationComplete = true;		
	}

	@Override
	public void update(AnimationFrame frame, long actual_delta_time) {
	}
	
}
