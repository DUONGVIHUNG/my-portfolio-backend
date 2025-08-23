package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.Entity.Project;
import com.portfolio.portfolio_backend.Entity.User;
import com.portfolio.portfolio_backend.Repository.ProjectRepository;
import com.portfolio.portfolio_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/test")
    public User getTestUser() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setName("Test User");
        testUser.setJobTitle("Test Title");
        return testUser;
    }

    @GetMapping("/user")
    public User getUser(){
        return userRepository.findById(1L).orElse(null);
    }

    @GetMapping("/projects/{userId}")
    public List<Project> getProjectByUser(@PathVariable Long userId){
        return projectRepository.findByUserId(userId);
    }

}
