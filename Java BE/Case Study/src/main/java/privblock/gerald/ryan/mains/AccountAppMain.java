package privblock.gerald.ryan.mains;
	
	import java.sql.SQLException;
	import java.util.Scanner;
	
	import privblock.gerald.ryan.entity.Account;
	import privblock.gerald.ryan.service.AccountService;
	
	
	
	public class AccountAppMain {
	
		public static Scanner sc = new Scanner(System.in);
	
		public static void main(String[] args) throws SQLException {
			AccountService accountApp = new AccountService();
	//		accountApp.connect();
			Account account;
			int id;
			/*
			 * 1. Add an account to the database 2. Access Account from the
			 * database 3. Update an employee info in the database 4. Remove an employee
			 * from the database 5. Display all employee info 6. validate employee 7. Update
			 * employee salary 8. Quit
			 */
	
			int choice = 0;
			while (choice != 8) {
				menu();
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("\nEnter the user_id and currency");
					Account new_account = new Account(Integer.parseInt(sc.nextLine()),0, sc.nextLine());
					accountApp.addAccountService(new_account);
					break;
				case 2:
					System.out.println("Enter the Account ID");
					id = Integer.parseInt(sc.nextLine());
					account = accountApp.getAccountService(id);
					if (account != null) {
						header();
						System.out.println(account);
					}
					break;
				case 3:
					System.out.println("\nEnter the Account ID and balance to be updated");
					accountApp.updateAccountService(sc.nextInt(), sc.nextDouble());
					break;
				case 4:
					System.out.println("Enter the Account ID to be removed");
					id = Integer.parseInt(sc.nextLine());
					accountApp.removeAccountService(id);
					break;
				case 5:
					header();
					accountApp.getAllAccountsService().forEach(System.out::println);
					break;
	//			case 6:
	//				System.out.println("\nEnter the Employee ID, Name, and Title to be validated");
	//				boolean valid = app.validateEmpService(Integer.parseInt(sc.nextLine()),
	//						sc.nextLine(), sc.nextLine());
	//				if (valid) {
	//					System.out.println("The employee is validated");
	//				} else {
	//					System.out.println("Invalid employee");
	//				}
	//				break;
	//			case 7:
	//				System.out.println("\nEnter employee id of employee to update");
	//				int eid = sc.nextInt();
	//				System.out.println("\nEnter New Salary");
	//				double salary = sc.nextDouble();
	////				e = app.getEmpService(id);
	////				e.setSalary(salary);
	//				app.updateEmployeeSalaryService(eid, salary);
	//				System.out.println("\nSalary updated");						
	//				break;
				case 8:
	//				accountApp.close();
					System.out.println("\nLeaving Account Panel...");
					break;
				}
			}
			sc.close();
		}
	
		public static void menu() {
			System.out.println("\n**Account DataBase App**");
			System.out.println("1. Add an Account");
			System.out.println("2. Access an Account");
			System.out.println("3. Update an Account");
			System.out.println("4. Remove a Account");
			System.out.println("5. Display all Accounts");
	//		System.out.println("6. Validate an employeee");
	//		System.out.println("7. Update EE Salary");
			System.out.println("8. Quit");
		}
	
		public static void header() {
			System.out.format("\n%5s %5s %10s %15s %15s %15s\n", "ID", "ownID", "balance", "currency", "date opened", "last accessed");
			System.out.println("-".repeat(100));
		}
	
	}
