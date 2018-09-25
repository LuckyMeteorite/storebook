package bookstore.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	
	ArrayList<String> books = new ArrayList<String>();
	
	@GetMapping("index")
	public String insertData(@RequestParam(required= false) String book, Model model) {
		
		if (book != null && book.length() >= 3) {
			books.add(book);
		}
		
		model.addAttribute("books", books);
		return "bookInfo";

		
	}
	

}
