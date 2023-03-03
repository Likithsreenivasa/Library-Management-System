package StudentLibraryManagementVersion.demo.Repositories;


import StudentLibraryManagementVersion.demo.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Integer> {




}
