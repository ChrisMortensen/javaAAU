public class Wheel {
	private String name;
	private boolean attached = true;
	private boolean damaged = false;

	public Wheel(String name) {
		this.name = name;
	}

	public boolean getDamageState(){
		return damaged;
	}

	public boolean getAttachedState(){
		return attached;
	}

	public void removeWheel(int speed){
		attached = speed == 0 ? false : true;
		if (!attached) {
			System.out.println(name + " is now off");
		}
	}

	public void fixWheel(int speed){
		if (speed == 0) {
			if (!attached){
				damaged = false;
				System.out.println(name + " is now fixed and back on");
			}
		}
	}
}