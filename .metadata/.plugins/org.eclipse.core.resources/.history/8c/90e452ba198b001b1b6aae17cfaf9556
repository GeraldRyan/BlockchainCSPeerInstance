package privblock.gerald.ryan.mains;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import privblock.gerald.ryan.entity.Block;
import privblock.gerald.ryan.service.BlockService;

public class BlockAppMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		BlockService BlockApp = new BlockService();
		// BlockApp.connect();
		Block Block = null; // this was auto generated. Otherwise had error "Block may not have been
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
				System.out.println("\nMining Block and adding mined block..");
				BlockApp.addBlockService(Block.mine_block(Block.genesis_block(), new String[] { "yes", "yes", "yes" }));
				// TODO make an interface for them to discover last blocks and add to that.
				// Probably belongs to chain class as opposed to block class, in which case,
				// keep using genesis blocks (which will ++ the id. oh well).
				break;
			case 2:
				System.out.println("Enter the Block ID");
				id = Integer.parseInt(sc.nextLine());
				Block = BlockApp.getBlockService(id);
				if (Block != null) {
					header();
					System.out.println(Block);
				}
				break;
			case 3:
				header();
				BlockApp.getAllBlocksService().forEach(System.out::println);
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
