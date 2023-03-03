package StudentLibraryManagementVersion.demo.Repositories;

import StudentLibraryManagementVersion.demo.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {



}
