package StudentLibraryManagementVersion.demo.Services;

import StudentLibraryManagementVersion.demo.DTOs.StudentUpdateMobRequestDto;
import StudentLibraryManagementVersion.demo.Enums.CardStatus;
import StudentLibraryManagementVersion.demo.Models.Card;
import StudentLibraryManagementVersion.demo.Models.Student;
import StudentLibraryManagementVersion.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public String createStudent(Student student)
    {
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATE);
        card.setStudentVariableName(student);
        student.setCard(card);
        studentRepository.save(student);



        return "student and card successfully";
    }
    public String getUserByEmail(String email )
    {
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }
   public String updateMobNo(StudentUpdateMobRequestDto studentReq)
   {
       Student originalStudent=studentRepository.findById(studentReq.getId()).get();
       originalStudent.setMobNo(studentReq.getMobNo());
       studentRepository.save(originalStudent);
       return "student has been updated successfully";
   }



}
