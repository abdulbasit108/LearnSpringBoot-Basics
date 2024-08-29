package com.abdulbasit108.LearnSpringBoot;

import java.util.Optional;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdulbasit108.LearnSpringBoot.model.User;
import com.abdulbasit108.LearnSpringBoot.model.UserRepository;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/user/save")
    public User createStudent(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/user/findByEmail")
    public User findStudent(@RequestParam("email") String email) {
        return repository.findByEmail(email);
    }
    
    @PatchMapping("/user/update")
    public User updateStudent(@RequestParam("student_id") String id, @RequestParam("new_email") String email) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            User studentObj = user.get();
            studentObj.setEmail(email);
            return repository.save(studentObj);
        }
        return null;

    }

    @GetMapping("/user/findByEmailDomain")
    public List<User> findStudentByDomain(@RequestParam("domain") String domain) {
        return repository.findByDomain(domain);
    }
}
