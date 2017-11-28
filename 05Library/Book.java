public class Book {
    private String title,author,isbn;

    public Book() {
    }

    public Book(String author, String title, String isbn) {
	this.author = author;
	this.title = title;
	this.isbn = isbn;
    }

    public String getTitle() {
	return title;
    }
    public String getAuthor() {
	return author;
    }
    public String getISBN() {
	return isbn;
    }

    public String toString() {
	return title + "," + author + "," + isbn;
    }
}
