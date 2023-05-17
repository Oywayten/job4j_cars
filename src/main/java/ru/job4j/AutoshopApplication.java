package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoshopApplication.class, args);
        System.out.println("Go to http://localhost:8091/index");
    }

}
