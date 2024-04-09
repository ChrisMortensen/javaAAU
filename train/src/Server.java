import java.io.*;
import java.net.*;

public class Server implements Runnable {
	private TrainListManager trainListManager;

	public Server(TrainListManager trainListManager) {
		this.trainListManager = trainListManager;
	}

	@Override
	public void run() {
		try {
			// Create a server socket on port 12345
			ServerSocket serverSocket = new ServerSocket(12345);

			int clientID = 0;
			// Wait for client connections
			System.out.println("Server is waiting for client connections...");
			while (true) {
				// Accept client connection
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client " + ++clientID + " connected!");

				// Create a new thread to handle communication with the client
				ClientHandler clientHandler = new ClientHandler(clientSocket, trainListManager);
				Thread thread = new Thread(clientHandler);
				thread.start();
				thread.join();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}