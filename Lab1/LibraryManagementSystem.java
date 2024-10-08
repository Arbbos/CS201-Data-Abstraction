package cs201_Lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class LibraryManagementSystem {
	private ArrayList<String> books;
	private Stack<String> undoStack;
	private Stack<String> borrowedBooks;

	public LibraryManagementSystem() {
		this.books = new ArrayList<>(); 
		this.undoStack = new Stack<>();
		this.borrowedBooks = new Stack<>();
	}


	public void add(String book) {
		books.add(book);
		undoStack.push(book);
		JOptionPane.showMessageDialog(null, book + " has been successfully added.");
	}

	public void insert(int index, String book) {
		if (index <= 0 || index > books.size() + 1) {
			JOptionPane.showMessageDialog(null, "Invalid index. Please provide a valid index.");
			return;
		}
		books.add(index - 1, book);
		undoStack.push(book);
		JOptionPane.showMessageDialog(null, book + " has been successfully inserted at index " + index + ".");
	}

	public void borrow() {
	    if (books.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No books in the library available to borrow.");
	    } else {
	        StringBuilder message = new StringBuilder("Available Books:\n");
	        for (int i = 0; i < books.size(); i++) {
	            message.append((i + 1)).append(". ").append(books.get(i)).append("\n");
	        }
	        
	        int indexToBorrow = Integer.parseInt(JOptionPane.showInputDialog(message + "\nEnter the index of the book you wish to borrow:"));
	        
	        if (indexToBorrow <= 0 || indexToBorrow > books.size()) {
	            JOptionPane.showMessageDialog(null, "Invalid index. Please provide a valid index.", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            String borrowedBook = books.remove(indexToBorrow - 1);
	            borrowedBooks.push(borrowedBook);  
	            JOptionPane.showMessageDialog(null, borrowedBook + " has been borrowed.");
	        }
	    }
	}

	public void returnBook() {
        if (borrowedBooks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books to return.", "Library Management System", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Display borrowed books to the user
            StringBuilder message = new StringBuilder("Borrowed Books:\n");
            for (int i = 0; i < borrowedBooks.size(); i++) {
                message.append((i + 1)).append(". ").append(borrowedBooks.get(i)).append("\n");
            }

            int returnIndex = Integer.parseInt(JOptionPane.showInputDialog(message + "\nEnter the index of the book you want to return:"));
            if (returnIndex <= 0 || returnIndex > borrowedBooks.size()) {
                JOptionPane.showMessageDialog(null, "Invalid index. Please select a valid borrowed book index.");
                return;
            }

            // Retrieve the book from borrowedBooks stack and return it to the library
            String returnedBook = borrowedBooks.remove(returnIndex - 1);
            books.add(returnedBook);  // Return the book to the books list
            JOptionPane.showMessageDialog(null, returnedBook + " has been successfully returned to the library.");
        }
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
		// Heap Sort implementation 
	public void sortBooks() {
		ArrayList<String> sortedBooks = new ArrayList<>(books);
		int n = sortedBooks.size();
		// Max heap structure
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(sortedBooks, n, i);
		}
		// Extract elements from heap 
		for (int i = n - 1; i > 0; i--) {
			// Move root to end 
			String temp = sortedBooks.get(0);
			sortedBooks.set(0, sortedBooks.get(i));
			sortedBooks.set(i, temp);
			// Call heapify 
			heapify(sortedBooks, i, 0);
		}

		if (sortedBooks.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No books available in the library.", "Library Management System", JOptionPane.INFORMATION_MESSAGE);
		} else {
			StringBuilder message = new StringBuilder("Books in the library (sorted):\n");
			for (int i = 0; i < sortedBooks.size(); i++) {
				message.append((i + 1)).append(". ").append(sortedBooks.get(i)).append("\n");
			}
			message.append("\nTotal number of books in the library: ").append(sortedBooks.size());
			JOptionPane.showMessageDialog(null, message.toString(), "Library Management System", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void heapify(ArrayList<String> sortedBooks, int n, int i) {
		int largest = i;  
		int left = 2 * i + 1;  
		int right = 2 * i + 2;  

		if (left < n && sortedBooks.get(left).compareTo(sortedBooks.get(largest)) > 0) {
			largest = left;
		}

		if (right < n && sortedBooks.get(right).compareTo(sortedBooks.get(largest)) > 0) {
			largest = right;
		}
		if (largest != i) {
			
			String swap = sortedBooks.get(i);
			sortedBooks.set(i, sortedBooks.get(largest));
			sortedBooks.set(largest, swap);
			heapify(sortedBooks, n, largest);
		}
	}

	public void undo() {
		if (undoStack.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No books available in the library");
		} else {
			String lastAddedBook = undoStack.pop(); // Pop the last added book 
			books.remove(lastAddedBook); // Remove the last added book 
			JOptionPane.showMessageDialog(null, lastAddedBook + " has been undone and removed from the library.");
		}
	}

	
	public static void main(String[] args) {
		LibraryManagementSystem lib = new LibraryManagementSystem();
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
				
			case 2:
			    lib.borrow();
			    break;
				
			case 3:
				int bookIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the index of the book you wish to search: "));

				try {
					JOptionPane.showMessageDialog(null, "Result: " + lib.books.get(bookIndex - 1));
				} catch (Exception IndexOutOfBoundsException) {
					JOptionPane.showMessageDialog(null, "Invalid! Index does not exist.");
				}   
				break;
				
			case 4:
				lib.returnBook();
				break;
				
			case 5: 
				int indexToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the index where you wish to remove the book: "));
				lib.remove(indexToRemove);
				break;


			case 6: 
				lib.size();
				break;
			
			case 7:
				if (lib.books.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No books available to sort.");
				} else {
					lib.sortBooks();  
				}
				break;
				
			case 8: 
				lib.undo();
				break;

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
