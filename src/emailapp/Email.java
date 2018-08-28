package emailapp;

import java.util.Scanner;

/**
 * Generates new email accounts for new hires.
 * @author Tadeu
 *
 */
public class Email {

	/**
	 * First name
	 */
	private String firstName;
	
	/**
	 * Last name
	 */
	private String lastName;
	
	/**
	 * Password
	 */
	private String password;
	
	/**
	 * Department
	 */
	private String department;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * Mailbox capacity
	 */
	private int mailboxCapacity = Constants.MAILBOX_CAPACITY;
	
	/**
	 * Alternative email
	 */
	private String alternativeEmail;
	
	/**
	 * Email suffix
	 */
	private String emailSuffix = Constants.EMAIL_SUFFIX;
	
	private String SALES = "sales";
	private String DEV = "development";
	private String ACC = "accounting";
	
	private Scanner in;
	
	/**
	 * Constructor.
	 * Generate an email with the following syntax: firstname.lastname@department.company.com,
	 * if department is null, leave blank.
	 * @param firstName
	 * @param lastName
	 */
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// call a method asking for department - return the department
		this.department = getDepartment();
		
		// call a method that returns a random password
		this.setPassword(getRandomPassword(Constants.DEFAULT_PASSWORD_LENGTH));
		
		// combine elements to generate email
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()
					+ "@" + (department.equals("") ? emailSuffix : department + "." + emailSuffix);
	}
	
	/**
	 * Determine the department
	 * @return
	 */
	private String getDepartment() {
		System.out.println("New Worker: " + firstName);
		System.out.println("Department Codes:\n"
				+ "1. Sales\n"
				+ "2. Development\n"
				+ "3. Accounting\n"
				+ "0. None\n\n"
				+ "Enter department code: ");
		
		in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if (depChoice == 1) { return this.SALES; }
		else if (depChoice == 2) { return this.DEV; }
		else if (depChoice == 3) { return this.ACC; }
		else { return ""; }
	}
	
	/**
	 * Generate a random String for a password
	 * @param length
	 * @return
	 */
	private String getRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int randomValue = (int) (Math.random() * passwordSet.length());
			
			password[i] = passwordSet.charAt(randomValue);
		}
		return new String(password);
	}
	
	/**
	 * getPassword
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setPassword
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * getMailboxCapacity
	 * @return
	 */
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	/**
	 * setMailboxCapacity
	 * @param capacity
	 */
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	/**
	 * getAlternativeEmail
	 * @return
	 */
	public String getAlternativeEmail() {
		return alternativeEmail;
	}
	
	/**
	 * setAlternativeEmail
	 * @param altEmail
	 */
	public void setAlternativeEmail(String altEmail) {
		this.alternativeEmail = altEmail;
	}
	
	/**
	 * 
	 * @param newPassword
	 */
	public void changePassword(String newPassword) {
		this.setPassword(newPassword);
	}

	/**
	 * showInfo (name, email, mailboxCapacity)
	 * @return
	 */
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + " MB" + 
				"\nALTERNATIVE EMAIL: " + getAlternativeEmail();
	}
}
