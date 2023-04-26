package client;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import entity.Book;
import service.BookService;
import service.BookServiceImpl;

public class LibraryBookApp {
	static Scanner sc = new Scanner(System.in);
	static BookService bookService = new BookServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt = 0;
		do {

			opt = displayMenu();
			switch (opt) {
			case 1:
				addBook();
				break;
			case 2:

				Map<Integer, Book> mp = new LinkedHashMap<>();
				mp = bookService.displayBookByLanguage();
				for (Book books : mp.values()) {
					System.out.println( books);
				}
				break;
			case 3:
				System.out.println("Enter the author: ");
				sc.nextLine();
				String authorName = sc.nextLine();
				bookService.searchBookByAuthorName(authorName);
				break;
			case 4:
				bookService.updatCopies();
				break;
			case 5:
				bookService.displayAllBooksDetails();
			case 6:
				System.out.println("End!");
				break;
			default:
				System.out.println("Enter the option properly!");
			}

		} while (opt != 6);

	}

	private static void addBook() {
		// TODO Auto-generated method stub
		System.out.println("Enter book details:");
		System.out.println();

		System.out.println("Enter book id:");
		int id = sc.nextInt();
		System.out.println("Enter Book Name:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter book rating: ");
		int rating = sc.nextInt();
		System.out.println("Enter language: ");
		sc.nextLine();
		String language = sc.nextLine();
		System.out.println("Enter category: ");
		String category = sc.nextLine();
		System.out.println("Enter author");
		String author = sc.nextLine();
		System.out.println("Enter the no of copies: ");
		int noOfCopies = sc.nextInt();
		Book b = new Book(id, name, rating, language, category, author, noOfCopies);
		bookService.insertBooks(b);

	}

	private static int displayMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"enter the option:\n1)add book \n2)display book by language \n3)search book by author \n4)update no of copies \n5)Display all book details \n6)exit");
		int opt = sc.nextInt();
		return opt;

	}

}
