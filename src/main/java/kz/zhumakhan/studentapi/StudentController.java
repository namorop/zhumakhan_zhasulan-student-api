package kz.zhumakhan.studentapi;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class StudentController {
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home() {
        return "Student API v1.1 by Zhumakhan Zhasulan";
    }

    @GetMapping("/api/students")
    public List<Student> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/students/{id}")
    public Student getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + id + " not found"));
    }

    @PostMapping("/api/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student s) {
        return repo.save(s);
    }
    @PutMapping("/api/students/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody Student s) {
        Student old = repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Student " + id + " not found"));
        old.setName(s.getName());
        old.setGroupName(s.getGroupName());
        return repo.save(old);
    }
    @DeleteMapping("/api/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
