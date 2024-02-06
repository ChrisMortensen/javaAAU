import java.util.Scanner;

public class usingVariables {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		int x = Integer.parseInt(input);
		for (int i = 1; i <= x; i++) {
			System.out.println(i + " <- Line Num");
		}
		while (x>0) {
			x--;
			System.out.println("There are " + (x) + " lines left.");
		}
	}
}