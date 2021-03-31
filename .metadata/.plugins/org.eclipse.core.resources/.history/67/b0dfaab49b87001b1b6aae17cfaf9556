package privblock.gerald.ryan.main;

import java.util.Scanner;

public class AppMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int id;

		int choice = 0;
		while (choice != 8) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Pulling up account options");
				break;
			case 2:
				System.out.println("Pulling up user options");
				break;
			case 3:
				System.out.println("Pulling up block interface");
				break;
			case 4:
				System.out.println("Pulling up blockchain interface");
				break;
			case 8:
				System.out.println("\nClosing down");
				break;
			}
		}
		sc.close();
	}

	public static void menu() {
		System.out.println("\n**Account DataBase App**");
		System.out.println("1. Access Accounts Panel");
		System.out.println("2. Access Users Panel");
		System.out.println("3. Access Block Panel");
		System.out.println("4. Access Blockchain Panel");
		System.out.println("8. Quit");
	}
}
