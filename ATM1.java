import java.util.Scanner;

public class ATM1 {
private int balance;
private int pin;


public ATM1(int balance,int pin) {
	this.balance=balance;
	this.pin=pin;
}
public void displayMenu() {
	System.out.println("1:Check Balance");
	System.out.println("2:Deposit");
	System.out.println("3:Withdraw");
	System.out.println("4:Change Pin");
	System.out.println("5:Exit");
}
public void deposit(int amount) {
	balance+=amount;
}
public void withdraw(int amount) {
	if(balance<amount) {
		System.out.println("Insufficient funds!");
		return;
	}
	balance-=amount;
}
public int getbalance() {
	return balance;
}
public boolean validatePin(int pin) {
	return this.pin==pin;
}
public void changePin(int newPin) {
	pin=newPin;
	System.out.println("Pin changed!");
}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ATM1 atm=new ATM1(1000,1234);
    
	System.out.println("Enter the Pin:");
	int Pin=scanner.nextInt();
	
	if(atm.validatePin(Pin)) {
		int option=0;
		while(option!=5) {
			atm.displayMenu();
            option = scanner.nextInt();

			
			switch(option) {
			case 1:		 
			 System.out.println("Balance:"+atm.getbalance());
			 break;
			case 2:
			 System.out.println("Enter Amount:");
			 int depositAmount=scanner.nextInt();
			 atm.deposit(depositAmount);
			 break;
			case 3:
			 System.out.println("Enter Amount:");
			 int withdrawAmount=scanner.nextInt();
			 atm.withdraw(withdrawAmount);
			 break;
			case 4:
			 System.out.println("Enter new Pin:");
			 int newPin=scanner.nextInt();
			 atm.changePin(newPin);
			 break;
			case 5:
			 System.out.println("Thank you for using ATM.");
			 break;
			default:
			 System.out.println("Invalid choice. Please try again.");
			 break;
			
			}
		}
	}

	else {
		System.out.println("You have entered Invalid Pin!");
	}
	scanner.close();
}
}

