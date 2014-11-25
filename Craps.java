import java.util.Scanner;

public class Craps {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = -1;
		while (true) {
			do {
				System.out.println("Enter 1 to play craps, enter 0 to quit");
				choice = input.nextInt();
			} while(choice != 1 && choice != 0);

			if (choice == 0) return;
			else {
				int val = rollDice();
				int pointRoll = 0;
				System.out.printf("Your first roll is %d.\n", val);
				if (isCraps(val)) {
					System.out.printf("Craps! You lose. You rolled %d.\n", val);
				} else if (isNatural(val)) {
					System.out.printf("You win! You rolled %d, a natural!\n", val);
				} else {
					while (pointRoll != 7 && pointRoll != val) {
						pointRoll = rollDice();
						System.out.printf("Your next roll is %d.\n", pointRoll);
					}
					if (pointRoll == 7)
						System.out.println("You lose, you rolled 7.");
					else
						System.out.println("You win! You rolled point!");
				}

			}
		}

	}

	// Generate a result of a craps roll
	public static int rollDice() {
		return (int) (1 + Math.random() * 6) + (int) (1 + Math.random() * 6);
	}

	// Check if craps (roll is 2, 3, or 12)
	public static boolean isCraps(int roll) {
		return roll == 2 || roll == 3 || roll == 12;
	}

	// Check if natural (roll is 7 or 11)
	public static boolean isNatural(int roll) {
		return roll == 7 || roll == 11;
	}

}
