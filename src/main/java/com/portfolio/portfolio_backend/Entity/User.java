package com.portfolio.portfolio_backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String jobTitle;

    @Column(name ="job_intro", columnDefinition = "TEXT")
    private String jobIntro;
    @Column(name = "self_pr", columnDefinition = "TEXT")
    private String selfPr;

    private String cvUrl;
    private String githubUrl;
    private String company;
    private String startDate;
    private String endDate;

//    New field
    @Column(name = "year_exp")
    private Integer yearExp;
    @Column(name = "certification")
    private String cert;

    @Column(name = "frontend_tech")
    private String frontEnd;
    @Column(name = "backend_tech")
    private String backEnd;

    @Column(name = "tool")
    private String tool;
    @Column(name = "learning")
    private String learning;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Project> projects;


}
