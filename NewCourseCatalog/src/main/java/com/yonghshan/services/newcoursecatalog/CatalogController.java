package com.yonghshan.services.newcoursecatalog;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author YonghShan
 * @date 4/4/21 - 17:20
 */

@RestController
public class CatalogController {
    @Autowired
    private EurekaClient client;

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalogHome() {
        String courseAppMessage = "";
        //String courseAppURL = "http://localhost:8080/";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("newcourse-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        RestTemplate restTemplate = new RestTemplate();
        courseAppMessage = restTemplate.getForObject(courseAppURL, String.class);

        return ("Welcome to YonghShan Course Catalog " + courseAppMessage);
    }

    public String displayDefaultHome() {
        return ("Welcome to YonghShan Course Catalog." + "Please try after some time.");
    }

    @RequestMapping("/catalog")
    public String getCatalog() {
        String courses = "";
        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("newcourse-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/courses"; // 因为上面Hardcoding的URL比起HomePageUrl（localhost:8080）多了一个"/courses"
        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL, String.class);

        return ("Our courses are " + courses);
    }

    @RequestMapping("/firstcourse")
    public String getSpecificCourse() {
        Course course = new Course();
        User user = new User();
        //String courseAppURL = "http://localhost:8080/1";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("newcourse-service", false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/1"; // 因为上面Hardcoding的URL比起HomePageUrl（localhost:8080）多了一个"/1"
        RestTemplate restTemplate = new RestTemplate();
        course = restTemplate.getForObject(courseAppURL, Course.class);

        instanceInfo = client.getNextServerFromEureka("newuser-service", false);
        String userAppURL = instanceInfo.getHomePageUrl();
        userAppURL = userAppURL + "/" + course.getCourseid();
        String usersList = restTemplate.getForObject(userAppURL, String.class);

        return ("Our first course is " + course.getCoursename() + " and Enrolled users are " + usersList);
    }

}
