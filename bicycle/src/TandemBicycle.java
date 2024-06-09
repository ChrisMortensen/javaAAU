public class TandemBicycle extends Bicycle {
    private boolean secondSeatOccupied = false;

    public TandemBicycle(String rider, int speed) {
        super(rider, speed);
    }

    public void occupySecondSeat() {
        if (secondSeatOccupied) {
            System.out.println("Second seat is already occupied.");
            return;
        }
        secondSeatOccupied = true;
        System.out.println("Second seat is now occupied.");
    }

    public void leaveSecondSeat() {
        if (!secondSeatOccupied) {
            System.out.println("Second seat is already unoccupied.");
            return;
        }
        secondSeatOccupied = false;
        System.out.println("Second seat is now unoccupied.");
    }

    @Override
    public void printOverview() {
        super.printOverview();
        System.out.println("Second seat         : " + (secondSeatOccupied ? "Occupied" : "Unoccupied"));
    }
}
