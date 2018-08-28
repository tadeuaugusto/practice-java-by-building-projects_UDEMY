package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

/**
 * Main
 * @author Tadeu
 *
 */
public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// unitTest();
		integrationTest();
	}
	
	/**
	 * read a csv file and create new accounts based on that data:
	 * name, sSN, Savings/Checking, initDeposit
	 * Ex: Tadeu Dutra, 444102732, Savings, 1000
	 */
	private static void integrationTest() {
		// TODO Auto-generated method stub
		List<Account> accounts = new LinkedList<Account>();
		
		
		String file = "D:\\Downloads-ie\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			// System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
			
			if (accountType.equals("Savings")) {
				// System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Savings(name, sSN, initDeposit));
			} else if (accountType.equals("Checking")){
				// System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
			
			for (Account acc: accounts) {
				System.out.println("\n-------------");
				acc.showInfo();
			}

			accounts.get((int) Math.random() * accounts.size()).deposit(10000);
			accounts.get((int) Math.random() * accounts.size()).withdraw(3500);
			accounts.get((int) Math.random() * accounts.size()).deposit(1500);
			accounts.get((int) Math.random() * accounts.size()).transfer("N26 Account", 5000);
		}
	}

	public void unitTest() {
		Checking acc1 = new Checking("Tadeu Checking", "123456789", 1500);
		Savings acc2 = new Savings("Tadeu Savings", "999999999", 2000);

		acc1.compound();
		System.out.println();

		acc1.showInfo();
		System.out.println();
		acc2.showInfo();
		System.out.println();
		
		/*
		acc1.deposit(5000);
		acc1.withdraw(200);
		acc1.transfer("Brokerage", 3000);
		System.out.println();
		*/
	}

}
