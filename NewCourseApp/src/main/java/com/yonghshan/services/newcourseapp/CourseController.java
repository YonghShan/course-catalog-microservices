package com.yonghshan.services.newcourseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * @author YonghShan
 * @date 3/30/21 - 15:52
 */

@RestController
@RefreshScope
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Value("${organization.name}")
    private String organizationName;

    @Value("${service.welcome.message}")
    private String serviceMessage;

    @RequestMapping("/")
    public String getCourseAppHome() {
        //return ("Course App Home");
        return (organizationName + "***" + serviceMessage);
    }

    @RequestMapping("/courses")
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id) {
        return courseRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void saveCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteCourse(@PathVariable BigInteger id) {
        courseRepository.deleteById(id);
    }
}
