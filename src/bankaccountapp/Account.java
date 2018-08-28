package bankaccountapp;

/**
 * Abstract class to share properties between Savings and Checking
 * @author Tadeu
 *
 */
public abstract class Account implements IBaseRate {

	/**
	 * Name of the account owner
	 */
	private String name;

	/**
	 * Social security number (unique 9-digit number)
	 */
	private String sSN;
	
	/**
	 * Account balance
	 */
	private double balance;

	/**
	 * Digit Account Number (generated with the following process:
	 * 1 or 2 depending on Savings or Checking, last two digits of SSN,
	 * unique 5-digit number, and a random 3-digit number)
	 */
	protected String accountNumber;

	/**
	 * rate
	 */
	protected double rate;
	
	/**
	 * Unique 5-digit number, which is incremented in each new created account
	 */
	private static int index = 10000;
	
	/**
	 * constructor to set base properties and initialize the account
	 * @param name
	 * @param sSN
	 * @param initDeposit
	 */
	public Account(String name, String sSN, double initDeposit) {
		setName(name);
		setsSN(sSN);
		setBalance(initDeposit);
		
		index++;
		
		this.accountNumber = getAccountNumber();
		
		setRate();
	}
	
	/**
	 * Abstract method used to force the implementation of setRate()
	 * if we are inheriting the Account class
	 */
	public abstract void setRate();
	
	/**
	 * Digit Account Number
	 * @return
	 */
	private String getAccountNumber() {
		String lastTwoSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueId = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoSSN + uniqueId + randomNumber;
	}
	
	// list common methods
	
	/**
	 * deposit
	 */
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	/**
	 * withdraw
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	/**
	 * transfer
	 */
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	/**
	 * printBalance
	 */
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	/**
	 * Show account information
	 */
	public void showInfo() {
		System.out.println("NAME: " + name +
							"\nACCOUNT NUMBER: " + accountNumber +
							"\nBALANCE: " + balance +
							"\nRATE: " + rate + "%");
	}
	
	/**
	 * Compound interest
	 */
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued interest: $" + accruedInterest);
		printBalance();
	}
	
	// getters and setters
	
	/**
	 * getName
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getsSN
	 * @return
	 */
	public String getsSN() {
		return sSN;
	}

	/**
	 * setsSN
	 * @param sSN
	 */
	public void setsSN(String sSN) {
		this.sSN = sSN;
	}

	/**
	 * getBalance
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * setBalance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
