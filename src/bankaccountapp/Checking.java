package bankaccountapp;

/**
 * Checking account
 * @author Tadeu
 *
 */
public class Checking extends Account {
	
	/**
	 * Debit Card (12-digit number)
	 * */
	private int debitCardNumber;
	
	/**
	 * Card PIN (4-digit number)
	 */
	private int debitCardPin;
	
	/**
	 * */
	/**
	 * Constructor to initialize settings for the properties.
	 * Ex: Tadeu Dutra, 444102732, Savings, 1000 (name, sSN, "Checking", initDeposit)
	 * @param name
	 * @param sSN
	 * @param initDeposit
	 */
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		
		setDebitCardNumber();
	}
	
	
	// list methods specific to a Checking account
	
	/**
	 * Generate random values for debitCardNumber and debitCardPin
	 */
	private void setDebitCardNumber() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	
	/**
	 * Use polymorphism to execute showInfo from the super class
	 * plus the specific sysout for Checking account type
	 */
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features:" +
				"\n Debit Card: " + debitCardNumber +
				"\n Card PIN: " + debitCardPin);
	}

	/**
	 * Checking account uses 15% of the base rate
	 */
	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() * .15;
	}

}
