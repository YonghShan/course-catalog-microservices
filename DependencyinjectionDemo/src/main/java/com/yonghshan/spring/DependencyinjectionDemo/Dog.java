package com.yonghshan.spring.DependencyinjectionDemo;

import org.springframework.stereotype.Component;

@Component
public class Dog extends Animal {

    String name;
    Double height;

    public Dog() {
        System.out.println("I am a Dog");
        name = "Jack";
    }

    public Dog(String name) {
        System.out.println("I am a Dog");
        this.name = name;
    }

    public Dog(Double height) {
        System.out.println("I am a Dog");
        this.height = height + 1;
        System.out.println("My height is " + height);
        System.out.println("My adjusted height is " + this.height);

    }

    public void makeSound() {

        System.out.println("Woof");
        System.out.println("My name is " + name);
    }

    public void makeSound(int var) {
        var = var + 2;
        System.out.println("Woof " + var);
    }

    public String makeSound(String var) {
        System.out.println("Woof " + var.toUpperCase());
        return "hello 123";

    }


}
