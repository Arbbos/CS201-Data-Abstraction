
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
        if (index <= 0 || index > books.size() + 1) {
            System.out.println("Invalid index. Please provide a valid index.");
            return;
        }
        books.add(index - 1, book);
        System.out.println(book + " has been successfully inserted at index " + index + ".");
    }
	
	public void remove(int index) {
		if (index < 0 || index >= books.size()) {
			// https://www.geeksforgeeks.org/array-index-out-of-bounds-exception-in-java/ 
			// for handling invalid index
			throw new IndexOutOfBoundsException("Invalid index. Please provide a valid index");
		}
		String removedBook = books.remove(index);
        	System.out.println(removedBook + " has been successfully removed.");
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

	                case 2:
	                    	if (lib.books.isEmpty()) {
	                        	System.out.println("No books to show.");
	                    	} else {
	                        	System.out.println("Enter the index where you wish to insert the book:");
	                        	int index = scan.nextInt();
	                        	scan.nextLine(); // Consume the newline
	                        if (index <= 0 || index > lib.books.size() + 1) {
	                            System.out.println("Invalid index. Please provide a valid index.");
	                        } else {
	                            	System.out.println("Enter the name of the book you want to insert: ");
	                            	String bookToInsert = scan.nextLine();
	                            	lib.insert(index, bookToInsert);
	                       	 	}
	                    	}
	                    break;

			case 3: 
				System.out.print("Enter the index where you wish to remove the book: ");
                    		int indexToRemove = scan.nextInt();
                    		scan.nextLine();
                    		lib.remove(indexToRemove);
                    		break;

			case 4:
				System.out.println("Enter the index of the book you wish to search: ");
				int bookIndex = scan.nextInt();
			    
    		    		try {
    			    		if (bookIndex > lib.books.size()) {
    			        
    					} else {
    			        		System.out.println("Result: " + lib.books.get(bookIndex));
    		        		} 
    				} catch (Exception IndexOutOfBoundsException) {
    			    		System.out.println("Invalid! Index does not exist.");
    				}   
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
