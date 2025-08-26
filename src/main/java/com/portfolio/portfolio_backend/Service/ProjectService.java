package com.portfolio.portfolio_backend.Service;

import com.portfolio.portfolio_backend.DTO.ProjectDto;
import com.portfolio.portfolio_backend.Entity.Project;
import com.portfolio.portfolio_backend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private Optional<Project> projectOptional;

    private List<Optional<ProjectDto>> projectDtos = new ArrayList<>();

    private Optional<ProjectDto> projectDto;

    private List<Project> projects = new ArrayList<>();

    public List<Optional<ProjectDto>> getProjectfromId(Long id){

        projects = projectRepository.findByUserId(id);


        for (Project project: projects){
            projectOptional = Optional.of(project);
            projectDto = projectOptional.map(p->{
                List<String> lesson = Arrays.stream(p.getLessonLearn().split(","))
                        .map(String::trim)
                        .toList();

                List<String> techStack = Arrays.stream(p.getTechStack().split(","))
                        .map(String::trim)
                        .toList();

                return new ProjectDto(
                        p.getId(),
                        p.getProjectName(),
                        p.getStartDate(),
                        p.getEndDate(),
                        p.getDetail(),
                        techStack,
                        p.getProjectSize(),
                        p.getMyRole(),
                        lesson
                );

            });

            projectDtos.add(projectDto);



        }

        return projectDtos;


    }

}
