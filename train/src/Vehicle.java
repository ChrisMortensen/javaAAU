public abstract class Vehicle implements VehicleInterface{
	public abstract void speedUp();
	public abstract void slowDown();
	
	protected int speed = 0;
	
	public int getSpeed(){
		return speed;
	}
	
}
