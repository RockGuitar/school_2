package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

@Service
public interface StudentService {

    Student createStudent ( Student student );

    Student readStudent ( Long id );

    Student updateStudent ( Student student );

    void deleteStudent ( Long id );
}
