import java.util.ArrayList;
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

	public void insert(TrainType trainType, int fuelPercentage) {
		switch (trainType) {
			case DIESEL:
				trainList.add(new DieselTrain(fuelPercentage));
				break;
			case ELECTRIC:
				trainList.add(new ElectricTrain(fuelPercentage));
				break;
			default:
				break;
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
}
