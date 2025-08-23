package com.portfolio.portfolio_backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String startDate;
    private String endDate;

    @Column(name = "my_role")
    private String myRole;

    @Column(name = "detail",columnDefinition = "TEXT")
    private String detail;

    @Column(name = "tech_stack",columnDefinition = "TEXT")
    private String techStack;

    @Column(name = "project_size")
    private String projectSize;

    @Column(name = "lesson_learn_")
    private String lessonLearn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;


}
