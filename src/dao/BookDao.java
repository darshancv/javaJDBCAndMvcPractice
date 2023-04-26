package dao;

import java.util.Map;

import entity.Book;
import exception.BookDaoException;

public interface BookDao {

	public void insertBooks(Book b) throws BookDaoException;

	public Map<Integer, Book> displayBookByLanguage();

	public void searchBookByAuthorName(String authorName);

	public void updatCopies();

	public void displayAllBooksDetails();

	

}
