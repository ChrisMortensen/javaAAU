public class MountainBike extends Bicycle {
    private boolean suspensionActive = false;

    public MountainBike(String rider, int speed) {
        super(rider, speed);
    }

    public void toggleSuspension() {
        suspensionActive = !suspensionActive;
        System.out.println("Suspension is now " + (suspensionActive ? "active" : "inactive"));
    }

    @Override
    public void printOverview() {
        super.printOverview();
        System.out.println("Suspension          : " + (suspensionActive ? "Active" : "Inactive"));
    }
}