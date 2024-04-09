public class ClientProgram {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			Client c = new Client();
			c.start();
			c.join();
		}
	}
}