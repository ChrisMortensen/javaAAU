import java.util.*;

public class Race {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Bicycle[] bikes = new Bicycle[100];
        LinkedList<Bicycle> bicycleList = new LinkedList<>();
        Stack<Bicycle> bicycleStack = new Stack<>();
        PriorityQueue<Bicycle> bicyclePriorityQueue = new PriorityQueue<>(Comparator.comparing(Bicycle::getSpeed));
        HashMap<String, Bicycle> bicycleMap = new HashMap<>();

        // Create an array with 100 bicycles – each with individual characteristics.
        for (int i = 0; i < bikes.length; i++) {
            bikes[i] = new Bicycle("#" + i, rand.nextInt(80));
        }

        // Add them one-by-one to a stack.
        for (Bicycle bike : bikes) {
            bicycleStack.push(bike);
        }

        // Decrease the speed for each bicycle by 25% as you take them off the stack.
        while (!bicycleStack.isEmpty()) {
            Bicycle bike = bicycleStack.pop();
            bike.setSpeed((int) (bike.getSpeed() * 0.75));
        }

        // Add them one-by-one to a priorityqueue.
        for (Bicycle bike : bikes) {
            bicyclePriorityQueue.add(bike);
        }

        // Increase speed for each bicycle by 25% in the same order as you inserted the
        // bicycles.
        while (!bicyclePriorityQueue.isEmpty()) {
            Bicycle bike = bicyclePriorityQueue.poll();
            bike.setSpeed((int) (bike.getSpeed() * 1.25));
        }

        // Structure the bicycles in a LinkedList
        for (Bicycle bike : bikes) {
            bicycleList.add(bike);
        }

        // Remove all bicycles that drives less than 10 km/h from the LinkedList.
        Iterator<Bicycle> iterator = bicycleList.iterator();
        while (iterator.hasNext()) {
            Bicycle bike = iterator.next();
            if (bike.getSpeed() < 10) {
                iterator.remove();
            }
        }

        // Use a hashmap to organize the remaining bicycles
        for (Bicycle bike : bicycleList) {
            bicycleMap.put(bike.getRider(), bike);
        }

        // Use the inputted name to search and find the hashmapped bicycle and print its
        // info. Repeat this until the user types “exit”.
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("Enter a bicycle name (#<integer>) to find its info (type 'exit' to quit): ");
            userInput = scanner.nextLine();
            if (!userInput.equalsIgnoreCase("exit")) {
                Bicycle foundBicycle = bicycleMap.get(userInput);
                if (foundBicycle != null) {
                    foundBicycle.printOverview();
                } else {
                    System.out.println("Bicycle not found.");
                }
            }
        } while (!userInput.equalsIgnoreCase("exit"));
        scanner.close();
    }
}