import java.util.Random;
import java.util.Scanner;

public class usingRandom {
	public static void main(String[] args) {
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		Scanner scan = new Scanner(System.in);
		int guess = -1;
		System.out.println("Guess a whole number [0-10]");
		do {
			guess = Integer.parseInt(scan.nextLine());
			if (guess > randInt) {
				System.out.println("Too High.");
			} else if (guess < randInt) {
				System.out.println("Too Low.");
			} else {
				System.out.println("Right On!");
			}

		} while (guess != randInt);
		scan.close();
	}
}