import java.util.Scanner;

public class Midterm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String password = null, username = null, temp1, temp2;
		int num1, num2, sentinel = 0;
		do {
			System.out.printf("What would you like to do:%n 0 Exit%n 1 Sign In%n 2 Register%n");
			sentinel = getSafeInt(sc);
			switch (sentinel) {
				case 0: break;
				case 1:
				if (username == null && password == null) {
					System.out.println("Please register.");
				}
				else {
					sc.nextLine();
					System.out.println("Please enter your username:");
					if(!(sc.nextLine().equals(username))) {
						System.out.println("Incorrect Username");
					}
					else {
						System.out.println("Please enter your password:");
						if(!(sc.nextLine().equals(password))) {
							System.out.println("Incorrect Password");
						}
						else {
							do {
								System.out.printf("What would you like to do:%n 0 Exit%n 1 Times Practice%n");
								sentinel = getSafeInt(sc);
								if (sentinel == 1) {
									num1 = (int)(Math.random() * 13);
									num2 = (int)(Math.random() * 13);
									System.out.printf("What is %d x %d: ", num1, num2);
									if (getSafeInt(sc) == num1 * num2) {
										System.out.println("Correct!");
									}
									else {
										System.out.println("Wrong.");
									}
								}
								else if (sentinel != 0) {
									System.out.println("Invalid Choice");
								}
							} while (sentinel != 0);
							System.out.println("Goodbye");
							sc.close();
							return;
						}
					}
				}
				break;
				case 2:
				sc.nextLine();
				System.out.println("Please enter your desired username:");
				username = sc.nextLine();
				System.out.println("Please enter your desired password:");
				password = sc.nextLine();
				break;
				default: System.out.println("Invalid Choice"); break;
			}
			
		} while (sentinel != 0);
		System.out.println("Goodbye");
		sc.close();
		return;
			
	}
	public static int getSafeInt(Scanner sc) {
		while(!sc.hasNextInt()) {
			System.out.println("Please do not enter anything else.");
			sc.nextLine();
		}
		return sc.nextInt();
	}

}
