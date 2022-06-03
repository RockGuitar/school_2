package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    Map<Integer, Student> studentMap = new HashMap<>();

    Student createStudent ( Long studentId, String studentName, int studentAge );

    Student readStudent ( int studentKey );

    Student updateStudent ( int studentKey, Student student );

    Student deleteStudent ( int studentKey );

    List<Student> filterStudent( int age);
}
