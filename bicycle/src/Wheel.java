public class Wheel {
	
	private boolean attached = true;
	private boolean damaged = false;

	public boolean getDamageState(){
		return damaged;
	}

	public boolean getAttachedState(){
		return attached;
	}

	public void removeWheel(int speed){
		attached = speed == 0 ? false : true;
	}

	public void fixWheel(int speed){
		if (speed == 0) {
			if (!attached){
				damaged = false;
			}
		}
	}
}