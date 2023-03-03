package StudentLibraryManagementVersion.demo.DTOs;

public class AuthorEntryDto {
    private String name;

    private int age;

    private String country;

    private double rating;

    public String getName() {
        return name;
    }
    public AuthorEntryDto() {
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
