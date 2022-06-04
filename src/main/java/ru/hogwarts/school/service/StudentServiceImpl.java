package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl ( StudentRepository studentRepository ) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent ( Student student ) {
        return studentRepository.save(student);
    }

    public Student readStudent ( Long id ) {return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent ( Student student ) {
        return studentRepository.save(student);
    }

    public void deleteStudent ( Long id ) {
        studentRepository.deleteById(id);
    }


}
