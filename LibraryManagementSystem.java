package cs201_Lab;

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

	public void insert(int index, String book) {
		int index1 = index - 1; 
		books.add(index1, book); 
		System.out.println(book + " has been successfully inserted at index " + index + ".");
	}

	public void showBooks() {
		for(int i = 0; i < books.size(); i++) {
			System.out.println((i + 1) + ". " + books.get(i));
		}
	}

	public static void main(String[] args) {
		LibraryManagementSystem lib = new LibraryManagementSystem();
		int choice;
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to Library Management System. \n 1. Add book \n 2. Insert Book \n 3. Exit \nWhat do you wish to do?");
			choice = scan.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				System.out.println("Enter the name of the book you wish to add: ");
				String bookadd = scan.next();
				lib.add(bookadd); 
				break;

			case 2:
				if(lib.books.isEmpty()) {
					System.out.println("No books to show.");
				}
				else {
					System.out.println("Enter the index where you wish to insert the book:");
					int index = scan.nextInt(); 
					if (index < 0 || index > lib.books.size()) {
						System.out.println("Does not exist.");
					}
					else {
						System.out.println("Enter the name of the book you want to insert: ");
						String bookToInsert = scan.next();
						lib.insert(index, bookToInsert); 
					}

				}

				break;

			case 3:
				System.out.println("Program has been terminated.");
				scan.close();
				return; 
			
			case 4:
				lib.showBooks();
				
			
			default:
				System.out.println("The option you selected does not exist. Please try again.");
				break;
			}
		}
	}
}
