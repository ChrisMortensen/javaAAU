public class ProgramManager {
	public static void main(String[] args) throws InterruptedException {
		TrainListManager trainListManager = new TrainListManager();
		for (int i = 0; i < 100; i++) {
			Operator op = new Operator(trainListManager);
			op.start();
			op.join();
		}
	}
}