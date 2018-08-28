package studentsdbapp;

import java.util.Scanner;

/**
 * Main
 * @author Tadeu
 *
 */
public class StudentDbApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean runAgain = false;

		// 1. ask how many users we want to add, set numberOfStudents
		System.out.println("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numberOfStudents = in.nextInt();
		
		// 2. create a dynamic array of objects
		Student[] students = new Student[numberOfStudents];
		
		// 3. create n number of new students
		for (int i = 0; i < numberOfStudents; i++) {
			students[i] = new Student();
			students[i].enroll();
			
			do {
				students[i].payTuition();
				System.out.println("Submit another Payment? (Y/N)");
				in = new Scanner(System.in);
				runAgain = in.nextLine().equals("Y") ? true : false;
				
				System.out.println();
				
			} while(runAgain);
		}
		
		// 4. print the information for each student
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println(students[i].toString());
		}
		
		System.out.println("Thanks for visiting. Bye!!!!!");
	}

}
