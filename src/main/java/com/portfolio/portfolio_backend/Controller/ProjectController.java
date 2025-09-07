package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.DTO.ProjectDto;
import com.portfolio.portfolio_backend.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/{userId}")
    public ResponseEntity<List<ProjectDto>> getProjectFromUser(@PathVariable Long userId){

        return ResponseEntity.ok(projectService.getProjectfromId(userId));
    }
}
