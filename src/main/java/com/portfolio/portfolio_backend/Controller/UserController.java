package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.DTO.UserDto;
import com.portfolio.portfolio_backend.Entity.User;
import com.portfolio.portfolio_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/test")
    public User getTestUser() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setName("Test User");
        testUser.setJobTitle("Test Title");
        return testUser;
    }

    @GetMapping("/test2")
    public User getTestUser2(){
        return userRepository.findById(1L).orElse(null);
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(){

        User user = userRepository.findById(1L).orElse(null);

        if (user == null)
        {
            return ResponseEntity.notFound().build();
        }

        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getJobTitle(),
                user.getCompany(),
                user.getStartDate(),
                user.getEndDate(),
                user.getSelfPr(),
                user.getCvUrl(),
                user.getGithubUrl()
        );

        return ResponseEntity.ok(userDto);
    }


}
