package privblock.gerald.ryan.mains;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.WrongMenuChoiceException;
import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.service.BlockService;

public class BlockAppMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		BlockService BlockApp = new BlockService();
		// BlockApp.connect();
		Block Block = null;
		int id;
		/*
		 * 1. Add an Block to the database 2. Access Block from the database 3. Update
		 * an employee info in the database 4. Remove an employee from the database 5.
		 * Display all employee info 6. validate employee 7. Update employee salary 8.
		 * Quit
		 */
		menu();
		int choice = 0;
		while (choice != 8) {

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch Exception thrown. Please enter a proper digit");
			}
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("\nMining Block and adding mined block..");
				BlockApp.addBlockService(Block.mine_block(Block.genesis_block(), new String[] { "yes", "yes", "yes" }));
				menu();
				break;
			case 2:
				System.out.println("Enter the Block ID");
				id = Integer.parseInt(sc.nextLine());
				Block = BlockApp.getBlockService(id);
				if (Block != null) {
					header();
					System.out.println(Block);
				}
				menu();
				break;
			case 3:
				header();
				BlockApp.getAllBlocksService().forEach(System.out::println);
				menu();
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
			default:
				break;
			}
		}
		sc.close();
	}

	public static void menu() {
		System.out.println("\n**Block DataBase App**");
		System.out.println("1. Add an Block");
		System.out.println("2. Access an Block");
		System.out.println("3. Display all Blocks");
		System.out.println("4. Quit");
	}

	public static void header() {
		System.out.format("\n%15s %15s %15s %15s %15s %15s %15s\n", "ID", "Timestamp", "lastHash", "hash", "data",
				"difficulty", "nonce");
		System.out.println("-".repeat(100));
	}

}
