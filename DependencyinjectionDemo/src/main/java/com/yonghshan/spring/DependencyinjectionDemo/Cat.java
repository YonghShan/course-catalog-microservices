package com.yonghshan.spring.DependencyinjectionDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat extends Animal {

    public void makeSound() {
        System.out.println("Meow");
    }
}
