package com.portfolio.portfolio_backend.Controller;

import com.portfolio.portfolio_backend.DTO.UserDto;
import com.portfolio.portfolio_backend.Entity.User;
import com.portfolio.portfolio_backend.Repository.UserRepository;
import com.portfolio.portfolio_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://localhost:5173")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public User getTestUser() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setName("Test User");
        testUser.setJobTitle("Test Title");
        return testUser;
    }



    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserbyId(userId));
    }


}
