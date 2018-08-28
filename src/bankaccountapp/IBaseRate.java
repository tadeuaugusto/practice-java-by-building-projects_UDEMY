package bankaccountapp;

/**
 * Determines the base interest rate.
 * 	Saving accounts will use .25 points less than the base rate.
 * 	Checking accounts will use 15% of the base rate.
 * @author Tadeu
 *
 */
public interface IBaseRate {

	// write a method that returns the base rate

	/**
	 * Returns the base rate
	 * @return
	 */
	default double getBaseRate() {
		return 2.5;
	}
}
