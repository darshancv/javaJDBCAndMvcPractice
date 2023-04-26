package service;

import java.util.Map;

import dao.BookDao;
import dao.BookDaoImpl;
import entity.Book;
import exception.BookDaoException;

public class BookServiceImpl implements BookService {
	BookDao bd = new BookDaoImpl();

	@Override
	public void insertBooks(Book b) {
		// TODO Auto-generated method stub
		try {
			bd.insertBooks(b);
		} catch (BookDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<Integer, Book> displayBookByLanguage() {
		// TODO Auto-generated method stub
		
		return this.bd.displayBookByLanguage();
	}

	@Override
	public void searchBookByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		bd.searchBookByAuthorName(authorName);

	}

	@Override
	public void updatCopies() {
		bd.updatCopies();
	}

	@Override
	public void displayAllBooksDetails() {
		bd.displayAllBooksDetails();
	}

}
