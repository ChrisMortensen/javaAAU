public abstract class Vehicle implements VehicleInterface{
	protected int speed = 0;

	public int getSpeed(){
		return speed;
	}

	abstract void move();
}