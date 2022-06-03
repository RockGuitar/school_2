package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController ( StudentService studentService ) {
        this.studentService = studentService;
    }

    @GetMapping("{studentKey}")
    public Student readStudent ( @PathVariable int studentKey ) {
        return studentService.readStudent(studentKey);
    }

    @PostMapping()
    public Student createStudent (
            @RequestParam("id") Long studentId,
            @RequestParam("name") String studentName,
            @RequestParam("age") int studentAge ) {
        return studentService.createStudent(studentId, studentName, studentAge);
    }

    @PutMapping
    public Student updateStudent ( @RequestParam("key") int studentKey, @RequestBody Student student ) {
        return studentService.updateStudent(studentKey, student);
    }

    @DeleteMapping
    public Student deleteStudent ( @RequestParam("key") int studentKey ) {
        return studentService.deleteStudent(studentKey);
    }

    @GetMapping
    public List<Student> filterStudent( @RequestParam("age")int age){
        return studentService.filterStudent(age);
    }
}
