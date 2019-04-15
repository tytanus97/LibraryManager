package mainpack.controller.book;

import mainpack.entity.Book;
import mainpack.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/details")
    public String getBookDetails(@RequestParam("bookId")int bookId, Model model) {
        Book book = bookService.findById(bookId);

        model.addAttribute("book",book);
        return "bookDetails";
    }
}
