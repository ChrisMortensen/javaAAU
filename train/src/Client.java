import java.io.*;
import java.net.*;
import java.util.Random;

public class Client extends Thread {
	public void run() {
		try {
			// Connect to the server
			Socket socket = new Socket("127.0.0.1", 12345);

			// Open input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// Send a message to the server
			Random rand = new Random();
			switch (rand.nextInt(3)) {
				case 0:
					out.println("seek");
					// Receive response from the server
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
					break;
				case 1:
					out.println("insert");
					break;
				case 2:
					out.println("delete");
					break;
				default:
					break;
			}
			// Close streams and socket
			in.close();
			out.close();
			socket.close();
		} catch (UnknownHostException e) {
			System.err.println("Host could not be found. (Check if host-ip is correct): " + e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.err.println("Host port out of port-range (0-65535): " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error with some I/O: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
