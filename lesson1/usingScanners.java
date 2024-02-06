import java.util.Scanner;

public class usingScanners {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		for (int i = 0; i < 10; i++) {
			System.out.println(input);
		}
	}
}