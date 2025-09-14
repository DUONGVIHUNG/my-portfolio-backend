package com.portfolio.portfolio_backend.Service;

import com.portfolio.portfolio_backend.DTO.UserDto;
import com.portfolio.portfolio_backend.Entity.User;
import com.portfolio.portfolio_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto getUserbyId(Long id){
        User user = userRepository.findById(id).orElse(null);

        assert user != null;
        return convertIntoDto(user);

    }

    public UserDto convertIntoDto(User user){

        List<String> frontEnd = Arrays.stream(user.getFrontEnd().split(","))
                .map(String::trim)
                .toList();

        List<String> backEnd = Arrays.stream(user.getBackEnd().split(","))
                .map(String::trim)
                .toList();

        List<String> tool = Arrays.stream(user.getTool().split(","))
                .map(String::trim)
                .toList();

        List<String> learning = Arrays.stream(user.getLearning().split(","))
                .map(String::trim)
                .toList();

        List<String> cert = Arrays.stream(user.getCert().split(","))
                .map(String::trim)
                .toList();

        Integer certNums = cert.size();

        Integer projectNums = user.getProjects().size();

//        {
//            "userId": 1,
//                "name": "DUONG VI HUNG(ズン　ヴィ　フン)",
//                "jobTitle": "ブリッジSE(BrSE)",
//                "company": "VTIジャパン株式会社",
//                "startDate": "2023-04",
//                "endDate": "現在",
//                "selfPr": "pr_sample",
//                "cvUrl": "cv_url",
//                "githubUrl": "github_url"
//        }



        return new UserDto(
                user.getId(),
                user.getName(),
                user.getJobTitle(),
                user.getCompany(),
                user.getStartDate(),
                user.getEndDate(),
                user.getSelfPr(),
                user.getCvUrl(),
                user.getGithubUrl(),
                user.getYearExp(),
                projectNums,
                certNums,
                cert,
                frontEnd,
                backEnd,
                tool,
                learning
        );

    }

}
