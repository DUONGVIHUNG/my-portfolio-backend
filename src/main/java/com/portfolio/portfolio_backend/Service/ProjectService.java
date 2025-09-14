package com.portfolio.portfolio_backend.Service;

import com.portfolio.portfolio_backend.DTO.ProjectDto;
import com.portfolio.portfolio_backend.Entity.Project;
import com.portfolio.portfolio_backend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;



@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    private Optional<Project> projectOptional;
//
//    private List<Optional<ProjectDto>> projectDtos = new ArrayList<>();
//
//    private Optional<ProjectDto> projectDto;
//
//    private List<Project> projects = new ArrayList<>();

    public List<ProjectDto> getProjectfromId(Long id){

        List<Project> projects = projectRepository.findByUserId(id);

            return projects.stream()
                            .map(this::convertToDto)
                                    .toList();


    }

    private ProjectDto convertToDto(Project project){
        List<String> lesson = Arrays.stream(project.getLessonLearn().split(","))
                .map(String::trim)
                .toList();

        List<String> techStack = Arrays.stream(project.getTechStack().split(","))
                .map(String::trim)
                .toList();

        List<String> projectPhase = Arrays.stream(project.getProjectPhase().split(","))
                .map(String::trim)
                .toList();

        return new ProjectDto(
                project.getId(),
                project.getProjectName(),
                project.getStartDate(),
                project.getEndDate(),
                project.getDetail(),
                techStack,
                project.getProjectSize(),
                project.getMyRole(),
                lesson,
                projectPhase
        );

    }


}
