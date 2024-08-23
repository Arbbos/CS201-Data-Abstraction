package _1_PrelimPeriod_Project;

import java.util.Scanner;

public class _2_ConsoleInputOutput {
	
		static String name;
		static String course;
		static String section;
		static long mobileNumber;
		static short age;
		
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter Name: ");
			name = scan.next();
			System.out.println("Hello " + name);
			
			System.out.println("Enter Course: ");
			course = scan.next();
			System.out.println("Your Course is " + course);
			
			System.out.println("Enter Section: ");
			section = scan.next();
			System.out.println("Section: " + section);
			
			System.out.println("Please Enter Your Mobile Number: ");
			mobileNumber =  scan.nextLong();
			System.out.println("Mobile Number: " + mobileNumber);
			
			System.out.println("Enter Age: ");
			age = scan.nextShort();
			System.out.println("Your Age Is: " + age );

	}

}
