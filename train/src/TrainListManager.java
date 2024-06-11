import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class TrainListManager {
	private List<Train> trainList = new ArrayList<>();

	public enum TrainType {
		DIESEL,
		ELECTRIC
	}

	public String seek() {
		if (trainList.isEmpty()) {
			return "No Trains In List";
		}
		StringBuilder result = new StringBuilder();
		result.append("Number\tSpeed\tFuel %\t");
		for (int i = 0; i < trainList.size(); i++) {
			Train train = trainList.get(i);
			result.append("\n" + (i + 1) + "\t" + train.getSpeed() + "\t" + train.getFuelPercentage());
		}
		return result.toString();
	}	

	public void insert(TrainType trainType, int fuelPercentage) throws InvalidTrainTypeException {
		switch (trainType) {
			case DIESEL:
				trainList.add(new DieselTrain(fuelPercentage));
				break;
			case ELECTRIC:
				trainList.add(new ElectricTrain(fuelPercentage));
				break;
			default:
				throw new InvalidTrainTypeException("Invalid train type: " + trainType);		
		}
	}

	public void delete(UUID id) {
		for (int i = 0; i < trainList.size(); i++) {
			if (trainList.get(i).getId() == id)
				trainList.remove(i);
		}
	}

	public List<UUID> getTrainListUUIDs() {
		List<UUID> trainListUUIDs = new ArrayList<>();
		for (Train train : trainList) {
			trainListUUIDs.add(train.getId());
		}
		return trainListUUIDs;
	}

	public void sortTrains(String parameter){
		switch (parameter) {
			case "Length":
				Collections.sort(trainList, lengthComparator);
				break;

			case "Weight":
				Collections.sort(trainList, weightComparator);
				break;

			default:
				break;
		}
	}

	public static Comparator<Train> lengthComparator = new Comparator<Train>() {
        @Override
        public int compare(Train t1, Train t2) {
            return Integer.compare(t1.getLength(), t2.getLength());
        }
    };

	public static Comparator<Train> weightComparator = new Comparator<Train>() {
		@Override
		public int compare(Train t1, Train t2) {
			return Integer.compare(t1.getWeight(), t2.getWeight());
		}
	};

}
