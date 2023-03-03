package StudentLibraryManagementVersion.demo.Controllers;


import StudentLibraryManagementVersion.demo.DTOs.StudentUpdateMobRequestDto;
import StudentLibraryManagementVersion.demo.Models.Student;
import StudentLibraryManagementVersion.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return "student and card created";
    }
    @GetMapping("/get_user")

        public String getNameBy(@RequestParam("email")String email)
        {
            return studentService.getUserByEmail(email);
        }
        @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentReqDto)
        {
            return studentService.updateMobNo(studentReqDto);

        }


}
