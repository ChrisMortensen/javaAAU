public class Wheel {
	private String name;
	private boolean attached = true;
	private boolean damaged = false;

	public Wheel(String name) {
		this.name = name;
	}

	public boolean getDamageState() {
		return damaged;
	}

	public boolean getAttachedState() {
		return attached;
	}

	public void removeWheel(int speed) {
		if (!attached) {
			System.out.println(name + " is already off");
			return;
		}
		if (!(speed == 0)) {
			System.out.println("Stop in order to remove " + name);
			return;
		}
		attached = false;
		System.out.println(name + " is now removed");
	}

	public void fixWheel(int speed) {
		if (!(speed == 0)) {
			System.out.println("Stop in order to fix " + name);
			return;
		}
		if (attached) {
			System.out.println("Remove " + name + " in order to fix it");
			return;
		}
		damaged = false;
		attached = true;
		System.out.println(name + " is now fixed and back on");
	}
}