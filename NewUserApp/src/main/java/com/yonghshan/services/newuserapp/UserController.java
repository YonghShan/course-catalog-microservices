package com.yonghshan.services.newuserapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author YonghShan
 * @date 4/12/21 - 16:56
 */

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Value("${organization.name}")
    private String organizationName;

    @Value("${service.welcome.message}")
    private String serviceMessage;

    @RequestMapping("/")
    public String getUserAppHome() {
        //return ("User App Home");
        return (organizationName + "***" + serviceMessage);
    }

    @RequestMapping("/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

//    @RequestMapping("/{id}")
//    public List<User> getCoursesForUsers(@PathVariable("id")BigInteger id) {
//        return userRepository.findByuserid(id);
//    }

    @RequestMapping("/{id}")
    public List<User> getUsersForCourses(@PathVariable("id")BigInteger id) {
        return userRepository.findBycourseid(id);
    }

}
