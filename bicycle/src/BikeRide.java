import java.util.Scanner;

public class BikeRide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bicycle bicycle = null;

        while (bicycle == null) {
            System.out.println("\n--- Select Bicycle Type ---");
            System.out.println("1. Regular Bicycle");
            System.out.println("2. Electric Bicycle");
            System.out.println("3. Mountain Bike");
            System.out.println("4. Tandem Bicycle");
            System.out.print("Select a bicycle type: ");
            int bikeChoice = scanner.nextInt();

            switch (bikeChoice) {
                case 1:
                    bicycle = new Bicycle("John Doe", 0);
                    break;
                case 2:
                    bicycle = new ElectricBicycle("Jane Doe", 0);
                    break;
                case 3:
                    bicycle = new MountainBike("Alice", 0);
                    break;
                case 4:
                    bicycle = new TandemBicycle("Bob and Charlie", 0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        while (true) {
            System.out.println("\nRider: " + bicycle.getRider() + " | Gear: " + bicycle.getGear() + " | "
                    + bicycle.getSpeed() + "km\\h");
            System.out.println("--- Bicycle Control Menu ---");
            System.out.println("1. Ride forward");
            System.out.println("2. Change gears");
            System.out.println("3. Switch lights");
            System.out.println("4. Remove wheel");
            System.out.println("5. Fix wheel");
            System.out.println("6. Brake");
            System.out.println("7. Show bicycle overview");
            System.out.println("8. Toggle bike-specific feature");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter force to pedal: ");
                    int force = scanner.nextInt();
                    bicycle.step(force);
                    break;
                case 2:
                    System.out.print("Enter new gear: ");
                    int gear = scanner.nextInt();
                    bicycle.changeGears(gear);
                    break;
                case 3:
                    System.out.print("Turn lights on or off (1 for on, 2 for off): ");
                    int lightChoice = scanner.nextInt();
                    if (lightChoice == 1) {
                        bicycle.changeLightState(true);
                    } else if (lightChoice == 2) {
                        bicycle.changeLightState(false);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    System.out.print("Remove which wheel (1 for front, 2 for back): ");
                    int wheelChoice = scanner.nextInt();
                    if (wheelChoice == 1) {
                        bicycle.frontWheel.removeWheel(bicycle.getSpeed());
                    } else if (wheelChoice == 2) {
                        bicycle.backWheel.removeWheel(bicycle.getSpeed());
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    System.out.print("Fix which wheel (1 for front, 2 for back): ");
                    int fixChoice = scanner.nextInt();
                    if (fixChoice == 1) {
                        bicycle.frontWheel.fixWheel(bicycle.getSpeed());
                    } else if (fixChoice == 2) {
                        bicycle.backWheel.fixWheel(bicycle.getSpeed());
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 6:
                    System.out.print("Enter brake amount: ");
                    int brakeAmount = scanner.nextInt();
                    bicycle.brake(brakeAmount);
                    break;
                case 7:
                    bicycle.printOverview();
                    break;
                case 8:
                    if (bicycle instanceof ElectricBicycle) {
                        ((ElectricBicycle) bicycle).toggleMotor();
                    } else if (bicycle instanceof MountainBike) {
                        ((MountainBike) bicycle).toggleSuspension();
                    } else if (bicycle instanceof TandemBicycle) {
                        System.out.print("Occupy or leave second seat? (1 for occupy, 2 for leave): ");
                        int seatChoice = scanner.nextInt();
                        if (seatChoice == 1) {
                            ((TandemBicycle) bicycle).occupySecondSeat();
                        } else if (seatChoice == 2) {
                            ((TandemBicycle) bicycle).leaveSecondSeat();
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("This bicycle has no specific features to toggle.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
