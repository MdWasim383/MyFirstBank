package Banking;
import java.util.Scanner; 
public class Account {
	//Class Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
   
	//Class Constructor
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	//Function for Depositing Money
	void deposit(int amount) {
		if (amount !=0) {
			balance = balance+ amount;
			System.out.println(amount+" Deposited into Your Account");
			previousTransaction = amount;
		}
	}
	//Function for Withdrawing Money
	void withdraw(int amount) {
		if(amount !=0) {
			balance = balance-amount;
			System.out.println(amount+" Withdrawn from Your Account");
			previousTransaction = -amount;
			
		}
	}
	//Function Showing the Previous Transaction
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited"+ previousTransaction);
		}else if(previousTransaction < 0) {
	       System.out.println("Withdrawn"+ Math.abs(previousTransaction));
		}else {
			System.out.println("No Transaction Occured");
		}
	}
	//Function calculating the interest of current funds after a numbers of years
	void calculateInterest(int years) {
		double interestRate = .0685;
		double newBalance = (balance * interestRate *years)+balance;
		System.out.println("The current interest rate is "+ (100 *interestRate)+ "%");
		System.out.println("After "+ years + " years, your balance will be: " + newBalance);
	}
	//Function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, "+ customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = sc.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//
			case 'A':
				System.out.println("__________________________________");
				System.out.println("Balance = $" + balance);
		        System.out.println("__________________________________");
		        System.out.println();
		        break;
		        //
			case 'B':
				System.out.println("Enter an amount to deposit:");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
				//
			case 'C':
				System.out.println("Enter an amount to withdraw");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				//
			case 'D':
				System.out.println("_________________________________");
				getPreviousTransaction();
				System.out.println("_________________________________");
				System.out.println();
				break;
				//
			case 'E':
				System.out.println("Enter how many years of accured interest:");
				int years = sc.nextInt();
				calculateInterest(years);
				break;
				//
			case 'F':
				System.out.println("*********************************");
				break;
				//
				default:
					System.out.println("Error: invalid option. please enter A, B, C, D, E, or F ");
					break;		
			}
		}while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}
	
	
}
