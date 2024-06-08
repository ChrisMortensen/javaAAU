public class Bicycle {
	
	private String rider;
	private int speed;
	private int gear = 1;
	private Light frontLight = new Light("FrontLight");
	private Light backLight = new Light("BackLight");
	private Wheel frontWheel = new Wheel("FrontWheel");
	private Wheel backWheel = new Wheel("BackWheel");

	public Bicycle(String rider, int speed){
		this.rider = rider;
		this.speed = speed;
	}

	public void printBicycleOverview() {
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

	public String getRider(){
		return rider;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getGear(){
		return gear;
	}
	
	public void changeLightState(boolean state){
		frontLight.changeState(state);
		backLight.changeState(state);
	}

	public void step(int force){
		if(getWheelsAttachment()) return;
		speed += force > gear ? force-gear : 0;
	}
	
	public void brake(int amount){
		speed -= speed > 0 ? amount : 0;
		speed = speed < 0 ? 0 : speed;
	}

	public void changeGears(int wantedGear){
		gear = wantedGear;
	}

	public boolean getWheelsDamage(){
		return frontWheel.getDamageState() || backWheel.getDamageState();
	}
	
	private boolean getWheelsAttachment(){
		return frontWheel.getAttachedState() && backWheel.getAttachedState();
	}
}