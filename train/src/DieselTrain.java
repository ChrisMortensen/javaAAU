public class DieselTrain extends Train {

	public DieselTrain(int fuelPercentage) {
		this.fuelPercentage = fuelPercentage;
	}
	
	@Override
	public void fillFuel() {
		fuelPercentage = 100;
		System.out.println("Train has been filled with disel.");
	}

}
