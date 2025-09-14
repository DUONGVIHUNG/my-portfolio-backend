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
public class UserDto {

//    Sample:
//    {
//            "id":1,
//            "name": "Alex Johnson",
//            "jobTitle": "Senior Full-Stack Developer",
//            "companyName": "Tech Innovations Inc.",
//            "startDate": "2020-05-15",
//            "endDate": "Current",
//            "shortIntro": "A passionate full-stack developer with 5+ years of experience building scalable applications using Java and Spring Boot. I specialize in crafting clean, efficient, and maintainable code.",
//            "cvLink": "https://your-domain.com/Alex-Johnson-CV.pdf",
//            "githubLink": "https://github.com/alex-johnson-dev"
//    }

    private Long userId;
    private String name;
    private String jobTitle;
    private String company;
    private String startDate;
    private String endDate;
    private String selfPr;
    private String cvUrl;
    private String githubUrl;
    private Integer yearExp;
    private Integer projectNums;
    private Integer certNums;
    private List<String> cert;
    private List<String> frontEnd;
    private List<String> backEnd;
    private List<String> tool;
    private List<String> learning;
}
