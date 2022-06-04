package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController ( FacultyService facultyService ) {
        this.facultyService = facultyService;
    }

    @GetMapping("{facultyKey}")
    public Faculty readFaculty ( @PathVariable Long facultyKey ) {
        return facultyService.readFaculty(facultyKey);
    }

    @PostMapping()
    public Faculty createFaculty (@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty updateFaculty ( @RequestBody Faculty faculty ) {
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping
    public void deleteFaculty ( @RequestParam("key") Long facultyKey ) {
        facultyService.deleteFaculty(facultyKey);
    }
}
