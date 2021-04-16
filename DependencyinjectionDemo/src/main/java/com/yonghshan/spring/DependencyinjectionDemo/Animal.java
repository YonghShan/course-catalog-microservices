package com.yonghshan.spring.DependencyinjectionDemo;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    void makeSound() {
        System.out.println("I am an animal");
    }

    ;
}
