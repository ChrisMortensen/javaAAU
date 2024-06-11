import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Operator extends Thread{
	private TrainListManager trainListManager;

	private enum Action{
		SEEK,
		INSERT,
		DELETE
	}
	
	public Operator(TrainListManager trainListManager){
		this.trainListManager = trainListManager;
	}

	public void run(){
		Random rand = new Random();
		Action action = Action.values()[rand.nextInt(Action.values().length)];
		switch (action) {
			case SEEK:
				System.out.println(trainListManager.seek());
				break;
			case INSERT:
			TrainListManager.TrainType trainType = TrainListManager.TrainType.values()[rand.nextInt(TrainListManager.TrainType.values().length)];
				try {
					trainListManager.insert(trainType, rand.nextInt(101));
				} catch (InvalidTrainTypeException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				break;
			case DELETE:
				List<UUID> trainListUUIDs = trainListManager.getTrainListUUIDs();
				if (!trainListUUIDs.isEmpty())
					trainListManager.delete(trainListUUIDs.get(rand.nextInt(trainListUUIDs.size())));
				break;
			default:
				break;
		}
	}
}