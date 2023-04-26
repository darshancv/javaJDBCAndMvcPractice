package entity;

public class Book {
	private int id;
	private String name;
	private int rating;
	private String language;
	private String category;
	private String author;
	private int noOfCopies;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, int rating, String language, String category, String author, int noOfCopies) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.language = language;
		this.category = category;
		this.author = author;
		this.noOfCopies = noOfCopies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", rating=" + rating + ", language=" + language + ", category="
				+ category + ", author=" + author + ", noOfCopies=" + noOfCopies + "]";
	}

}
