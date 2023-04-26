package service;

import java.util.Map;

import entity.Book;

public interface BookService {

	public void insertBooks(Book b);

	public Map<Integer, Book> displayBookByLanguage();

	public void searchBookByAuthorName(String authorName);

	public void updatCopies();

	public void displayAllBooksDetails();


	

}
