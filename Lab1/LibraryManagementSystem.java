package cs201_Lab;

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

	public void size() {
		if (books.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No books available in the library.", "Library Management System", JOptionPane.INFORMATION_MESSAGE);
		} else {
			StringBuilder message = new StringBuilder("Books in the library:\n");
			for (int i = 0; i < books.size(); i++) {
				message.append((i + 1)).append(". ").append(books.get(i)).append("\n");
			}
			message.append("\nTotal number of books in the library: ").append(books.size());
			JOptionPane.showMessageDialog(null, message.toString(), "Library Management System", JOptionPane.INFORMATION_MESSAGE);
		}
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
		Library_Management_System lib = new Library_Management_System();
		String option[] = {"Add Book", "Insert Book", "Borrow Book", "Search Book", "Return Book", 
				"Remove Book", "Show Books", "Sort Books", "Undo", "Exit"};

		//		"0.Add Book", "1. Insert Book", "2. Borrow Book", "3. Search Book", "4. Return Book", 
		//		"5. Remove Book", "6. Show Books", "7. Sort Books", "8. Undo", "9. Exit"


		while (true) {
			int choice;
			choice = JOptionPane.showOptionDialog(null, "Choose an action:",
					"Library Management System", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

			switch (choice) {
			case 0:
				String bookadd = JOptionPane.showInputDialog("Enter the name of the book you wish to add: ");
				lib.add(bookadd); 
				break;

			case 1:
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
				
//			case 2: Borrow Books
				
			case 3:
				int bookIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the index of the book you wish to search: "));

				try {
					JOptionPane.showMessageDialog(null, "Result: " + lib.books.get(bookIndex - 1));
				} catch (Exception IndexOutOfBoundsException) {
					JOptionPane.showMessageDialog(null, "Invalid! Index does not exist.");
				}   
				break;
				
//			case 4: Return Book
				
			case 5: 
				int indexToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the index where you wish to remove the book: "));
				lib.remove(indexToRemove);
				break;


			case 6: 
				lib.size();
				break;
			
//			case 7: Sort Books
				
//			case 8: Undo

			case 9:
				JOptionPane.showMessageDialog(null, "Program has been terminated.");
				return; 


			default:
				JOptionPane.showMessageDialog(null, "The option you selected does not exist. Please try again.");
				break;
			}
		}
	}
}
