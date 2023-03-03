package StudentLibraryManagementVersion.demo.Services;

import StudentLibraryManagementVersion.demo.DTOs.BookRequestDto;
import StudentLibraryManagementVersion.demo.Models.Author;
import StudentLibraryManagementVersion.demo.Models.Book;
import StudentLibraryManagementVersion.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class BookService {
    @Autowired
    AuthorRepository authorRepository;


    public String addBook(BookRequestDto bookRequestDto)
    {
        int authorId=bookRequestDto.getAuthorId();

        Author author=authorRepository.findById(authorId).get();
        Book book=new Book();
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());


        book.setAuthor(author);
        List<Book>currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);



        authorRepository.save(author);



        return "Book added Successfully ";


    }


}
