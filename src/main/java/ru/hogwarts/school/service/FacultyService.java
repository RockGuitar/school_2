package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface FacultyService {
    Map<Integer, Faculty> facultyMap = new HashMap<>();

    Faculty createFaculty ( Long facultyId, String facultyName, String facultyColor );

    Faculty readFaculty ( int facultyKey );

    Faculty updateFaculty ( int facultyKey, Faculty faculty );

    Faculty deleteFaculty ( int facultyKey );

    List<Faculty> filterFaculty ( String color );

}
