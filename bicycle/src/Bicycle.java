public class Bicycle extends Object{

	private String rider;
	private int speed;
	private int gear = 1;
	public Light frontLight = new Light("FrontLight");
	public Light backLight = new Light("BackLight");
	public Wheel frontWheel = new Wheel("FrontWheel");
	public Wheel backWheel = new Wheel("BackWheel");

	public Bicycle(String rider, int speed) {
		this.rider = rider;
		this.speed = speed;
	}

	public void printOverview() {
		System.out.println("\n--- Bicycle Overview ---");
		System.out.println("Rider                : " + rider);
		System.out.println("Speed                : " + speed);
		System.out.println("Gear                 : " + gear);
		System.out.println("Front light          : " + frontLight.getState());
		System.out.println("Back light           : " + backLight.getState());
		System.out.println("Front wheel damage   : " + frontWheel.getDamageState());
		System.out.println("Back wheel damage    : " + backWheel.getDamageState());
		System.out.println("Front wheel attached : " + frontWheel.getAttachedState());
		System.out.println("Back wheel attached  : " + backWheel.getAttachedState());
	}

	public String getRider() {
		return rider;
	}

	public int getSpeed() {
		return speed;
	}

	public int getGear() {
		return gear;
	}

	public void changeLightState(boolean state) {
		frontLight.changeState(state);
		backLight.changeState(state);
	}

	public void step(int force) {
		if (!getWheelsAttachment()) {
			System.out.println("Cannot pedal, wheel(s) detached.");
			return;
		}
		int oldSpeed = speed;
		speed += force + speed > (gear - 1) * 5 ? force * gear * 0.1 : 0;
		if (speed == oldSpeed) {
			System.out.println("Not enough force to add speed.");
		}
	}

	public void brake(int amount) {
		if (amount > 0) {
			speed -= amount;
			speed = Math.max(speed, 0);
		}
	}

	public void changeGears(int wantedGear) {
		if (wantedGear > 0) {
			gear = wantedGear;
		} else {
			System.out.println("Gear must be a positive integer.");
		}
	}

	public boolean getWheelsDamage() {
		return frontWheel.getDamageState() || backWheel.getDamageState();
	}

	public boolean getWheelsAttachment() {
		return frontWheel.getAttachedState() && backWheel.getAttachedState();
	}
}