public class ElectricBicycle extends Bicycle {
    private boolean isMotorOn = false;

    public ElectricBicycle(String rider, int speed) {
        super(rider, speed);
    }

    public void toggleMotor() {
        isMotorOn = !isMotorOn;
        System.out.println("Electric motor is now " + (isMotorOn ? "on" : "off"));
    }

    @Override
    public void printOverview() {
        super.printOverview();
        System.out.println("Electric motor      : " + (isMotorOn ? "On" : "Off"));
    }
}