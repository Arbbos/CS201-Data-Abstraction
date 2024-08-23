
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
	private ArrayList<String> books;

	public LibraryManagementSystem() {
		this.books = new ArrayList<>(); 
	}


	public void add(String book) {
		books.add(book);
		System.out.println(book + " has been successfully added.");
	}

	public static void main(String[] args) {
		LibraryManagementSystem lib = new LibraryManagementSystem();
		int choice;
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to Library Management System. \n 1. Add book \n 2. Insert Book \n 3. Remove Book \n 4. Search Book \n 5. Exit\nWhat do you wish to do?");
			choice = scan.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				System.out.println("Enter the name of the book you wish to add: ");
				String bookadd = scan.next();
				lib.add(bookadd); 
				break;

			case 5:
				System.out.println("Program has been terminated.");
				scan.close();
				return; 
			
			default:
				System.out.println("The option you selected does not exist. Please try again.");
				break;
			}
		}
	}
}
