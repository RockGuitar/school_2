package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;

import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController ( StudentService studentService ) {
        this.studentService = studentService;
    }

    @GetMapping("{studentKey}")
    public Student readStudent ( @PathVariable Long studentKey ) {
        return studentService.readStudent(studentKey);
    }

    @PostMapping()
    public Student createStudent ( @RequestBody Student student ) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student updateStudent ( @RequestBody Student student ) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping
    public void deleteStudent ( @RequestParam("key") Long studentKey ) {
        studentService.deleteStudent(studentKey);
    }
}

