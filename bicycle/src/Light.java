public class Light {
	private String name;
	private boolean state;

	public Light(String name) {
		this.name = name;
	}

	public boolean getState() {
		return state;
	}

	public void changeState(boolean state) {
		this.state = state;
		System.out.println(name + " is now " + (state ? "on" : "off"));
	}
}