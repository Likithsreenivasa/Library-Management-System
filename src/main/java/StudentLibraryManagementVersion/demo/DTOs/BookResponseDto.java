package StudentLibraryManagementVersion.demo.DTOs;

import StudentLibraryManagementVersion.demo.Enums.Genre;

public class BookResponseDto {
    private int pages;
    private String name;
    private Genre genre;

    private int authorId;


    public BookResponseDto()
    {

    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


}
