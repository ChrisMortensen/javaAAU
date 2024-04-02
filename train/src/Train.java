import java.util.UUID;

public abstract class Train extends Vehicle implements TrainInterface{
	private UUID id;
	int fuelPercentage = 0;

	public Train() {
        this.id = UUID.randomUUID();
    }

	public UUID getId() {
		return id;
	}

	public int getFuelPercentage(){
		return fuelPercentage;
	}

	public void move(){
		fuelPercentage -= 1;
		System.out.println("Fuel is at " + fuelPercentage + "%.");
	}

	public void speedUp() {
		if (speed > 0) {
			speed++;
			System.out.println("Train speed increased to " + speed + "km/h.");
		}
	}

	public void slowDown() {
		if (speed > 0) {
			speed--;
			System.out.println("Train speed decreased to " + speed + "km/h.");
		}
	}

	public void fillFuel(){
		System.out.println("Train has been filled with fuel.");
	}
}
