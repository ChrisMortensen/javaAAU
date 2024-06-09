public class ElectricTrain extends Train {

	public ElectricTrain(int fuelPercentage) {
		this.fuelPercentage = fuelPercentage;
	}

	@Override
	public void fillFuel() {
		fuelPercentage = 100;
		System.out.println("Train has been fully charged.");
	}

}