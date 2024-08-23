package _1_PrelimPeriod_Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3_ConsoleInputOutputUsingInputStreamReaderAndBufferedReader {
	static String name;
	static String course;
	static String section;
	static String mobileNumber;
	static String age;
	
	public static void main(String[] args) throws IOException {
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(inReader);
		
		System.out.println("Enter Name: ");
		name = bReader.readLine();
		System.out.println("Hello " + name);
		
		System.out.println("Enter Course: ");
		course = bReader.readLine();
		System.out.println("Your Course is " + course);
		
		System.out.println("Enter Section: ");
		section = bReader.readLine();
		System.out.println("Section: " + section);
		
		System.out.println("Please Enter Your Mobile Number: ");
		mobileNumber =  bReader.readLine();
		System.out.println("Mobile Number: " + mobileNumber);
		
		System.out.println("Enter Age: ");
		age = bReader.readLine();
		System.out.println("Your Age Is: " + age );
	}

}
