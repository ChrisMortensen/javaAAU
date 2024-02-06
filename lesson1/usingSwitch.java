import java.util.Scanner;

public class usingSwitch {
	private enum Fruit{
		apple,
		banana,
		watermelon,
		lemon,
		pineapple,
		grape,
		mango,
		pear,
		peach,
		dragonfruit
	}
	public static void main(String[] args) {
		System.out.println("Enter a fruit:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().toLowerCase();
		scan.close();
		Fruit choice = Fruit.valueOf(input);
		
		System.out.println("You chose:");
		switch (choice) {
            case apple:
                System.out.println("Apple");
                break;
            case banana:
                System.out.println("Banana");
                break;
            case watermelon:
                System.out.println("Watermelon");
                break;
            case lemon:
                System.out.println("Lemon");
                break;
            case pineapple:
                System.out.println("Pineapple");
                break;
            case grape:
                System.out.println("Grape");
                break;
            case mango:
                System.out.println("Mango");
                break;
            case pear:
                System.out.println("Pear");
                break;
            case peach:
                System.out.println("Peach");
                break;
            case dragonfruit:
                System.out.println("Dragonfruit");
                break;
            default:
                System.out.println("Unknown fruit");
        }
	}
}