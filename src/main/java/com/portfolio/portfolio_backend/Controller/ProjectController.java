package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.Entity.Project;
import com.portfolio.portfolio_backend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project/{userId}")
    public List<Project> getProjectFromUser(@PathVariable Long userId){
        return projectRepository.findByUserId(userId);
    }
}
