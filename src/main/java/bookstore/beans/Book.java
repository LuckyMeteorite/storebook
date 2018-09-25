package bookstore.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String writer;
	private String isbn;
	private int price;
	
	public Book() {}
	 
	public Book(String title, String writer, String isbn, int price ) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.writer = writer;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
		
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Student [title=" + title + ", lastname=" + writer + ",isbn"+ isbn+ " price=" + price + "]";
	}
	
	
	
}
