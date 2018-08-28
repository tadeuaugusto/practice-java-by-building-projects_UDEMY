package bankaccountapp;

/**
 * Savings account
 * @author Tadeu
 *
 */
public class Savings extends Account {

	/**
	 * Safety Deposit Box Id (3-digit number)
	 * */
	private int safetyDepositBoxId;

	/**
	 * Safety Deposit Box Key (4-digit number)
	 * */
	private int safetyDepositBoxKey;

	/**
	 * Constructor to initialize settings for the properties.
	 * Ex: Tadeu Dutra, 444102732, Savings, 1000 (name, sSN, "Savings", initDeposit)
	 * @param name
	 * @param sSN
	 * @param initDeposit
	 */
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		
		setSafetyDepositBox();
	}
	
	/**
	 * Generate random values for safetyDeposityBoxId and safetyDeposityBoxKey
	 */
	private void setSafetyDepositBox() {
		// TODO Auto-generated method stub
		safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,  4));
	}

	// list methods specific to a Checking account
	
	/**
	 * Use polymorphism to execute showInfo from the super class
	 * plus the specific sysout for Checking account type
	 */
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Savings Account Features:" +
				"\n Safety Deposit Box ID: " + safetyDepositBoxId +
				"\n Safety Deposit Box Key: " + safetyDepositBoxKey);
	}

	/**
	 * Savings account uses .25 less than the base rate
	 */
	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() - .25;
	}	
}
