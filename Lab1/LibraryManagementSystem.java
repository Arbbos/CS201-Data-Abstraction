import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LibraryManagementSystem {
	private ArrayList<String> books;

	public LibraryManagementSystem() {
		this.books = new ArrayList<>(); 
	}


	public void add(String book) {
		books.add(book);
		JOptionPane.showMessageDialog(null, book + " has been successfully added.");
	}

	public void insert(int index, String book) {
		if (index <= 0 || index > books.size() + 1) {
			JOptionPane.showMessageDialog(null, "Invalid index. Please provide a valid index.");
			return;
		}
		books.add(index - 1, book);
		JOptionPane.showMessageDialog(null, book + " has been successfully inserted at index " + index + ".");
	}

	public void remove(int index) {
		if (index < 0 || index >= books.size()) {
			// https://www.geeksforgeeks.org/array-index-out-of-bounds-exception-in-java/ 
			// for handling invalid index
			JOptionPane.showMessageDialog(null, "Invalid index. Please provide a valid index", "Error", JOptionPane.ERROR_MESSAGE);
		}
		String removedBook = books.remove(index - 1);
		JOptionPane.showMessageDialog(null, removedBook + " has been successfully removed.");
	}



	
	public static void main(String[] args) {
		LibraryManagementSystem lib = new LibraryManagementSystem();
		int choice;

		while (true) {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Library Management System. \n 1. Add book \n 2. Insert Book \n 3. Remove Book \n 4. Search Book \n 5. Show Number of Books \n 6. Exit\nWhat do you wish to do?"));

			switch (choice) {
			case 1:
				String bookadd = JOptionPane.showInputDialog("Enter the name of the book you wish to add: ");
				lib.add(bookadd); 
				break;

			case 2:
				if (lib.books.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No books to insert.");
				} else {
					int index = Integer.parseInt(JOptionPane.showInputDialog("Enter the index where you wish to insert the book:"));

					if (index <= 0 || index > lib.books.size() + 1) {
						JOptionPane.showMessageDialog(null, "Invalid index. Please provide a valid index.");
					} else {
						String bookToInsert = JOptionPane.showInputDialog("Enter the name of the book you want to insert: ");
						lib.insert(index, bookToInsert);
					}
				}
				break;

			case 3: 
				int indexToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the index where you wish to remove the book: "));
				lib.remove(indexToRemove);
				break;

			case 4:
				int bookIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the index of the book you wish to search: "));

				try {
					JOptionPane.showMessageDialog(null, "Result: " + lib.books.get(bookIndex - 1));
				} catch (Exception IndexOutOfBoundsException) {
					JOptionPane.showMessageDialog(null, "Invalid! Index does not exist.");
				}   
				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Program has been terminated.");
				return; 

					
			default:
				JOptionPane.showMessageDialog(null, "The option you selected does not exist. Please try again.");
				break;
			}
		}
	}
}
