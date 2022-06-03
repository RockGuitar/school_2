package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private int facultyCounter;

    public void checkFacultyCounter ( int facultyKey ) {
        if (facultyKey >= facultyCounter) {
            throw new IllegalArgumentException();
        }
    }

    public Faculty createFaculty ( Long facultyId, String facultyName, String facultyColor ) {

        Faculty newFaculty = new Faculty(facultyId, facultyName, facultyColor);
        facultyMap.put(facultyCounter, newFaculty);
        facultyCounter++;
        return newFaculty;
    }

    public Faculty readFaculty ( int facultyKey ) {
        checkFacultyCounter(facultyKey);
        return facultyMap.get(facultyKey);
    }

    public Faculty updateFaculty ( int facultyKey, Faculty faculty ) {
        checkFacultyCounter(facultyKey);
        return facultyMap.put(facultyKey, faculty);
    }

    public Faculty deleteFaculty ( int facultyKey ) {
        checkFacultyCounter(facultyKey);
        Faculty deletedFaculty = facultyMap.get(facultyKey);
        facultyMap.remove(facultyKey);
        facultyCounter--;
        return deletedFaculty;
    }

    public List<Faculty> filterFaculty(String color){
        List<Faculty> facultyList = new ArrayList<>(facultyMap.values());
        return facultyList.stream().filter(faculty -> faculty.getColor().equals(color)).collect(Collectors.toList());
    }
}
