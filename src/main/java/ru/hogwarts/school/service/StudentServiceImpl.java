package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private int studentCounter;

    public void checkStudentKey ( int studentKey ) {
        if (studentKey >= studentCounter) {
            throw new IllegalArgumentException();
        }
    }

    public Student createStudent ( Long studentId, String studentName, int studentAge ) {
        Student newStudent = new Student(studentId, studentName, studentAge);
        studentMap.put(studentCounter, newStudent);
        studentCounter++;
        return newStudent;
    }

    public Student readStudent ( int studentKey ) {
        checkStudentKey(studentKey);
        return studentMap.get(studentKey);
    }

    public Student updateStudent ( int studentKey, Student student ) {
        checkStudentKey(studentKey);
        return studentMap.put(studentKey, student);
    }

    public Student deleteStudent ( int studentKey ) {
        checkStudentKey(studentKey);
        Student deletedStudent = studentMap.get(studentKey);
        studentMap.remove(studentKey);
        studentCounter--;
        return deletedStudent;
    }

    public List<Student> filterStudent( int age){
        List<Student> studentList = new ArrayList<>(studentMap.values());
        return studentList.stream().filter(student -> student.getAge()==age).collect(Collectors.toList());
    }

}
