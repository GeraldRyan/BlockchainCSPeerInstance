package privblock.gerald.ryan.mains;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.entity.Blockchain;
import privblock.gerald.ryan.service.BlockService;
import privblock.gerald.ryan.service.BlockchainService;

public class BlockchainAppMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		BlockchainService blockchainApp = new BlockchainService();
		// BlockApp.connect();your
		Blockchain blockchain = null; // this was auto generated. Otherwise had error "Block may not have been
							// initialized". Why an issue??? TODO = find out
		int id;
		/*
		 * 1. Add an Block to the database 2. Access Block from the database 3. Update
		 * an employee info in the database 4. Remove an employee from the database 5.
		 * Display all employee info 6. validate employee 7. Update employee salary 8.
		 * Quit
		 */

		int choice = 0;
		while (choice != 8) {
			menu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("\nEnter the name of your new blockchain currency $:");
				blockchainApp.newBlockchainService(new Blockchain(sc.nextLine()));
				break;
			case 2:
				System.out.println("Enter Block ID");
				id = Integer.parseInt(sc.nextLine());
				blockchain = blockchainApp.getBlockchainService(id);
				if (blockchain != null) {
					header();
					System.out.println(blockchain);
				}
				break;
			case 3:
				header();
				blockchainApp.getAllBlockchainsService().forEach(System.out::println);
				break;
			// case 6:
			// System.out.println("\nEnter the Employee ID, Name, and Title to be
			// validated");
			// boolean valid = app.validateEmpService(Integer.parseInt(sc.nextLine()),
			// sc.nextLine(), sc.nextLine());
			// if (valid) {
			// System.out.println("The employee is validated");
			// } else {
			// System.out.println("Invalid employee");
			// }
			// break;
			// case 7:
			// System.out.println("\nEnter employee id of employee to update");
			// int eid = sc.nextInt();
			// System.out.println("\nEnter New Salary");
			// double salary = sc.nextDouble();
			//// e = app.getEmpService(id);
			//// e.setSalary(salary);
			// app.updateEmployeeSalaryService(eid, salary);
			// System.out.println("\nSalary updated");
			// break;
			case 4:
				// BlockApp.close();
				System.out.println("\nLeaving Block Panel...");
				break;
			}
		}
		sc.close();
	}

	public static void menu() {
		System.out.println("\n**Block DataBase App**");
		System.out.println("1. Register new Blockchain");
		System.out.println("2. Inspect a Blockchain");
		System.out.println("3. Display all Blockchain currencies");
		System.out.println("4. Quit");
	}

	public static void header() {
		System.out.format("\n%5s %15s %15s %15s %15s %15s\n", "ID", "Name", "date created", "last_modified", "length", "content");
		System.out.println("-".repeat(100));
	}

}
