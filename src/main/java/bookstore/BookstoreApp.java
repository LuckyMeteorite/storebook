package bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.model.Book;
import bookstore.model.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApp {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApp.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApp.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository bookshelf) {
		return (args) -> {
			log.info("save a couple books");

			bookshelf.save(new Book("heppamaailma", "minä itte", "12", 4));
			bookshelf.save(new Book("joulu tuli aikaisin", "emmää tiiä", "14", 6));
			bookshelf.save(new Book("heppamaailma 2", "minä itte", "15", 4));

			log.info("fetch all students");
			for (Book book : bookshelf.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
