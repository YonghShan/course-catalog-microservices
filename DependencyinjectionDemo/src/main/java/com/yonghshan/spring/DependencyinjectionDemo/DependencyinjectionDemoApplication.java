package com.yonghshan.spring.DependencyinjectionDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyinjectionDemoApplication {

    public static void main(String[] args) {
        // 未给Animal/AnimalSpeak...class加@Component，未给AnimalSpeak中的Animal成员加@Autowired之前的原始代码
		/* SpringApplication.run(DependencyinjectionDemoApplication.class, args);
		   System.out.println("Dependency Injection Demo");

		   AnimalSpeak obj1 = new AnimalSpeak() ;
		   Animal animal = new Dog();
		   obj1.setAnimal(animal);
		   obj1.makeSound();
		 */

        ApplicationContext applicationContext = SpringApplication.run(DependencyinjectionDemoApplication.class, args);
        System.out.println("Dependency Injection Demo");

        //AnimalSpeak obj1 = new AnimalSpeak() ;
        //Animal animal = new Dog();
        AnimalSpeak obj1 = applicationContext.getBean(AnimalSpeak.class);
        Animal animal = applicationContext.getBean(Animal.class);
        obj1.setAnimal(animal);
        obj1.makeSound();
    }

}
