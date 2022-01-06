
public class MovableSpriteAnimation implements Animation {

	private int universeCount = 0;
	
	public Universe getNextUniverse() {

		universeCount++;
		
		if (universeCount == 1) {
			return new MovableSpriteUniverse();
		}
		else {
			return null;
		}
	}
	
}
