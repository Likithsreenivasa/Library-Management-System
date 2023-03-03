package StudentLibraryManagementVersion.demo.Services;


import StudentLibraryManagementVersion.demo.DTOs.AuthorEntryDto;
import StudentLibraryManagementVersion.demo.DTOs.AuthorResponseDto;
import StudentLibraryManagementVersion.demo.DTOs.BookResponseDto;
import StudentLibraryManagementVersion.demo.Models.Author;
import StudentLibraryManagementVersion.demo.Models.Book;
import StudentLibraryManagementVersion.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto)
    {
        Author author=new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());


        authorRepository.save(author);
        return "Author added successfully";

    }
    public AuthorResponseDto getAuthorId(Integer authorId)
    {
        Author author = authorRepository.findById(authorId).get();



        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDto> booksWrittenDto = new ArrayList<>();

        for(Book book : bookList)
        {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setPages(book.getPages());
            bookResponseDto.setName(book.getName());

            booksWrittenDto.add(bookResponseDto);

        }

        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());

        return authorResponseDto;
    }
}
