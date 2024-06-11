import java.io.*;
import java.net.*;

public class Server implements Runnable {
	private TrainListManager trainListManager;

	public Server(TrainListManager trainListManager) {
		this.trainListManager = trainListManager;
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(12345)){
			int clientID = 1;
			// Wait for client connections
			System.out.println("Server is waiting for client connections...");
			while (true) {
				// Accept client connection
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client " + clientID++ + " connected!");

				// Create a new thread to handle communication with the client
				ClientHandler clientHandler = new ClientHandler(clientSocket, trainListManager);
				Thread thread = new Thread(clientHandler);
				try {
					thread.start();
					thread.join();
				} catch (IllegalThreadStateException e) {
					System.err.println("Thread is already running: " + e.getMessage());
					e.printStackTrace();
				} catch (InterruptedException e) {
					System.err.println("Thread is being interrupted: " + e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Server port out of range (0-65535): " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error with some I/O: " + e.getMessage());
			e.printStackTrace();
		}
	}
}