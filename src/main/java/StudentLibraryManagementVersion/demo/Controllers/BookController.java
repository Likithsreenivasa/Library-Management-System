package StudentLibraryManagementVersion.demo.Controllers;


import StudentLibraryManagementVersion.demo.DTOs.BookRequestDto;
import StudentLibraryManagementVersion.demo.Models.Book;
import StudentLibraryManagementVersion.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")


    public String addBook(@RequestBody BookRequestDto bookRequestDto)
    {
        return bookService.addBook(bookRequestDto);


    }





}
