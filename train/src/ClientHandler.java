import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Random;
import java.util.UUID;

class ClientHandler extends Thread {
	private Socket clientSocket;
	private TrainListManager trainListManager;

	public ClientHandler(Socket socket, TrainListManager trainListManager) {
		this.clientSocket = socket;
		this.trainListManager = trainListManager;
	}

	public void run() {
		try {
			// Open input and output streams for this client
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			// Communicate with the client
			Random rand = new Random();
			String message;
			while ((message = in.readLine()) != null) {
				switch (message) {
					case "seek":
						String trainListString = trainListManager.seek();
						out.println(trainListString);
						clientSocket.shutdownOutput();
						break;
					case "insert":
						TrainListManager.TrainType trainType = TrainListManager.TrainType.values()[rand
								.nextInt(TrainListManager.TrainType.values().length)];
						trainListManager.insert(trainType, rand.nextInt(101));
						break;
					case "delete":
						List<UUID> trainListUUIDs = trainListManager.getTrainListUUIDs();
						if (!trainListUUIDs.isEmpty())
							trainListManager.delete(trainListUUIDs.get(rand.nextInt(trainListUUIDs.size())));
						break;
					default:
						break;
				}
			}

			// Close streams and socket for this client
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Error with some I/O: " + e.getMessage());
			e.printStackTrace();
		} catch (InvalidTrainTypeException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}