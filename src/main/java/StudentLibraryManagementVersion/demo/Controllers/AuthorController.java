package StudentLibraryManagementVersion.demo.Controllers;

import StudentLibraryManagementVersion.demo.DTOs.AuthorEntryDto;
import StudentLibraryManagementVersion.demo.DTOs.AuthorResponseDto;
import StudentLibraryManagementVersion.demo.Models.Author;
import StudentLibraryManagementVersion.demo.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto)
    {

        return authorService.createAuthor(authorEntryDto);
    }
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId)
    {
        return authorService.getAuthorId(authorId);

    }


}
