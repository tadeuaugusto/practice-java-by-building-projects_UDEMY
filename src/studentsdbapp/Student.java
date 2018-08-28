package studentsdbapp;

import java.util.Scanner;

/**
 * 
 * @author Tadeu
 *
 */
public class Student {
	
	/**
	 * First name
	 */
	private String firstName;
	
	/**
	 * Last name
	 */
	private String lastName;
	
	/**
	 * Grade Year
	 */
	private int gradeYear;
	
	/**
	 * Student id
	 */
	private String studentId;
	
	/**
	 * Courses
	 */
	private String courses = "";
	
	/**
	 * Tuition balance
	 */
	private int tuitionBalance;
	
	/**
	 * Unique 5-digit number, which is incremented in each new created account
	 */
	private static int id = 10000;
	
	/**
	 * Scanner
	 */
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Constructor
	 * Prompt user to enter student's name and year
	 */
	public Student() {
		// Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1. Freshman\n2. Sophmore\n3. Junior\n4. Senior");
		System.out.println("Enter student class level: ");
		this.gradeYear = in.nextInt();
		// in.close();
		
		// generating the student id
		generateStudentID();
	}
	
	/**
	 * Generate an ID
	 */
	private void generateStudentID() {
		// grade level + id
		id++;
		this.studentId = gradeYear + "" + id;
	}
	
	/**
	 * Enroll in courses
	 */
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = in.nextLine();
			
			if (!course.trim().equals("")) {
				if (!course.equals("Q")) {
					courses = courses + "\n   " + course;
					tuitionBalance = tuitionBalance + Constants.COST_OF_COURSE;
				} else {
					break;
				}
			}
		} while (1 != 0);
	}
	
	/**
	 * View balance
	 */
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	/**
	 * Pay tuition
	 */
	public void payTuition() {
		viewBalance();

		System.out.println("Enter your payment: $");
		int payment = in.nextInt();
		
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		
		viewBalance();
	}
	
	/**
	 * Override the toString() method to show the data
	 */
	public String toString() {
		return "\nNAME: " + firstName + " " + lastName +
				"\nID: " + studentId +
				"\nGRADE LEVEL: " + gradeYear +
				"\nCOURSES: " + courses +
				"\nBALANCE: $" + tuitionBalance;
	}
}
