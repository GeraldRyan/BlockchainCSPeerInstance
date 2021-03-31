package privblock.gerald.ryan.mains;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;
import privblock.gerald.ryan.service.BlockService;
import privblock.gerald.ryan.service.BlockchainService;

public class BlockchainAppMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		BlockchainService blockchainApp = new BlockchainService();
		// BlockApp.connect();
		Blockchain blockchain = null;
		int id;
		/*
		 * 1. Register new currency 2. Access currency from database 3. Update an
		 * employee info in the database 4. Remove an employee from the database 5.
		 * Display all employee info 6. validate employee 7. Update employee salary 8.
		 * Quit
		 */
		menu();
		int choice = 0;
		while (choice != 5) {

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch Exception thrown. Please enter a proper digit");
			}
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("\nEnter the name of your new blockchain (SuperCoin) instance $:");
				blockchainApp.newBlockchainService(sc.nextLine());
				menu();
				break;
			case 2:
				System.out.println("Enter Blockchain instance name");
				blockchain = blockchainApp.getBlockchainService(sc.nextLine());
				if (blockchain != null) {
					header();
					System.out.println(blockchain.toStringConsole());
				}
				menu();
				break;
			case 3:
				header();
				blockchainApp.getAllBlockchainsService().forEach(System.out::println);
				menu();
				break;
			case 4:
				System.out.println("Enter the name of blockchain instance to mine");
				String name = sc.nextLine();
				String[] dummyData = new String[] { "dummy", "data" };	
				Blockchain blockchain_to_mine = blockchainApp.getBlockchainService(name); // TODO seems wasteful to call
																							// function just for test
				if (blockchain_to_mine == null) {
					System.out.println("The blockchain instance you selected does not appear to exist in our system");
					menu();
					break;
				} else {
					blockchainApp.addBlockService(name, dummyData);
					menu();
					break;
				}
			case 5:
				// BlockApp.close();
				System.out.println("\nLeaving Block Panel...");
				break;
			default:
				System.out.println("Surely you know you are out of range. Please try again");
			}
		}
		sc.close();
	}

	public static void menu() {
		System.out.println("\n**Block DataBase App**");
		System.out.println("1. Register new Blockchain instance");
		System.out.println("2. Inspect a Blockchain instance");
		System.out.println("3. Display all Blockchain instances");
		System.out.println("4. Mine Block with selected chain");
		System.out.println("5. Quit");
	}

	public static void header() {
		System.out.format("\n%5s %15s %15s %15s %15s\n", "ID", "INSTANCE_NAME", "DATE_CREATED", "DATE_LAST_MODIFIED",
				"LENGTH_OF_CHAIN");
		System.out.println("-".repeat(100));
	}

}
