package privblock.gerald.ryan.mains;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class AppMain {
	public static AccountAppMain accountApp = new AccountAppMain();
	public static BlockAppMain blockApp = new BlockAppMain();

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {

		int id;

		int choice = 0;
		while (choice != 8) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Pulling up account options");
				accountApp.main(args);
				break;
			case 2:
				System.out.println("Pulling up user options");
				break;
			case 3:
				System.out.println("Pulling up block interface");
				blockApp.main(args);
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
