package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController ( FacultyService facultyService ) {
        this.facultyService = facultyService;
    }

    @GetMapping("{facultyKey}")
    public Faculty readFaculty ( @PathVariable int facultyKey ) {
        return facultyService.readFaculty(facultyKey);
    }

    @PostMapping()
    public Faculty createFaculty (
            @RequestParam("id") Long facultyId,
            @RequestParam("name") String facultyName,
            @RequestParam("color") String facultyColor ) {
        return facultyService.createFaculty(facultyId, facultyName, facultyColor);
    }

    @PutMapping
    public Faculty updateFaculty ( @RequestParam("key") int facultyKey, @RequestBody Faculty faculty ) {
        return facultyService.updateFaculty(facultyKey, faculty);
    }

    @DeleteMapping
    public Faculty deleteFaculty ( @RequestParam("key") int facultyKey ) {
        return facultyService.deleteFaculty(facultyKey);
    }

    @GetMapping
    public List<Faculty> filterFaculty(@RequestParam("color")String color){
        return facultyService.filterFaculty(color);
    }
}
