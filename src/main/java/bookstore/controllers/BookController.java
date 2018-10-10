package bookstore.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.model.Book;
import bookstore.model.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BookController {

	private ArrayList<String> books = new ArrayList<String>();

	@Autowired
	private BookRepository bookshelf;

	@GetMapping("bookinfo")
	public String insertData(@RequestParam(required = false) String book, Model model) {

		if (book != null && book.length() >= 3) {
			books.add(book);
		}

		model.addAttribute("books", books);
		return "bookinfo";
	}

	// ohjaa bookshelf sivulle
	@GetMapping("bookshelf")
	public String getList(@RequestParam(required = false) String book, Model model) {
		if (book != null && book.length() >= 3) {
			books.add(book);
		}
		model.addAttribute("bookshelf", bookshelf.findAll());
		return "bookshelf";
	}

	// lisää kirja
	@GetMapping("addbook")
	public String addBook(@RequestParam(required = false) String book, Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	// Save new book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookshelf.save(book);
		return "redirect:bookshelf";
	}

	// Delete book
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		System.out.println("heihei " + bookId );
		bookshelf.deleteById(bookId);
		return "redirect:/bookshelf";
	}

	// Delete book
	@GetMapping(value = "/delete")
	public String deleteBook2(Model model) {
		System.out.println("heihei2");
		return "redirect:/bookshelf";
	}
	
	//Error
	@GetMapping(value = "/error")
	public String errorMessage(Model model) {
		System.out.println("Error message ");
		return "error";
	}
	
	
	
	
	
}
