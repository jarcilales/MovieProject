package com.test.movietest.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.test.movietest.Services.MovieServices;

@RestController
public class HomeController {

    @Autowired
    private MovieServices ;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent())
            throw new StudentNotFoundException("id-" + id);

        return student.get();
    }

}
