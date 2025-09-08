package com.portfolio.portfolio_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

//    {
//        "projectId": 1,
//        "projectName": "E-Commerce Platform Redesign",
//        "startDate": "2022-09-01",
//        "endDate": "2023-03-31",
//        "detail": "Led the full-stack development of a new e-commerce platform, focusing on improving user experience and scalability. Implemented a microservices architecture for handling inventory and order processing, which increased transaction throughput by 30%.",
//        "techStack": "Java, Spring Boot, React, PostgreSQL, AWS S3, Docker"],
//        "size": "5 members",
//        "role": "Lead Developer",
//         "lessonsLearned": "
//        Mastered the complexities of microservices communication and service discovery.,
//                "Gained hands-on experience with cloud deployment and containerization using Docker."
//
//    },

    private Long projectId;
    private String projectName;
    private String startDate;
    private String endDate;
    private String detail;
    private List<String> techStack;
    private String projectSize;
    private String projectRole;
    private List<String> lessonLearned;
    private List<String> projectPhase;


}
