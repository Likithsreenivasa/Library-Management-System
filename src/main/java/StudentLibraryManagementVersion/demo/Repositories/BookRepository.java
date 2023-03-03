package StudentLibraryManagementVersion.demo.Repositories;

import StudentLibraryManagementVersion.demo.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {




}
